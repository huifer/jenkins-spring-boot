package com.huifer.jenkinsspringboot.mapper;

import com.huifer.jenkinsspringboot.entity.HeartPO;

public interface HeartPOMapper {
    int insert(HeartPO record);

    int insertSelective(HeartPO record);
}