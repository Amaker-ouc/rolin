package com.rolin.controller;

import com.rolin.dao.CartDetailMapper;
import com.rolin.dao.CartMapper;
import com.rolin.dao.GoodsMapper;
import com.rolin.entity.Cart;
import com.rolin.entity.CartDetail;
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
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {
    private static CartMapper cartMapper;
    private static CartDetailMapper cartDetailMapper;
    private static GoodsMapper goodsMapper;
    private static ApplicationContext applicationContext;
    static {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");//����spring�����ļ�
        cartMapper = applicationContext.getBean(CartMapper.class);
        goodsMapper = applicationContext.getBean(GoodsMapper.class);
        cartDetailMapper=applicationContext.getBean(CartDetailMapper.class);
    }

    @RequestMapping("/")
    public ModelAndView getCart() throws Exception {
        System.out.println("/cart");
        ModelAndView mav = new ModelAndView("mobile/cart");
        return mav;
    }
    @ResponseBody
    @RequestMapping(value="/delete",method= RequestMethod.POST,produces = "application/json; charset=utf-8")
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

    @RequestMapping(value="/add",method= RequestMethod.POST,produces = "application/json; charset=utf-8")
    @ResponseBody
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
    @RequestMapping(value="/detail",method= RequestMethod.POST,produces = "application/json; charset=utf-8")
    public static String cartSelect(HttpServletRequest request) throws Exception{
        Integer userId = Integer.parseInt(request.getParameter("userId"));
        DataResponse dataResponse = new DataResponse();
        try {
            ArrayList<CartDetail> cartDetailArrayList = cartDetailMapper.selectByUserId(userId);
            HashMap<String,ArrayList<CartDetail>> hashMap=new HashMap<String, ArrayList<CartDetail>>();
            for(CartDetail c: cartDetailArrayList){
                if(hashMap.containsKey(c.getShopName())) hashMap.get(c.getShopName()).add(c);
                else {
                    ArrayList<CartDetail> cartDetails=new ArrayList<CartDetail>();
                    cartDetails.add(c);
                    hashMap.put(c.getShopName(),cartDetails);
                }
            }
            dataResponse.setData(hashMap);
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
