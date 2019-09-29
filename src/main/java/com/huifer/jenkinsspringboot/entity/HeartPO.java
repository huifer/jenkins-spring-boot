package com.huifer.jenkinsspringboot.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Date: 2019-09-29
 */
@Data
public class HeartPO {
    private String branch;
    private String category;
    private String created_at;
    private String cursorpos;
    private String dependencies;
    private String entity;
    private String id;
    private String is_write;
    private String language;
    private String lineno;
    private Long lines;
    private String machine_name_id;
    private String project;
    private BigDecimal time;
    private String type;
    private String user_agent_id;
    private String user_id;

}
