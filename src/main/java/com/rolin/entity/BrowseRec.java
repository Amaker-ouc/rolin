package com.rolin.entity;

import java.util.Date;

public class BrowseRec {
    private Integer browseRecId;

    private Date browseInTime;

    private Date browseOutTime;

    private Integer goodsId;

    private Integer userId;

    public Integer getBrowseRecId() {
        return browseRecId;
    }

    public void setBrowseRecId(Integer browseRecId) {
        this.browseRecId = browseRecId;
    }

    public Date getBrowseInTime() {
        return browseInTime;
    }

    public void setBrowseInTime(Date browseInTime) {
        this.browseInTime = browseInTime;
    }

    public Date getBrowseOutTime() {
        return browseOutTime;
    }

    public void setBrowseOutTime(Date browseOutTime) {
        this.browseOutTime = browseOutTime;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}