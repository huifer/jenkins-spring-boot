package com.huifer.jenkinsspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2019-10-16
 */
@RestController
@RequestMapping("/rd")
public class RedisController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @GetMapping("/in")
    public void add(){
        stringRedisTemplate.opsForValue().set("1","ljlkjl");
    }
}
