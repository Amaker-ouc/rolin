package com.rolin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SettingController {
    @RequestMapping("/settings")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("/settings");
        ModelAndView mav = new ModelAndView("mobile/settings");
        //mav.addObject("title", "shopManage");
        return mav;
    }
}
