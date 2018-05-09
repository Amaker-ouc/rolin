package com.rolin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AboutController {
    @RequestMapping("/about")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("/about");
        ModelAndView mav = new ModelAndView("mobile/activity");
        //mav.addObject("title", "shopManage");
        return mav;
//        if(CheckMobile.check(request)) {
//            ModelAndView mav = new ModelAndView("mobile/about");
//            mav.addObject("title", "shopManage");
//            return mav;
//        }
//        else{
//            ModelAndView mav = new ModelAndView("pc/shop/index");
//            mav.addObject("title", "shopManage");
//            return mav;
//        }
    }
}