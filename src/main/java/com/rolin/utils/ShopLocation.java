package com.rolin.utils;

import com.rolin.dao.ShopMapper;
import com.rolin.entity.Shop;
import net.sf.json.JSONArray;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShopLocation {
    private static ShopMapper shopMapper;
    private static ApplicationContext applicationContext;
    static {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        shopMapper = applicationContext.getBean(ShopMapper.class);
    }
    public static int getShopId(Double lng,Double lat){
        Shop shop = shopMapper.selectByLocation(lng,lat);
        JSONArray jsonArray = JSONArray.fromObject(shop);
        String str = jsonArray.toString();
        System.out.println(str);
        return shop.getShopId();
    }
}
