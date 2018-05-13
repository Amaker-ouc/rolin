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
    public ModelAndView getIndex() throws Exception {
        ModelAndView mav = new ModelAndView("mobile/index");
        return mav;
    }

    @RequestMapping("/home")
    public ModelAndView getHome() throws Exception {
        ModelAndView mav = new ModelAndView("mobile/home");
        return mav;
    }
}
