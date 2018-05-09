package com.rolin.entity;

public class GoodsModule {
    private Integer goodsModuleId;

    private Integer goodsId;

    private String moduleName;

    public Integer getGoodsModuleId() {
        return goodsModuleId;
    }

    public void setGoodsModuleId(Integer goodsModuleId) {
        this.goodsModuleId = goodsModuleId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
}