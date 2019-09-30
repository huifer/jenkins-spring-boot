package com.huifer.jenkinsspringboot.controller;

import com.huifer.jenkinsspringboot.entity.rescuetime.DailySummaryFeedRest;
import com.huifer.jenkinsspringboot.service.spider.RescueTimeSpider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Date: 2019-09-30
 */
@RestController
@RequestMapping("/rescuetime")
public class RescueTimeController {
    @Autowired
    private RescueTimeSpider rescueTimeSpider;

    @GetMapping("/daily_summary_url")
    public List<DailySummaryFeedRest> dailySummaryData() {
        return rescueTimeSpider.dailySummaryData();
    }
}
