package com.huifer.jenkinsspringboot.controller;

import com.huifer.jenkinsspringboot.service.spider.XzSpider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2019-10-15
 */
@RestController
@RequestMapping("/run")
public class RunController {
    @Autowired
    XzSpider xzSpider;

    @GetMapping("/xz")
    public String sp() {
        xzSpider.spiderTop();
        return "ok";
    }
}