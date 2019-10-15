package com.huifer.jenkinsspringboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huifer.jenkinsspringboot.entity.xz.TStinfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TStinfoMapper extends BaseMapper<TStinfo> {
    int deleteByPrimaryKey(Integer fid);

    int insert(TStinfo record);

    int insertSelective(TStinfo record);

    TStinfo selectByPrimaryKey(Integer fid);

    int updateByPrimaryKeySelective(TStinfo record);

    int updateByPrimaryKey(TStinfo record);
}