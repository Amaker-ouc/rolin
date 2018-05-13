package com.rolin.dao;

import com.rolin.entity.ActCol;

public interface ActColMapper {
    int deleteByPrimaryKey(Integer actColId);

    int insert(ActCol record);

    int insertSelective(ActCol record);

    ActCol selectByPrimaryKey(Integer actColId);

    int updateByPrimaryKeySelective(ActCol record);

    int updateByPrimaryKey(ActCol record);
}