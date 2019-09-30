package com.huifer.jenkinsspringboot.service.spider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class WakaSpiderTest {
    @Autowired
    private WakaSpider wakaSpider;


    @Test
    public void heart() {
        wakaSpider.heart("2019-09-29", "16e493aa-9ba5-4a40-bcd5-f105bf9522b6", 1);
    }

    @Test
    public void userInfo() {
        wakaSpider.userInfo("16e493aa-9ba5-4a40-bcd5-f105bf9522b6");
    }

    @Test
    public void durations() {
        wakaSpider.durations();
    }

    @Test
    public void projects() {
        wakaSpider.projects();
    }
}