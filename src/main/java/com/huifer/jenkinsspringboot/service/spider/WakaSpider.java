package com.huifer.jenkinsspringboot.service.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.huifer.jenkinsspringboot.config.WakaApiUrlConfig;
import com.huifer.jenkinsspringboot.entity.HeartPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WakaSpider {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WakaApiUrlConfig wakaApiUrlConfig;


    public void userInfo() {
        restTemplate.getForEntity(wakaApiUrlConfig.getUserInfoUrl() + "?api_key=" + wakaApiUrlConfig.getSecretApiKey(), String.class);
    }

    /**
     * 访问heart接口
     */
    public void heart() {
        Map<String, String> params = new HashMap();
        params.put("date", "2019-09-29");
        params.put("api_key", wakaApiUrlConfig.getSecretApiKey());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("date", "2019-09-29");
        httpHeaders.add("api_key", wakaApiUrlConfig.getSecretApiKey());
        HttpEntity<String> requestEntity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> forEntity = restTemplate.getForEntity(wakaApiUrlConfig.getHeartUrl() + "?api_key=" + wakaApiUrlConfig.getSecretApiKey() + "&date=2019-09-29", String.class);
        String body = forEntity.getBody();

        JSONObject object = JSONObject.parseObject(body);
        JSONArray data = object.getJSONArray("data");

        List<HeartPO> ts = data.toJavaList(HeartPO.class);
        System.out.println();
    }
}
