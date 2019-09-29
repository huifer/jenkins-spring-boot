package com.huifer.jenkinsspringboot.mapper;

import com.huifer.jenkinsspringboot.entity.WakaUserinfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WakaUserinfoMapper {
    int deleteByPrimaryKey(String apiKey);

    int insert(WakaUserinfo record);

    int insertSelective(WakaUserinfo record);

    WakaUserinfo selectByPrimaryKey(String apiKey);

    int updateByPrimaryKeySelective(WakaUserinfo record);

    int updateByPrimaryKey(WakaUserinfo record);
}