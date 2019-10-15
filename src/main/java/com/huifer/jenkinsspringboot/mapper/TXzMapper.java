package com.huifer.jenkinsspringboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huifer.jenkinsspringboot.entity.xz.TXz;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TXzMapper extends BaseMapper<TXz> {
    int deleteByPrimaryKey(Integer id);

    int insert(TXz record);

    int insertSelective(TXz record);

    TXz selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TXz record);

    int updateByPrimaryKey(TXz record);
}