package com.rolin.utils;

import com.rolin.controller.ShopController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class ShopLocationTest {
    private static ShopController shopController;
    private static ApplicationContext applicationContext;
    static {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        shopController = applicationContext.getBean(ShopController.class);
    }

    @Test
    public void getShopId() {
        ShopLocation.getShopId(1.0,1.0);
    }
}