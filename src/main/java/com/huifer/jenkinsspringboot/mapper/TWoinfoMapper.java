package com.huifer.jenkinsspringboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huifer.jenkinsspringboot.entity.xz.TWoinfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TWoinfoMapper extends BaseMapper<TWoinfo> {
    int deleteByPrimaryKey(Integer fid);

    int insert(TWoinfo record);

    int insertSelective(TWoinfo record);

    TWoinfo selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(TWoinfo record);

    int updateByPrimaryKey(TWoinfo record);
}