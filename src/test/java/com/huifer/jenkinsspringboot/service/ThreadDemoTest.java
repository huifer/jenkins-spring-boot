package com.huifer.jenkinsspringboot.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ThreadDemoTest {
    @Autowired
    ThreadDemo threadDemo;

    /**
     * 路线
     *
     * @throws Exception
     */
    @Test
    public void userPro() throws Exception {
        threadDemo.runUid();
    }

    /**
     * 用户
     *
     * @throws Exception
     */
    @Test
    public void user() throws Exception{
        threadDemo.run();
    }
}