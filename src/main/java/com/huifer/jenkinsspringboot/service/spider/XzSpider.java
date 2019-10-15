package com.huifer.jenkinsspringboot.service.spider;

import com.alibaba.fastjson.JSONObject;
import com.huifer.jenkinsspringboot.entity.xz.TXz;
import com.huifer.jenkinsspringboot.entity.xz.UserInfo;
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

    public void line() throws Exception {
        String Cookie = "td_cookie=2441531771; td_cookie=2441244528; csrftoken=nQKAt5cwYT9dsIjBteRKSaNLQZnZynZ3; Hm_lvt_7b262f3838ed313bc65b9ec6316c79c4=1570757134,1571020126,1571020162; rd=X4DR; sessionid=5lx3yvdfwsacv0eaif7rfy6wrvy1x62h; Hm_lpvt_7b262f3838ed313bc65b9ec6316c79c4=1571029514";
        String url = "http://www.imxingzhe.com/xing/72076175/gpx/";
        HttpHeaders headers = new HttpHeaders();

        headers.add("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        headers.add("Accept-Encoding", "gzip, deflate");
        headers.add("Accept-Language", "zh-CN,zh;q=0.9");
        headers.add("Cache-Control", "max-age=0");
        headers.add("Connection", "keep-alive");
        headers.add("Cookie", "td_cookie=2441244528; csrftoken=nQKAt5cwYT9dsIjBteRKSaNLQZnZynZ3; Hm_lvt_7b262f3838ed313bc65b9ec6316c79c4=1570757134,1571020126,1571020162; rd=X4DR; sessionid=5lx3yvdfwsacv0eaif7rfy6wrvy1x62h; Hm_lpvt_7b262f3838ed313bc65b9ec6316c79c4=1571029514");
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
    public void spider() {
        String url = "http://www.imxingzhe.com/api/v4/user_month_info?user_id=792998&year=2019&month=9";
        ResponseEntity<String> exchange = restTemplate.exchange(
                url,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                String.class
        );
        String body = exchange.getBody();
        JSONObject object = JSONObject.parseObject(body);
        UserInfo userInfo = object.toJavaObject(UserInfo.class);
        System.out.println();
    }


    public void spiderTop() {
        for (int i = 1; i <= 414; i++) {
            getCityUsers(i);
        }
    }

    private void getCityUsers(int cityId) {
        log.info("当前cityId= {}", cityId);
        String url = "http://www.imxingzhe.com/city/%d/?page=%d";
        GetTotal getTotal = new GetTotal(String.format(url, 99, 1)).invoke();

        String total = getTotal.getTotal();

        int totalInt = Integer.valueOf(total);
        log.info("cityId={},共有={}页", cityId, totalInt);
        List<TXz> userPros = new ArrayList<>();

        for (int i = 1; i <= totalInt; i++) {
            String body1 = new GetTotal(String.format(url, cityId, i)).invoke().getBody();
            Document doc = Jsoup.parse(body1);
            Elements rows = doc.select("a[class=user-name]");
            for (Element e : rows) {
                String name = e.text();
                String userUrl = BASE_XZ_URL + e.attr("href");
                TXz userPro = new TXz();
                userPro.setCityId(cityId);
                userPro.setName(name);
                userPro.setUrl(userUrl);
                userPros.add(userPro);
            }
            log.info("city_id={},第{}页完成,总共={}", cityId, i, totalInt);
        }
        log.info("共有={}人", userPros.size());
        xzService.inserts(userPros);
    }

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
            ResponseEntity<String> exchange = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    HttpEntity.EMPTY,
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
