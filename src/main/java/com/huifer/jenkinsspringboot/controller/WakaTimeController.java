package com.huifer.jenkinsspringboot.controller;

import com.huifer.jenkinsspringboot.entity.result.ProjectWithUser;
import com.huifer.jenkinsspringboot.entity.result.UserProject;
import com.huifer.jenkinsspringboot.entity.wakarest.DurationsRest;
import com.huifer.jenkinsspringboot.entity.wakarest.HistorySeven;
import com.huifer.jenkinsspringboot.entity.wakarest.ProjectRest;
import com.huifer.jenkinsspringboot.service.query.WakaTimeQuery;
import com.huifer.jenkinsspringboot.service.spider.WakaSpider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Date: 2019-09-30
 */
@Api(value = "waka_time Controller", tags = {"wakatime接口"})
@RestController
@RequestMapping("/wakatime")
public class WakaTimeController {
    @Autowired
    private WakaSpider wakaSpider;


    @Autowired
    private WakaTimeQuery wakaTimeQuery;

    @GetMapping("/proj_by_user")
    public List<ProjectWithUser> statisticsProjectByUser() {
        return wakaTimeQuery.statisticsProjectByUser();
    }

    @GetMapping("statistics_user")
    public List<UserProject> statisticsUser() {
        return wakaTimeQuery.statisticsUser();
    }


    @ApiOperation(value = "xxx日期下的开发时间", response = DurationsRest.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功")
    })
    @GetMapping("/durations")
    public DurationsRest durations() {
        return wakaSpider.durations("2019-09-30", "16e493aa-9ba5-4a40-bcd5-f105bf9522b6", 1);
    }

    @ApiOperation(value = "当前用户的项目列表")
    @GetMapping("/projects")
    public ProjectRest projects() {
        return wakaSpider.projects("16e493aa-9ba5-4a40-bcd5-f105bf9522b6");
    }

    @GetMapping("/history_seven")
    public HistorySeven historySeven() {
        HistorySeven historySeven = wakaSpider.historySeven("16e493aa-9ba5-4a40-bcd5-f105bf9522b6");
        return historySeven;
    }
}
