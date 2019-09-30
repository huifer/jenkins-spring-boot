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
        wakaSpider.heart();
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