package com.rolin.entity;

import java.util.Date;

public class BrowseActRec {
    private Integer browseActRecId;

    private Date browseInTime;

    private Date browseOutTime;

    private Integer shopActId;

    private Integer userId;

    public Integer getBrowseActRecId() {
        return browseActRecId;
    }

    public void setBrowseActRecId(Integer browseActRecId) {
        this.browseActRecId = browseActRecId;
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

    public Integer getShopActId() {
        return shopActId;
    }

    public void setShopActId(Integer shopActId) {
        this.shopActId = shopActId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}