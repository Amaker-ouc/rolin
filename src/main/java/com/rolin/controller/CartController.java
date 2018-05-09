package com.rolin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {
    @RequestMapping("/cart")
    public ModelAndView getCart() throws Exception {
        System.out.println("/cart");
        ModelAndView mav = new ModelAndView("mobile/cart");
        return mav;
    }
}
