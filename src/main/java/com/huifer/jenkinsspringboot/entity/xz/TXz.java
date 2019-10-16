package com.huifer.jenkinsspringboot.entity.xz;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_xz")
public class TXz  implements Serializable{
    @TableId(value = "id",type = IdType.INPUT)
    private Integer id;

    @TableField("city_id")
    private Integer cityId;

    @TableField("name")
    private String name;

    @TableField("url")
    private String url;

    @TableField("page")
    private Integer page;

    @TableField("user_id")
    private Integer userId;
}