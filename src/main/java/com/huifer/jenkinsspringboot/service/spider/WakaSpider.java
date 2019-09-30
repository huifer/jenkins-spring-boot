package com.huifer.jenkinsspringboot.service.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huifer.jenkinsspringboot.config.WakaApiUrlConfig;
import com.huifer.jenkinsspringboot.entity.DurationsRest;
import com.huifer.jenkinsspringboot.entity.HeartPO;
import com.huifer.jenkinsspringboot.entity.HeartRest;
import com.huifer.jenkinsspringboot.entity.WakaUserinfo;
import com.huifer.jenkinsspringboot.mapper.HeartPOMapper;
import com.huifer.jenkinsspringboot.mapper.WakaUserinfoMapper;
import lombok.extern.slf4j.Slf4j;
import com.huifer.jenkinsspringboot.entity.ProjectRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

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
    private WakaUserinfoMapper wakaUserinfoMapper;

    /**
     * 用户信息接口
     *
     * @param apiKey
     * @return
     */
    public WakaUserinfo userInfo(String apiKey) {
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
        WakaUserinfo wakaUserinfo = data.toJavaObject(WakaUserinfo.class);
        wakaUserinfo.setApiKey(apiKey);
        return wakaUserinfo;
    public ProjectRest projects() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity(wakaApiUrlConfig.getProjectUrl()
                + "?api_key=" + wakaApiUrlConfig.getSecretApiKey(), String.class);

        String body = forEntity.getBody();
        JSONObject object = JSONObject.parseObject(body);
        ProjectRest projectRest = object.toJavaObject(ProjectRest.class);
        return projectRest;
    }


    public DurationsRest durations() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity(wakaApiUrlConfig.getDurationUrl()
                + "?api_key=" + wakaApiUrlConfig.getSecretApiKey() + "&date=2019-09-30", String.class);
        String body = forEntity.getBody();
        JSONObject object = JSONObject.parseObject(body);
        DurationsRest durationsRest = object.toJavaObject(DurationsRest.class);
        return durationsRest;
    }


    public void userInfo() {
        restTemplate.getForEntity(wakaApiUrlConfig.getUserInfoUrl() + "?api_key=" + wakaApiUrlConfig.getSecretApiKey(), String.class);
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
        log.info("访问heart接口参数={}", maps);
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
                    try {
                        insertHeart(heartpo);
                    } catch (Exception e) {
                        log.error("异常={}", heartpo);
                        e.printStackTrace();
                    }

                }
        );


        return result;
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


    @Transactional(rollbackFor = Exception.class)
    public void insertWakaTimeUserInfo(WakaUserinfo wakaUserinfo) {
        wakaUserinfoMapper.insert(wakaUserinfo);
    }


}
