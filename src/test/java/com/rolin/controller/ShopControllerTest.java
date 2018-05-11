package com.rolin.controller;

import com.rolin.dao.GoodsMapper;
import com.rolin.dao.ShopActMapper;
import com.rolin.dao.ShopMapper;
import com.rolin.dao.ShopScrollImgMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;

public class ShopControllerTest {

    private static ShopController shopController;
    private static ApplicationContext applicationContext;
    static {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        shopController = applicationContext.getBean(ShopController.class);
    }

    @Test
    public void shopDetail() {
        try {
        }
        catch (Exception e){

        }
    }

    @Test
    public void shopGoods() {
        try {
        }
        catch (Exception e){

        }
    }
}