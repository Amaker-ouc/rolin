package com.rolin.dao;

import com.rolin.entity.GoodsAttr;

public interface GoodsAttrMapper {
    int deleteByPrimaryKey(Integer attrId);

    int insert(GoodsAttr record);

    int insertSelective(GoodsAttr record);

    GoodsAttr selectByPrimaryKey(Integer attrId);

    int updateByPrimaryKeySelective(GoodsAttr record);

    int updateByPrimaryKey(GoodsAttr record);
}