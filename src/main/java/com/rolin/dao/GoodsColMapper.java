package com.rolin.dao;

import com.rolin.entity.GoodsCol;

public interface GoodsColMapper {
    int deleteByPrimaryKey(Integer colId);

    int insert(GoodsCol record);

    int insertSelective(GoodsCol record);

    GoodsCol selectByPrimaryKey(Integer colId);

    int updateByPrimaryKeySelective(GoodsCol record);

    int updateByPrimaryKey(GoodsCol record);
}