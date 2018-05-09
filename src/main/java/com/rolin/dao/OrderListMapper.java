package com.rolin.dao;

import com.rolin.entity.OrderList;

public interface OrderListMapper {
    int deleteByPrimaryKey(Integer orderListId);

    int insert(OrderList record);

    int insertSelective(OrderList record);

    OrderList selectByPrimaryKey(Integer orderListId);

    int updateByPrimaryKeySelective(OrderList record);

    int updateByPrimaryKey(OrderList record);
}