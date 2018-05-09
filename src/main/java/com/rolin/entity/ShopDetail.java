package com.rolin.entity;

import java.util.ArrayList;
import java.util.Date;

public class ShopDetail {
    private String shopName;

    private ArrayList<String> scrollImgs;

    private String desText;

    private ArrayList<ShopAct> acts;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public ArrayList<String> getScrollImgs() {
        return scrollImgs;
    }

    public void setScrollImgs(ArrayList<String> scrollImgs) {
        this.scrollImgs = scrollImgs;
    }

    public String getDesText() {
        return desText;
    }

    public void setDesText(String desText) {
        this.desText = desText;
    }

    public ArrayList<ShopAct> getActs() {
        return acts;
    }

    public void setActs(ArrayList<ShopAct> acts) {
        this.acts = acts;
    }

}
