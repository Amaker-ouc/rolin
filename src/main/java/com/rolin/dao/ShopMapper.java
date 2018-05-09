package com.rolin.dao;

import com.rolin.entity.Shop;

public interface ShopMapper {
    int deleteByPrimaryKey(Integer shopId);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(Integer shopId);

    int updateByPrimaryKeySelective(Shop record);

    Shop selectByShopName(String shopName);

    int updateByPrimaryKey(Shop record);
}