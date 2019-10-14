package com.huifer.jenkinsspringboot;

import com.huifer.jenkinsspringboot.config.SenboRestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JenkinsSpringBootApplicationTests {

    @Autowired
    SenboRestConfig sen;

    @Test
    public void contextLoads() {
        System.out.println();
    }

}
