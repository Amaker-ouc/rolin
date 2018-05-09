package com.rolin.entity;

import java.util.Date;

public class Order {
    private Integer orderiId;

    private Date orderTime;

    private Integer userId;

    private Integer shopId;

    public Integer getOrderiId() {
        return orderiId;
    }

    public void setOrderiId(Integer orderiId) {
        this.orderiId = orderiId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
}