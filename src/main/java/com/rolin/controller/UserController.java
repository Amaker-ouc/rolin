package com.rolin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rolin.utils.CheckMobile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("/user");
        ModelAndView mav = new ModelAndView("mobile/user");
        //mav.addObject("title", "shopManage");
        return mav;
    }

    @RequestMapping("/shopCollection")
    public ModelAndView getShopCollection() throws Exception {
        System.out.println("/user/shopCollection");
        ModelAndView mav = new ModelAndView("mobile/shopCollection");
        return mav;
    }

    @RequestMapping("/activityCollection")
    public ModelAndView getActivityCollection() throws Exception {
        System.out.println("/user/activityCollection");
        ModelAndView mav = new ModelAndView("mobile/activityCollection");
        return mav;
    }

    @RequestMapping("/goodsCollection")
    public ModelAndView getGoodsCollection() throws Exception {
        System.out.println("/user/goodsCollection");
        ModelAndView mav = new ModelAndView("mobile/goodsCollection");
        return mav;
    }
}
