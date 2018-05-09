package com.rolin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rolin.utils.CheckMobile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @RequestMapping("/")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView("mobile/index");
        //mav.addObject("title", "shopManage");
        return mav;
//        if(CheckMobile.check(request)) {
//            ModelAndView mav = new ModelAndView("mobile/index");
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
