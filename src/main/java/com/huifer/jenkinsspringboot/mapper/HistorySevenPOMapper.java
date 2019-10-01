package com.huifer.jenkinsspringboot.mapper;

import com.huifer.jenkinsspringboot.entity.HistorySevenPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HistorySevenPOMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(HistorySevenPO record);

    int insertSelective(HistorySevenPO record);

    HistorySevenPO selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(HistorySevenPO record);

    int updateByPrimaryKey(HistorySevenPO record);
}