package com.huifer.jenkinsspringboot.service.spider;

import com.alibaba.fastjson.JSONObject;
import com.huifer.jenkinsspringboot.entity.xz.TStinfo;
import com.huifer.jenkinsspringboot.entity.xz.TWoinfo;
import com.huifer.jenkinsspringboot.entity.xz.TXz;
import com.huifer.jenkinsspringboot.entity.xz.UserMonthInfo;
import com.huifer.jenkinsspringboot.mapper.TXzMapper;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Date: 2019-10-14
 */
@Slf4j
@Service
public class XzSpider {
    @Autowired
    private RestTemplate restTemplate;
    public static final String BASE_XZ_URL = "http://www.imxingzhe.com/";
    @Autowired
    XzService xzService;

    @Autowired
    TXzMapper tXzMapper;

    @Autowired
    WoinfoService woinfoService;
    @Autowired
    StinfoService stinfoService;

    /**
     * 正则
     *
     * @param str
     * @param regex
     * @return
     */
    private static String regex(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(str);

        while (match.find()) {
            if (!"".equals(match.group())) {
                String group = match.group();
                return group;
            }
        }
        return "";
    }

    public void spiderUserId() {
        // 数据库t_xz url

        List<TXz> all = tXzMapper.findAll();
        for (TXz tXz : all) {
            String url = tXz.getUrl();
            Integer uid = url2userId(url);
            spiderHistory(uid);
        }

    }

    public String uidHistory(String url) {
        Integer uid = url2userId(url);
        spiderHistory(uid);
        return uid + "完成";
    }

    private Integer url2userId(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "td_cookie=2441244528; csrftoken=nQKAt5cwYT9dsIjBteRKSaNLQZnZynZ3; sessionid=5lx3yvdfwsacv0eaif7rfy6wrvy1x62h; Hm_lvt_7b262f3838ed313bc65b9ec6316c79c4=1571099537,1571101155,1571101615,1571104827; Hm_lpvt_7b262f3838ed313bc65b9ec6316c79c4=1571105168");
        ResponseEntity<String> exchange = restTemplate.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<String>(headers),

