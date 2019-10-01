package com.huifer.jenkinsspringboot.mapper;

import com.huifer.jenkinsspringboot.entity.db.UserApiPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserApiPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserApiPO record);

    int insertSelective(UserApiPO record);

    UserApiPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserApiPO record);

    int updateByPrimaryKey(UserApiPO record);


    List<UserApiPO> findAll();
}