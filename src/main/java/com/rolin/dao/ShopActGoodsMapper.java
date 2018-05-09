package com.rolin.dao;

import com.rolin.entity.ShopActGoods;

import java.util.ArrayList;

public interface ShopActGoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShopActGoods record);

    int insertSelective(ShopActGoods record);

    ShopActGoods selectByPrimaryKey(Integer id);

    ArrayList<Integer> selectByShopActId(Integer id);

    int updateByPrimaryKeySelective(ShopActGoods record);

    int updateByPrimaryKey(ShopActGoods record);

}