package com.rolin.dao;

import com.rolin.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer goodsId);

    ArrayList<Goods> selectByShopId(@Param("shopId") Integer shopId, @Param("page") Integer page);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}