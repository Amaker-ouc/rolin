package com.rolin.dao;

import com.rolin.entity.ModuleDetail;

import java.util.ArrayList;

public interface ModuleDetailMapper {
    int deleteByPrimaryKey(Integer moduleDetailId);

    int insert(ModuleDetail record);

    int insertSelective(ModuleDetail record);

    ModuleDetail selectByPrimaryKey(Integer moduleDetailId);

    ArrayList<ModuleDetail> selectByGoodsModuleId(Integer goodsModuleId);

    int updateByPrimaryKeySelective(ModuleDetail record);

    int updateByPrimaryKey(ModuleDetail record);
}