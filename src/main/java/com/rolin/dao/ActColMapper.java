package com.rolin.dao;

import com.rolin.entity.ActCol;

import java.util.ArrayList;

public interface ActColMapper {
    int deleteByPrimaryKey(Integer actColId);

    int insert(ActCol record);

    int insertSelective(ActCol record);

    ActCol selectByPrimaryKey(Integer actColId);

    ArrayList<String> selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(ActCol record);

    int updateByPrimaryKey(ActCol record);
}