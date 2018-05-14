package com.rolin.dao;

import com.rolin.entity.ActivityRecommend;

public interface ActivityRecommendMapper {
    ActivityRecommend selectByActId(Integer actId);
}
