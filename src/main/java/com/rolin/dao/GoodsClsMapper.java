package com.rolin.dao;

import com.rolin.entity.GoodsCls;

public interface GoodsClsMapper {
    int deleteByPrimaryKey(Integer clsId);

    int insert(GoodsCls record);

    int insertSelective(GoodsCls record);

    GoodsCls selectByPrimaryKey(Integer clsId);

    int updateByPrimaryKeySelective(GoodsCls record);

    int updateByPrimaryKey(GoodsCls record);
}