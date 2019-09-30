package com.huifer.jenkinsspringboot.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class UserDurationsPO {
    private Integer uid;

    private Date createdAt;

    private String cursorpos;

    private BigDecimal duration;

    private String id;

    private String lineno;

    private String machineNameId;

    private String project;

    private BigDecimal time;

    private String userId;

    private String apiKey;

    private String day;
}