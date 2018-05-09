package com.rolin.dao;

import com.rolin.entity.ShopScrollImg;

import java.util.ArrayList;

public interface ShopScrollImgMapper {
    int deleteByPrimaryKey(Integer shopScrollImgId);

    int insert(ShopScrollImg record);

    int insertSelective(ShopScrollImg record);

    ShopScrollImg selectByPrimaryKey(Integer shopScrollImgId);

    ArrayList<String> selectByShopId(Integer shopId);

    int updateByPrimaryKeySelective(ShopScrollImg record);

    int updateByPrimaryKey(ShopScrollImg record);
}