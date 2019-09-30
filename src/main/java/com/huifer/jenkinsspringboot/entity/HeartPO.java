package com.huifer.jenkinsspringboot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * // TODO: 2019/9/30 字段翻译
 * @Date: 2019-09-29
 */
@Data
@ApiModel("waka心跳数据")
public class HeartPO {
    @ApiModelProperty(value = "分支", dataType = "String")
    private String branch;
    @ApiModelProperty(value = "category", dataType = "String")
    private String category;
    @ApiModelProperty(value = "created_at", dataType = "String")
    private String created_at;
    @ApiModelProperty(value = "cursorpos", dataType = "String")
    private String cursorpos;
    @ApiModelProperty(value = "dependencies", dataType = "String")
    private String dependencies;
    @ApiModelProperty(value = "entity", dataType = "String")
    private String entity;
    @ApiModelProperty(value = "id", dataType = "String")
    private String id;
    @ApiModelProperty(value = "is_write", dataType = "String")
    private String is_write;
    @ApiModelProperty(value = "language", dataType = "String")
    private String language;
    @ApiModelProperty(value = "lineno", dataType = "String")
    private String lineno;
    @ApiModelProperty(value = "lines", dataType = "Long")
    private Long lines;
    @ApiModelProperty(value = "machine_name_id", dataType = "String")
    private String machine_name_id;
    @ApiModelProperty(value = "project", dataType = "String")
    private String project;
    @ApiModelProperty(value = "time", dataType = "Double")
    private BigDecimal time;
    @ApiModelProperty(value = "type", dataType = "String")
    private String type;
    @ApiModelProperty(value = "user_agent_id", dataType = "String")
    private String user_agent_id;
    @ApiModelProperty(value = "user_id", dataType = "String")
    private String user_id;

}
