package com.huifer.jenkinsspringboot.mapper;

import com.huifer.jenkinsspringboot.entity.db.SummaryProjectPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SummaryProjectPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SummaryProjectPO record);

    int insertSelective(SummaryProjectPO record);

    SummaryProjectPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SummaryProjectPO record);

    int updateByPrimaryKey(SummaryProjectPO record);
}