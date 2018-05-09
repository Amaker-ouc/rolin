package com.rolin.dao;

import com.rolin.entity.ShopCol;

public interface ShopColMapper {
    int deleteByPrimaryKey(Integer shopColId);

    int insert(ShopCol record);

    int insertSelective(ShopCol record);

    ShopCol selectByPrimaryKey(Integer shopColId);

    int updateByPrimaryKeySelective(ShopCol record);

    int updateByPrimaryKey(ShopCol record);
}