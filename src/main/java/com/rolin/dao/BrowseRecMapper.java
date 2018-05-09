package com.rolin.dao;

import com.rolin.entity.BrowseRec;

public interface BrowseRecMapper {
    int deleteByPrimaryKey(Integer browseRecId);

    int insert(BrowseRec record);

    int insertSelective(BrowseRec record);

    BrowseRec selectByPrimaryKey(Integer browseRecId);

    int updateByPrimaryKeySelective(BrowseRec record);

    int updateByPrimaryKey(BrowseRec record);
}