package com.huifer.jenkinsspringboot.mapper;

import com.huifer.jenkinsspringboot.entity.db.TDailysummaryfeedrest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TDailysummaryfeedrestMapper {
    int deleteByPrimaryKey(Integer fid);

    int insert(TDailysummaryfeedrest record);

    int insertSelective(TDailysummaryfeedrest record);

    TDailysummaryfeedrest selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(TDailysummaryfeedrest record);

    int updateByPrimaryKey(TDailysummaryfeedrest record);

    TDailysummaryfeedrest findByYearModDay(@Param("year") int year, @Param("month") int month, @Param("day") int day);
}