package com.rolin.dao;

import com.rolin.entity.ShopAct;

import java.util.ArrayList;

public interface ShopActMapper {
    int deleteByPrimaryKey(Integer shopActId);

    int insert(ShopAct record);

    int insertSelective(ShopAct record);

    ShopAct selectByPrimaryKey(Integer shopActId);

    ArrayList<ShopAct> selectByShopId(Integer shopId);

    int updateByPrimaryKeySelective(ShopAct record);

    int updateByPrimaryKey(ShopAct record);
}