package com.rolin.dao;

import com.rolin.entity.ActCat;

public interface ActCatMapper {
    int deleteByPrimaryKey(Integer actId);

    int insert(ActCat record);

    int insertSelective(ActCat record);

    ActCat selectByPrimaryKey(Integer actId);

    int updateByPrimaryKeySelective(ActCat record);

    int updateByPrimaryKey(ActCat record);
}