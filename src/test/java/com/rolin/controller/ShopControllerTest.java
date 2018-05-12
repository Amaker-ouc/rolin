package com.rolin.controller;

import com.rolin.dao.*;
import com.rolin.entity.Shop;
import com.rolin.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;

public class ShopControllerTest {

    private static ShopController shopController;
    private static UserMapper userMapper;
    private static ShopMapper shopMapper;

    private static ApplicationContext applicationContext;
    static {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        shopController = applicationContext.getBean(ShopController.class);
        userMapper = applicationContext.getBean(UserMapper.class);
        shopMapper = applicationContext.getBean(ShopMapper.class);
    }

    @Test
    public void shopDetail() {
        User user = new User();
        Random rand = new Random();
        for(int i=0;i<100;i++){
            user.setAge(rand.nextInt(40)+15);
            String a=randomS();
            user.setUserName(a);
            user.setPassword(a);
            user.setSex(rand.nextInt(2)-1);
            userMapper.insert(user);
        }
    }
    public String randomS(){
        String s="";
        for(int i=0 ;i<6;i++){
            Random rand = new Random();
            char c =(char)(rand.nextInt(26)+97);
            s=s+(String.valueOf(c));
        }
        return s;
    }
    @Test
    public void shopGoods() {
        for(int i =0;i<20;i++) {
            Random rand = new Random();
            Shop shop = new Shop();
            shop.setLat(rand.nextDouble() + rand.nextInt(10) + 115);
            shop.setLng(rand.nextDouble() + rand.nextInt(2) + 34);
            shop.setShopCatName("超市");
            shop.setUserId(i+31);
            shopMapper.insert(shop);
        }
    }
    @Test
    public void set() {
        for(int i =0;i<20;i++) {
            Random rand = new Random();
            Shop shop = new Shop();
            shop.setLat(rand.nextDouble() + rand.nextInt(10) + 115);
            shop.setLng(rand.nextDouble() + rand.nextInt(2) + 34);
            shop.setShopCatName("超市");
            shop.setUserId(i+31);
            shopMapper.insert(shop);
        }
    }

}