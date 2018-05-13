package com.rolin.entity;

import java.util.ArrayList;
import java.util.Date;

public class ShopDetail {

    private Shop shop;

    private ArrayList<String> scrollImgs;

    private ArrayList<ShopAct> acts;

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public ArrayList<String> getScrollImgs() {
        return scrollImgs;
    }

    public void setScrollImgs(ArrayList<String> scrollImgs) {
        this.scrollImgs = scrollImgs;
    }


    public ArrayList<ShopAct> getActs() {
        return acts;
    }

    public void setActs(ArrayList<ShopAct> acts) {
        this.acts = acts;
    }

}
