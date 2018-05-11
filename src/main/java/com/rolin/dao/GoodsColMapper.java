package com.rolin.dao;

import com.rolin.entity.GoodsCol;

import java.util.ArrayList;

public interface GoodsColMapper {
    int deleteByPrimaryKey(Integer colId);

    int insert(GoodsCol record);

    int insertSelective(GoodsCol record);

    GoodsCol selectByPrimaryKey(Integer colId);

    ArrayList<String> selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(GoodsCol record);

    int updateByPrimaryKey(GoodsCol record);
}