package com.rolin.entity;

import java.util.Date;

public class PurchaseRec {
    private Integer purchaseRecId;

    private Date purchaseTime;

    private Float purchasePrice;

    private Integer goodsId;

    private Integer userId;

    public Integer getPurchaseRecId() {
        return purchaseRecId;
    }

    public void setPurchaseRecId(Integer purchaseRecId) {
        this.purchaseRecId = purchaseRecId;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public Float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}