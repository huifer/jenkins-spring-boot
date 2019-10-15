package com.huifer.jenkinsspringboot.entity.xz;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("t_woinfo")
public class TWoinfo {
    @TableId(value = "fid", type = IdType.INPUT)
    private Integer fid;

    @TableField("heart_source")
    private BigDecimal heartSource;

    @TableField("like_count")
    private BigDecimal likeCount;

    @TableField("duration")
    private BigDecimal duration;

    @TableField("sport")
    private BigDecimal sport;

    @TableField("id")
    private BigDecimal id;

    @TableField("upload_time")
    private Date uploadTime;

    @TableField("user_id")
    private Integer userId;

    @TableField("uuid")
    private String uuid;

    @TableField("title")
    private String title;

    @TableField("cadence_source")
    private BigDecimal cadenceSource;

    @TableField("is_valid")
    private BigDecimal isValid;

    @TableField("comment_count")
    private BigDecimal commentCount;

    @TableField("elevation_loss")
    private BigDecimal elevationLoss;

    @TableField("hidden")
    private BigDecimal hidden;

    @TableField("desc")
    private String desc;

    @TableField("threed_workout")
    private String threedWorkout;

    @TableField("map_id")
    private BigDecimal mapId;

    @TableField("elevation_gain")
    private BigDecimal elevationGain;

    @TableField("start_time")
    private Long startTime;

    @TableField("credits")
    private BigDecimal credits;

    @TableField("is_segment")
    private BigDecimal isSegment;

    @TableField("is_like")
    private BigDecimal isLike;

    @TableField("distance")
    private BigDecimal distance;

    @TableField("calories")
    private BigDecimal calories;

    @TableField("loc_source")
    private BigDecimal locSource;

    @TableField("map_hidden")
    private BigDecimal mapHidden;

    @TableField("end_time")
    private Long endTime;

    @TableField("avg_speed")
    private BigDecimal avgSpeed;

    @TableField("year")
    private Integer year;

    @TableField("month")
    private Integer month;
}