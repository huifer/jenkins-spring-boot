package com.huifer.jenkinsspringboot.entity.xz;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@TableName("t_stinfo")
public class TStinfo implements Serializable {
    @TableId(value = "fid", type = IdType.INPUT)
    private Integer fid;

    @TableField("sum_duration")
    private BigDecimal sumDuration;

    @TableField("sum_distance")
    private BigDecimal sumDistance;

    @TableField("sum_elevation_gain")
    private BigDecimal sumElevationGain;

    @TableField("count_distance")
    private BigDecimal countDistance;

    @TableField("sum_credits")
    private BigDecimal sumCredits;

    @TableField("user_id")
    private Integer userId;

    @TableField("year")
    private Integer year;

    @TableField("month")
    private Integer month;
}