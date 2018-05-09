package com.rolin.entity;

import java.util.ArrayList;

public class ActivityDetail {
    ShopAct shopAct;

    ArrayList<Goods> goodsArrayList;

    public ShopAct getShopAct() {
        return shopAct;
    }

    public void setShopAct(ShopAct shopAct) {
        this.shopAct = shopAct;
    }

    public ArrayList<Goods> getGoodsArrayList() {
        return goodsArrayList;
    }

    public void setGoodsArrayList(ArrayList<Goods> goodsArrayList) {
        this.goodsArrayList = goodsArrayList;
    }

}
