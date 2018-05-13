package com.rolin.controller;

import com.rolin.dao.CartMapper;
import com.rolin.dao.GoodsMapper;
import com.rolin.entity.Cart;
import com.rolin.utils.DataResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping("/cart")
public class CartController {
    private static CartMapper cartMapper;
    private static GoodsMapper goodsMapper;
    private static ApplicationContext applicationContext;
    static {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");//����spring�����ļ�
        cartMapper = applicationContext.getBean(CartMapper.class);
        goodsMapper = applicationContext.getBean(GoodsMapper.class);
    }

    @RequestMapping("/cart")
    public ModelAndView getCart() throws Exception {
        System.out.println("/cart");
        ModelAndView mav = new ModelAndView("mobile/cart");
        return mav;
    }
    @ResponseBody
    @RequestMapping(value="/delte",method= RequestMethod.POST,produces = "application/json; charset=utf-8")
    public static String cartDelete(HttpServletRequest request) throws Exception{
        Integer cartId = Integer.parseInt(request.getParameter("cartId"));
        DataResponse dataResponse = new DataResponse();
        try {
            cartMapper.deleteByPrimaryKey(cartId);
            dataResponse.setMsg("删除成功");
            JSONObject jsonObject = JSONObject.fromObject(dataResponse);
            String str = jsonObject.toString();
            System.out.println(str);
            return str;
        }
        catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            dataResponse.setCode(200);
            dataResponse.setMsg("服务器错误");
            JSONObject jsonObject = JSONObject.fromObject(dataResponse);
            String str = jsonObject.toString();
            System.out.println(str);
            return str;

        }
    }
    @ResponseBody
    @RequestMapping(value="/insert",method= RequestMethod.POST,produces = "application/json; charset=utf-8")
    public static String cartInsert(HttpServletRequest request) throws Exception{
        Integer userId = Integer.parseInt(request.getParameter("userId"));
        Integer goodsId = Integer.parseInt(request.getParameter("goodsId"));
        Cart cart=new Cart();
        cart.setUserId(userId);
        cart.setGoodsId(goodsId);
        DataResponse dataResponse = new DataResponse();
        try {
            cartMapper.insertSelective(cart);
            dataResponse.setMsg("添加成功");
            JSONObject jsonObject = JSONObject.fromObject(dataResponse);
            String str = jsonObject.toString();
            System.out.println(str);
            return str;
        }
        catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            dataResponse.setCode(200);
            dataResponse.setMsg("服务器错误");
            JSONObject jsonObject = JSONObject.fromObject(dataResponse);
            String str = jsonObject.toString();
            System.out.println(str);
            return str;

        }
    }
    @ResponseBody
    @RequestMapping(value="/",method= RequestMethod.POST,produces = "application/json; charset=utf-8")
    public static String cartSelect(HttpServletRequest request) throws Exception{
        Integer userId = Integer.parseInt(request.getParameter("userId"));
        DataResponse dataResponse = new DataResponse();
        try {
            ArrayList<Cart> cartArrayList = cartMapper.selectByUserId(userId);
            dataResponse.setData(cartArrayList);
            JSONObject jsonObject = JSONObject.fromObject(dataResponse);
            String str = jsonObject.toString();
            System.out.println(str);
            return str;
        }
        catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            dataResponse.setCode(200);
            dataResponse.setMsg("服务器错误");
            JSONObject jsonObject = JSONObject.fromObject(dataResponse);
            String str = jsonObject.toString();
            System.out.println(str);
            return str;

        }
    }


}
