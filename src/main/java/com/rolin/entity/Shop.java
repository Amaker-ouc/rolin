package com.rolin.entity;

public class Shop {
    private Integer shopId;

    private Integer userId;

    private String shopCatName;

    private String shopName;

    private String secPw;

    private String desText;

    private String headImg;

    private Double lng;

    private Double lat;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getShopCatName() {
        return shopCatName;
    }

    public void setShopCatName(String shopCatName) {
        this.shopCatName = shopCatName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getSecPw() {
        return secPw;
    }

    public void setSecPw(String secPw) {
        this.secPw = secPw;
    }

    public String getDesText() {
        return desText;
    }

    public void setDesText(String desText) {
        this.desText = desText;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }
}