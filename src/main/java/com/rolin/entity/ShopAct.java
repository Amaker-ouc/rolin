package com.rolin.entity;

import java.util.Date;

public class ShopAct {
    private Integer shopActId;

    private Integer shopId;

    private Integer actId;

    private String actImg;

    private String actDes;

    private Date beginTime;

    private Date endTime;

    public Integer getShopActId() {
        return shopActId;
    }

    public void setShopActId(Integer shopActId) {
        this.shopActId = shopActId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getActId() {
        return actId;
    }

    public void setActId(Integer actId) {
        this.actId = actId;
    }

    public String getActImg() {
        return actImg;
    }

    public void setActImg(String actImg) {
        this.actImg = actImg;
    }

    public String getActDes() {
        return actDes;
    }

    public void setActDes(String actDes) {
        this.actDes = actDes;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

}