package com.huifer.jenkinsspringboot.service.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huifer.jenkinsspringboot.config.WakaApiUrlConfig;
import com.huifer.jenkinsspringboot.entity.db.*;
import com.huifer.jenkinsspringboot.entity.wakarest.DurationsRest;
import com.huifer.jenkinsspringboot.entity.wakarest.HeartRest;
import com.huifer.jenkinsspringboot.entity.wakarest.HistorySeven;
import com.huifer.jenkinsspringboot.entity.wakarest.ProjectRest;
import com.huifer.jenkinsspringboot.mapper.HeartPOMapper;
import com.huifer.jenkinsspringboot.mapper.HistorySevenPOMapper;
import com.huifer.jenkinsspringboot.mapper.UserDurationsPOMapper;
import com.huifer.jenkinsspringboot.mapper.UserProjectPOMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class WakaSpider {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WakaApiUrlConfig wakaApiUrlConfig;
    @Autowired
    private HeartPOMapper heartMapper;

    @Autowired
    private UserProjectPOMapper userProjectMapper;

    @Autowired
    private UserDurationsPOMapper userDurationsMapper;

    @Autowired
    private HistorySevenPOMapper historySevenPOMapper;




    public HistorySeven historySeven(String apiKey) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("api_key", apiKey);
        ResponseEntity<String> exchange = restTemplate.exchange(
                wakaApiUrlConfig.getHositorySeven() + "?api_key={api_key}",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                String.class,
                maps
        );
        String body = exchange.getBody();
        JSONObject object = JSONObject.parseObject(body);
        HistorySeven historySeven = object.toJavaObject(HistorySeven.class);
        return historySeven;
    }


    public void deletHistory(String apiKey) {
        historySevenPOMapper.deleteByApiKey(apiKey);
    }

    public void getAndSetHistorySeven(String apiKey) {
        HistorySeven historySeven = historySeven(apiKey);
        insertHistorySeven(historySeven, apiKey);
    }

    private void insertHistorySeven(HistorySeven historySeven, String apiKey) {
        List<HistorySeven.DataBean.ProjectsBean> projects = historySeven.getData().getProjects();

        for (HistorySeven.DataBean.ProjectsBean project : projects) {
            HistorySevenPO historySevenPO = new HistorySevenPO();
            historySevenPO.setDigital(project.getDigital());
            historySevenPO.setHours(project.getHours());
            historySevenPO.setMinutes(project.getMinutes());
            historySevenPO.setName(project.getName());
            historySevenPO.setPercent(new BigDecimal(project.getPercent()));
            historySevenPO.setText("");
            historySevenPO.setTotalSeconds(new BigDecimal(project.getTotalSeconds()));
            historySevenPO.setApiKey(apiKey);
            insertHistoryProject(historySevenPO);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void insertHistoryProject(HistorySevenPO historySevenPO) {


        HistorySevenPO byApiKeyAndProName = historySevenPOMapper.findByApiKeyAndProName(historySevenPO.getApiKey(), historySevenPO.getName());
        if (byApiKeyAndProName == null) {
            historySevenPOMapper.insert(historySevenPO);
        } else {
            historySevenPOMapper.updateByApiKeyAndName(historySevenPO);
        }
    }


    /**
     * 用户信息接口
     *
     * @param apiKey
     * @return
     */
    public WakaUserinfoPO userInfo(String apiKey) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("api_key", apiKey);
        ResponseEntity<String> exchange = restTemplate.exchange(
                wakaApiUrlConfig.getUserInfoUrl() + "?api_key={api_key}",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                String.class,
                maps
        );
        String body = exchange.getBody();
        JSONObject object = JSONObject.parseObject(body);
        JSONObject data = object.getJSONObject("data");
        WakaUserinfoPO wakaUserinfoPO = data.toJavaObject(WakaUserinfoPO.class);
        wakaUserinfoPO.setApiKey(apiKey);
        return wakaUserinfoPO;
    }


    public void getAndSetProjects(String apiKey) {
        ProjectRest projects = projects(apiKey);
        insertUserProject(apiKey, projects);
    }

    /**
     * 访问projects接口
     *
     * @return
     */
    public ProjectRest projects(String apiKey) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("api_key", apiKey);
        log.info("访问 project 接口参数={}", maps);
        ResponseEntity<String> forEntity = restTemplate.exchange(
                wakaApiUrlConfig.getProjectUrl() + "?api_key={api_key}",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                String.class,
                maps
        );

        String body = forEntity.getBody();
        JSONObject object = JSONObject.parseObject(body);
        ProjectRest projectRest = object.toJavaObject(ProjectRest.class);

        return projectRest;
    }

    /**
     * 用户项目信息下载
     *
     * @param apiKey
     * @param projectRest
     */
    private void insertUserProject(String apiKey, ProjectRest projectRest) {
        List<ProjectRest.ProjectData> data = projectRest.getData();
        for (ProjectRest.ProjectData datum : data) {
            UserProjectPO userProjectPO = new UserProjectPO();
            userProjectPO.setCreatedAt(datum.getCreated_at());
            userProjectPO.setHtmlEscapedName(datum.getHtml_escaped_name());
            userProjectPO.setId(datum.getId());
            userProjectPO.setName(datum.getName());
            userProjectPO.setRepository(datum.getRepository());
            userProjectPO.setUrl(datum.getUrl());
            userProjectPO.setApiKey(apiKey);

            insertUserPro(userProjectPO);
        }
    }


    @Transactional(rollbackFor = Exception.class)
    public void insertUserPro(UserProjectPO userProjectPO) {
        UserProjectPO upro = userProjectMapper.findAllConditions(userProjectPO);
        if (upro == null) {
            userProjectMapper.insert(userProjectPO);
        }
    }


    /**
     * 访问durations并且设置数据库
     *
     * @param date
     * @param apiKey
     * @param proUserId
     */
    public void getAndSetDurations(String date, String apiKey, Integer proUserId) {
        DurationsRest durationsRest = durations(date, apiKey, proUserId);
        List<DurationsRest.DurationsRestData> data = durationsRest.getData();
        for (DurationsRest.DurationsRestData datum : data) {
            UserDurationsPO userDurationsPO = new UserDurationsPO();
            userDurationsPO.setCreatedAt(datum.getCreated_at());
            userDurationsPO.setCursorpos(datum.getCursorpos());
            userDurationsPO.setDuration(datum.getDuration());
            userDurationsPO.setId(datum.getId());
            userDurationsPO.setLineno(datum.getLineno());
            userDurationsPO.setMachineNameId(datum.getMachine_name_id());
            userDurationsPO.setProject(datum.getProject());
            userDurationsPO.setTime(datum.getTime());
            userDurationsPO.setUserId(datum.getUser_id());
            userDurationsPO.setApiKey(apiKey);
            userDurationsPO.setDay(date);
            insertDuration(userDurationsPO);
        }

    }

    public DurationsRest durations(String date, String apiKey, Integer proUserId) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("date", date);
        maps.put("api_key", apiKey);
        log.info("访问 durations 接口参数={}", maps);
        ResponseEntity<String> forEntity = restTemplate.exchange(
                wakaApiUrlConfig.getDurationUrl() + "?date={date}&api_key={api_key}",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                String.class,
                maps
        );
        String body = forEntity.getBody();
        JSONObject object = JSONObject.parseObject(body);
        DurationsRest durationsRest = object.toJavaObject(DurationsRest.class);


        return durationsRest;
    }

    @Transactional(rollbackFor = Exception.class)
    public void insertDuration(UserDurationsPO userDurations) {
        userDurationsMapper.insert(userDurations);
    }

    /**
     * 访问heart接口并且放入数据库
     *
     * @param date
     * @param apiKey
     * @param proUserId
     */
    public void getAndSetHeart(String date, String apiKey, Integer proUserId) {
        List<HeartRest> heart = heart(date, apiKey, proUserId);
        insertListHeartRest(proUserId, heart, date);

    }

    /**
     * 访问heart接口
     *
     * @param date 时间,yyyy-mm-dd
     * @return {@link HeartPO} 列表
     */
    public List<HeartRest> heart(String date, String apiKey, Integer proUserId) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("date", date);
        maps.put("api_key", apiKey);
        log.info("访问 heart 接口参数={}", maps);
        ResponseEntity<String> exchange = restTemplate.exchange(
                wakaApiUrlConfig.getHeartUrl() + "?date={date}&api_key={api_key}",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                String.class,
                maps
        );
        String body = exchange.getBody();
        JSONObject object = JSONObject.parseObject(body);
        JSONArray data = object.getJSONArray("data");
        List<HeartRest> result = data.toJavaList(HeartRest.class);
        return result;
    }


    /**
     * 写入数据库
     *
     * @param proUserId
     * @param result
     */
    private void insertListHeartRest(Integer proUserId, List<HeartRest> result, String date) {
        result.forEach(
                s -> {
                    HeartPO heartpo = new HeartPO();
                    heartpo.setBranch(s.getBranch());
                    heartpo.setCategory(s.getCategory());
                    heartpo.setCreatedAt(s.getCreatedAt());
                    heartpo.setCursorpos(s.getCursorpos());
                    heartpo.setDependencies(String.join("-", s.getDependencies()));
                    heartpo.setEntity(s.getEntity());
                    heartpo.setId(s.getId());
                    heartpo.setIsWrite(s.getIsWrite());
                    heartpo.setLanguage(s.getLanguage());
                    heartpo.setLineno(s.getLineno());
                    heartpo.setLines(s.getLines());
                    heartpo.setMachineNameId(s.getMachineNameId());
                    heartpo.setProject(s.getProject());
                    heartpo.setTime(s.getTime());
                    heartpo.setType(s.getType());
                    heartpo.setUserAgentId(s.getUserAgentId());
                    heartpo.setUserId(s.getUserId());
                    heartpo.setUpdateTime(new Date());
                    heartpo.setProUserId(proUserId);
                    heartpo.setDay(date);
                    try {
                        insertHeart(heartpo);
                    } catch (Exception e) {
                        log.error("异常={}", heartpo);
                        e.printStackTrace();
                    }

                }
        );
    }

    /**
     * 插入数据
     *
     * @param heartPO
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertHeart(HeartPO heartPO) {
        heartMapper.insert(heartPO);
    }


}
