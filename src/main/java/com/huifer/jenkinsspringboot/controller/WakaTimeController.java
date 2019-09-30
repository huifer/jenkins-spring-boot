package com.huifer.jenkinsspringboot.controller;

import com.huifer.jenkinsspringboot.entity.DurationsRest;
import com.huifer.jenkinsspringboot.entity.ProjectRest;
import com.huifer.jenkinsspringboot.service.spider.WakaSpider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2019-09-30
 */
@Api(value = "waka_time Controller")
@RestController
@RequestMapping("/wakatime")
public class WakaTimeController {
    @Autowired
    private WakaSpider wakaSpider;

    @ApiOperation(value = "xxx日期下的开发时间", response = DurationsRest.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功")
    })
    @GetMapping("/durations")
    public DurationsRest durations() {
        return wakaSpider.durations();
    }

    @ApiOperation(value = "当前用户的项目列表")
    @GetMapping("/projects")
    public ProjectRest projects() {
        return wakaSpider.projects();
    }
}
