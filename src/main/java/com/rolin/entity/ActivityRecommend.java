package com.rolin.entity;

import java.util.Date;

public class ActivityRecommend {
    private Integer shopActId;

    private String shopName;

    private String shopImage;

    private String actCategoryName;

    private Date beginTime;

    private Date endTime;

    private String actImg;

    private String actDes;

    public Integer getShopActId() {
        return shopActId;
    }

    public void setShopActId(Integer shopActId) {
        this.shopActId = shopActId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopImage() {
        return shopImage;
    }

    public void setShopImage(String shopImage) {
        this.shopImage = shopImage;
    }

    public String getActCategoryName() {
        return actCategoryName;
    }

    public void setActCategoryName(String actCategoryName) {
        this.actCategoryName = actCategoryName;
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
}