                String.class
        );
        String body = exchange.getBody();
        String regex = "uid.*\\d+.*";
        String regex1 = regex(body, regex);
        String uidStr = regex(regex1, "\\d+");
        Integer uid = Integer.valueOf(uidStr);
        log.info("更新数据,url={},uid={}", url, uid);
        tXzMapper.updateByUrl(url, uid);
        return uid;
    }

    /**
     * 路线数据
     *
     * @throws Exception
     */
    public void line() throws Exception {
        String Cookie = "td_cookie=2441531771; td_cookie=2441244528; csrftoken=nQKAt5cwYT9dsIjBteRKSaNLQZnZynZ3; Hm_lvt_7b262f3838ed313bc65b9ec6316c79c4=1570757134,1571020126,1571020162; rd=X4DR; sessionid=5lx3yvdfwsacv0eaif7rfy6wrvy1x62h; Hm_lpvt_7b262f3838ed313bc65b9ec6316c79c4=1571029514";
        String url = "http://www.imxingzhe.com/xing/72076175/gpx/";
        HttpHeaders headers = new HttpHeaders();

        headers.add("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        headers.add("Accept-Encoding", "gzip, deflate");
        headers.add("Accept-Language", "zh-CN,zh;q=0.9");
        headers.add("Cache-Control", "max-age=0");
        headers.add("Connection", "keep-alive");
        headers.add("Cookie", "td_cookie=2441244528; csrftoken=nQKAt5cwYT9dsIjBteRKSaNLQZnZynZ3; sessionid=5lx3yvdfwsacv0eaif7rfy6wrvy1x62h; Hm_lvt_7b262f3838ed313bc65b9ec6316c79c4=1571099537,1571101155,1571101615,1571104827; Hm_lpvt_7b262f3838ed313bc65b9ec6316c79c4=1571105168");
        headers.add("Host", "www.imxingzhe.com");
        headers.add("Upgrade-Insecure-Requests", "1");
        headers.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36");
        ResponseEntity<String> exchange = restTemplate.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<String>(headers),
                String.class
        );
        String body = exchange.getBody();

    }

    /**
     * 获取行车历史
     */
    public void spiderHistory(int userId) {
        int year = 2019;
        int month = 12;

        for (int y = 2010; y <= year; y++) {
            for (int m = 1; m <= month; m++) {
                getUserMonth(userId, y, m);
            }
        }

    }

    /**
     * 获取用户骑行基本数据
     * @param userId
     * @param year
     * @param month
     */
    private void getUserMonth(int userId, int year, int month) {
        log.info("开始获取用户年月数据,user_id={},year={},month={}", userId, year, month);
        String url = "http://www.imxingzhe.com/api/v4/user_month_info?user_id=%d&year=%d&month=%d";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "td_cookie=2441244528; csrftoken=nQKAt5cwYT9dsIjBteRKSaNLQZnZynZ3; sessionid=5lx3yvdfwsacv0eaif7rfy6wrvy1x62h; Hm_lvt_7b262f3838ed313bc65b9ec6316c79c4=1571099537,1571101155,1571101615,1571104827; Hm_lpvt_7b262f3838ed313bc65b9ec6316c79c4=1571105168");
        ResponseEntity<String> exchange = restTemplate.exchange(
                String.format(url, userId, year, month),
                HttpMethod.GET,
                new HttpEntity<String>(headers),

                String.class
        );
        String body = exchange.getBody();
        JSONObject object = JSONObject.parseObject(body);
        UserMonthInfo userMonthInfo = object.toJavaObject(UserMonthInfo.class);

        UserMonthInfo.DataBean.StInfoBean stInfo = userMonthInfo.getData().getStInfo();
        List<UserMonthInfo.DataBean.WoInfoBean> woInfo = userMonthInfo.getData().getWoInfo();
        insertSt(stInfo, year, month, userId);
        insertWo(woInfo, year, month);
    }

    /**
     * 插入st数据
     *
     * @param st
     * @param year
     * @param month
     * @param userId
     */
    private void insertSt(UserMonthInfo.DataBean.StInfoBean st, int year, int month, int userId) {
        TStinfo tStinfo = new TStinfo();
        tStinfo.setYear(year);
        tStinfo.setMonth(month);

        tStinfo.setSumDuration(st.getSumDuration());
        tStinfo.setSumDistance(st.getSumDistance());
        tStinfo.setSumElevationGain(st.getSumElevationGain());
        tStinfo.setCountDistance(st.getCountDistance());
        tStinfo.setSumCredits(st.getSumCredits());
        tStinfo.setUserId(userId);
        stinfoService.insert(tStinfo);
    }

    /**
     * 插入wo数据
     *
     * @param wo
     * @param year
     * @param month
     */
    private void insertWo(List<UserMonthInfo.DataBean.WoInfoBean> wo, int year, int month) {
        List<TWoinfo> ls = new ArrayList<>();
        for (UserMonthInfo.DataBean.WoInfoBean woInfoBean : wo) {
            TWoinfo tWoinfo = new TWoinfo();
            tWoinfo.setYear(year);
            tWoinfo.setMonth(month);
            tWoinfo.setHeartSource(woInfoBean.getHeartSource());
            tWoinfo.setLikeCount(woInfoBean.getLikeCount());
            tWoinfo.setDuration(woInfoBean.getDuration());
            tWoinfo.setSport(woInfoBean.getSport());
            tWoinfo.setId(woInfoBean.getId());
            tWoinfo.setUploadTime(woInfoBean.getUploadTime());
            tWoinfo.setUserId(woInfoBean.getUserId());
            tWoinfo.setUuid(woInfoBean.getUuid());
            tWoinfo.setTitle(woInfoBean.getTitle());
            tWoinfo.setCadenceSource(woInfoBean.getCadenceSource());
            tWoinfo.setIsValid(woInfoBean.getIsValid());
            tWoinfo.setCommentCount(woInfoBean.getCommentCount());
            tWoinfo.setElevationLoss(woInfoBean.getElevationLoss());
            tWoinfo.setHidden(woInfoBean.getHidden() == Boolean.TRUE ? BigDecimal.ONE : BigDecimal.ZERO);
            tWoinfo.setDesc(woInfoBean.getDesc());
            tWoinfo.setThreedWorkout(woInfoBean.getThreedWorkout());
            tWoinfo.setMapId(woInfoBean.getMapId());
            tWoinfo.setElevationGain(woInfoBean.getElevationGain());
            tWoinfo.setStartTime(woInfoBean.getStartTime());
            tWoinfo.setCredits(woInfoBean.getCredits());
            tWoinfo.setIsSegment(woInfoBean.getIsSegment());
            tWoinfo.setIsLike(woInfoBean.getIsLike());
            tWoinfo.setDistance(woInfoBean.getDistance());
            tWoinfo.setCalories(woInfoBean.getCalories());
            tWoinfo.setLocSource(woInfoBean.getLocSource());
            tWoinfo.setMapHidden(woInfoBean.getMapHidden());
            tWoinfo.setEndTime(woInfoBean.getEndTime());
            tWoinfo.setAvgSpeed(woInfoBean.getAvgSpeed());
            ls.add(tWoinfo);
        }
        woinfoService.inserts(ls);
    }

    /**
     * 抓取排行榜数据
     */
    public void spiderTop() {
        for (int i = 1; i <= 414; i++) {
            getCityUsers(i);
        }
    }

    /**
     * 根据城市id 抓取排行榜数据
     *
     * @param cityId
     */
    public String getCityUsers(int cityId) {

        log.info("当前cityId= {}", cityId);
        String url = "http://www.imxingzhe.com/city/%d/?page=%d";
        GetTotal getTotal = new GetTotal(String.format(url, cityId, 1)).invoke();

        String total = getTotal.getTotal();

        int totalInt = Integer.valueOf(total);
        log.info("cityId={},共有={}页", cityId, totalInt);

        for (int i = 1; i <= totalInt; i++) {
            String body1 = new GetTotal(String.format(url, cityId, i)).invoke().getBody();
            Document doc = Jsoup.parse(body1);
            Elements rows = doc.select("a[class=user-name]");
            List<TXz> userPros = new ArrayList<>();
            for (Element e : rows) {
                String name = e.text();
                String userUrl = BASE_XZ_URL + e.attr("href");
                TXz userPro = new TXz();
                userPro.setCityId(cityId);
                userPro.setName(name);
                userPro.setUrl(userUrl);
                userPro.setPage(i);
                userPros.add(userPro);


            }
            xzService.inserts(userPros);
            userPros.clear();
            log.info("city_id={},第{}页完成,总共={}", cityId, i, totalInt);

        }
//        log.info("共有={}人", userPros.size());
        return "cityid=" + cityId + "完成";
    }

    /**
     * 城市数据类
     */
    private class GetTotal {
        private String url;
        private String body;
        private String total;

        public GetTotal(String url) {
            this.url = url;
        }

        public String getBody() {
            return body;
        }

        public String getTotal() {
            return total;
        }

        public GetTotal invoke() {
            HttpHeaders headers = new HttpHeaders();

            headers.add("Cookie", "td_cookie=2522742900; td_cookie=2441244528; csrftoken=nQKAt5cwYT9dsIjBteRKSaNLQZnZynZ3; sessionid=5lx3yvdfwsacv0eaif7rfy6wrvy1x62h; Hm_lvt_7b262f3838ed313bc65b9ec6316c79c4=1571020162,1571099537,1571101155,1571101615; Hm_lpvt_7b262f3838ed313bc65b9ec6316c79c4=1571101783");
            ResponseEntity<String> exchange = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
//                    HttpEntity.EMPTY,
                    new HttpEntity<String>(headers),
                    String.class
            );
            body = exchange.getBody();
            String regex = "\\d+.*//总页码";
            String regex1 = regex(body, regex);
            total = regex(regex1, "\\d+");
            return this;
        }
    }
}
