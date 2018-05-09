package com.rolin.dao;

import com.rolin.entity.GoodsDesc;

public interface GoodsDescMapper {
    int deleteByPrimaryKey(Integer descId);

    int insert(GoodsDesc record);

    int insertSelective(GoodsDesc record);

    GoodsDesc selectByPrimaryKey(Integer descId);

    int updateByPrimaryKeySelective(GoodsDesc record);

    int updateByPrimaryKey(GoodsDesc record);
}