package com.rolin.entity;

public class GoodsDesc {
    private Integer descId;

    private Integer goodsId;

    private String goodsDescPic;

    private String goodsDescText;

    public Integer getDescId() {
        return descId;
    }

    public void setDescId(Integer descId) {
        this.descId = descId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsDescPic() {
        return goodsDescPic;
    }

    public void setGoodsDescPic(String goodsDescPic) {
        this.goodsDescPic = goodsDescPic;
    }

    public String getGoodsDescText() {
        return goodsDescText;
    }

    public void setGoodsDescText(String goodsDescText) {
        this.goodsDescText = goodsDescText;
    }
}