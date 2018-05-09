package com.rolin.entity;

public class ModuleDetail {
    private Integer moduleDetailId;

    private Integer goodsModuleId;

    private String moduleImg;

    private String moduleDes;

    public Integer getModuleDetailId() {
        return moduleDetailId;
    }

    public void setModuleDetailId(Integer moduleDetailId) {
        this.moduleDetailId = moduleDetailId;
    }

    public Integer getGoodsModuleId() {
        return goodsModuleId;
    }

    public void setGoodsModuleId(Integer goodsModuleId) {
        this.goodsModuleId = goodsModuleId;
    }

    public String getModuleImg() {
        return moduleImg;
    }

    public void setModuleImg(String moduleImg) {
        this.moduleImg = moduleImg;
    }

    public String getModuleDes() {
        return moduleDes;
    }

    public void setModuleDes(String moduleDes) {
        this.moduleDes = moduleDes;
    }
}