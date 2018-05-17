package com.rolin.dao;

import com.rolin.entity.CartDetail;

import java.util.ArrayList;

public interface CartDetailMapper {
    ArrayList<CartDetail> selectByUserId(Integer userId);
}
