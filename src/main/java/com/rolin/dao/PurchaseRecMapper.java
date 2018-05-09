package com.rolin.dao;

import com.rolin.entity.PurchaseRec;

public interface PurchaseRecMapper {
    int deleteByPrimaryKey(Integer purchaseRecId);

    int insert(PurchaseRec record);

    int insertSelective(PurchaseRec record);

    PurchaseRec selectByPrimaryKey(Integer purchaseRecId);

    int updateByPrimaryKeySelective(PurchaseRec record);

    int updateByPrimaryKey(PurchaseRec record);
}