package com.huifer.jenkinsspringboot.mapper;

import com.huifer.jenkinsspringboot.entity.HeartPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HeartPOMapper {
    int insert(HeartPO record);

    int insertSelective(HeartPO record);

}