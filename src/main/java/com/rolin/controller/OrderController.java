package com.rolin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/commit")
    public ModelAndView getOrderCommit() throws Exception {
        System.out.println("/order/commit");
        ModelAndView mav = new ModelAndView("mobile/orderCommit");
        return mav;
    }
}


