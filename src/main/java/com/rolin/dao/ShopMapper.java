package com.rolin.dao;

import com.rolin.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface ShopMapper {
    int deleteByPrimaryKey(Integer shopId);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(Integer shopId);

    Shop selectByLocation(@Param("lng") Double lng, @Param("lat") Double lat);

    ArrayList<Shop> selectByLocationAll(@Param("lng") Double lng, @Param("lat") Double lat);

    int updateByPrimaryKeySelective(Shop record);

    Shop selectByShopName(String shopName);

    int updateByPrimaryKey(Shop record);
}