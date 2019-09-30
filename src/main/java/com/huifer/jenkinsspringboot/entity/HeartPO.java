package com.huifer.jenkinsspringboot.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class HeartPO {
    private Integer proUserId;

    private String branch;

    private String category;

    private Date createdAt;

    private String cursorpos;

    private String dependencies;

    private String id;

    private String isWrite;

    private String language;

    private String lineno;

    private String lines;

    private String machineNameId;

    private String project;

    private BigDecimal time;

    private String type;

    private String userAgentId;

    private String userId;

    private Date updateTime;

    private String entity;

    private String day;
}