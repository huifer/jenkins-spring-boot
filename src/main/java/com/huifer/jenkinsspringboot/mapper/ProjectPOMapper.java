package com.huifer.jenkinsspringboot.mapper;

import com.huifer.jenkinsspringboot.entity.ProjectPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectPO record);

    int insertSelective(ProjectPO record);

    ProjectPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectPO record);

    int updateByPrimaryKey(ProjectPO record);
}