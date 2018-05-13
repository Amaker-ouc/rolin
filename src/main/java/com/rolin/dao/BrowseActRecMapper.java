package com.rolin.dao;

import com.rolin.entity.BrowseActRec;

public interface BrowseActRecMapper {
    int deleteByPrimaryKey(Integer browseActRecId);

    int insert(BrowseActRec record);

    int insertSelective(BrowseActRec record);

    BrowseActRec selectByPrimaryKey(Integer browseActRecId);

    int updateByPrimaryKeySelective(BrowseActRec record);

    int updateByPrimaryKey(BrowseActRec record);
}