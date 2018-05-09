package com.rolin.dao;

import com.rolin.entity.GoodsModule;

import java.util.ArrayList;

public interface GoodsModuleMapper {
    int deleteByPrimaryKey(Integer goodsModuleId);

    int insert(GoodsModule record);

    int insertSelective(GoodsModule record);

    GoodsModule selectByPrimaryKey(Integer goodsModuleId);

    ArrayList<GoodsModule> selectByGoodsId(Integer goodsId);

    int updateByPrimaryKeySelective(GoodsModule record);

    int updateByPrimaryKey(GoodsModule record);
}