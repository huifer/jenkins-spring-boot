package com.huifer.jenkinsspringboot.mapper;

import com.huifer.jenkinsspringboot.entity.db.ProjectPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectPO record);

    int insertSelective(ProjectPO record);

    ProjectPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectPO record);

    int updateByPrimaryKey(ProjectPO record);

    List<ProjectPO> findAll();
}