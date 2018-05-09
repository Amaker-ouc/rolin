package com.rolin.dao;

import com.rolin.entity.ShopCat;

public interface ShopCatMapper {
    int deleteByPrimaryKey(String shopCatName);

    int insert(ShopCat record);

    int insertSelective(ShopCat record);
}