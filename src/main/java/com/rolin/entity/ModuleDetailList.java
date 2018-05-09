package com.rolin.entity;

import java.util.ArrayList;

public class ModuleDetailList {
    Goods goods;

    ArrayList<ModuleList> moduleLists;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public ArrayList<ModuleList> getModuleLists() {
        return moduleLists;
    }

    public void setModuleLists(ArrayList<ModuleList> moduleLists) {
        this.moduleLists = moduleLists;
    }
}
