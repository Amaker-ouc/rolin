package com.rolin.dao;

import com.rolin.entity.UserAdd;

public interface UserAddMapper {
    int deleteByPrimaryKey(Integer addId);

    int insert(UserAdd record);

    int insertSelective(UserAdd record);

    UserAdd selectByPrimaryKey(Integer addId);

    int updateByPrimaryKeySelective(UserAdd record);

    int updateByPrimaryKey(UserAdd record);
}