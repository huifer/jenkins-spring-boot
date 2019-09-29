package com.huifer.jenkinsspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.huifer.jenkinsspringboot.mapper")
public class JenkinsSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(JenkinsSpringBootApplication.class, args);
    }

}
