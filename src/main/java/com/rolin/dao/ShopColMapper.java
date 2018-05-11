package com.rolin.dao;

import com.rolin.entity.ShopCol;

import java.util.ArrayList;

public interface ShopColMapper {
    int deleteByPrimaryKey(Integer shopColId);

    int insert(ShopCol record);

    int insertSelective(ShopCol record);

    ShopCol selectByPrimaryKey(Integer shopColId);

    ArrayList<String> selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(ShopCol record);

    int updateByPrimaryKey(ShopCol record);
}