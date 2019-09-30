package com.huifer.jenkinsspringboot.controller;

import com.huifer.jenkinsspringboot.entity.DurationsRest;
import com.huifer.jenkinsspringboot.entity.ProjectRest;
import com.huifer.jenkinsspringboot.service.spider.WakaSpider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2019-09-30
 */
@RestController
@RequestMapping("/wakatime")
public class WakaTimeController {
    @Autowired
    private WakaSpider wakaSpider;

    @GetMapping("/durations")
    public DurationsRest durations() {
        return wakaSpider.durations();
    }

    @GetMapping("/projects")
    public ProjectRest projects() {
        return wakaSpider.projects();
    }
}
