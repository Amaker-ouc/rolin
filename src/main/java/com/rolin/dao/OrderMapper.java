package com.rolin.dao;

import com.rolin.entity.Order;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderiId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderiId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}