package com.huifer.jenkinsspringboot.controller;

import com.huifer.jenkinsspringboot.service.ThreadDemo;
import com.huifer.jenkinsspringboot.service.spider.XzSpider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

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

    @GetMapping("/xzx")
    public String spc() {
        xzSpider.spiderUserId();
        return "okok";
    }

    @Autowired
    ThreadDemo threadDemo;

    @GetMapping("t1")
    public String thread1User() throws InterruptedException, ExecutionException, IOException {
        threadDemo.run();
        return "thread1 ok";
    }

    @GetMapping("t2")
    public String thread2History() throws InterruptedException, ExecutionException, IOException {
        threadDemo.runUid();
        return "thread2 ok";
    }
}
