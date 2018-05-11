package com.rolin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rolin.dao.*;
import com.rolin.entity.*;
import com.rolin.utils.DataResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping("/user")
public class UserController {
    private static ShopColMapper shopColMapper;
    private static ActColMapper actColMapper;
    private static GoodsColMapper goodsColMapper;
    private static ShopMapper shopMapper;
    private static GoodsMapper goodsMapper;
    private static ShopActMapper shopActMapper;
    private static ApplicationContext applicationContext;
    static {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");//����spring�����ļ�
        shopColMapper = applicationContext.getBean(ShopColMapper.class);
        actColMapper = applicationContext.getBean(ActColMapper.class);
        goodsColMapper = applicationContext.getBean(GoodsColMapper.class);
        shopMapper = applicationContext.getBean(ShopMapper.class);
        goodsMapper = applicationContext.getBean(GoodsMapper.class);
        shopActMapper = applicationContext.getBean(ShopActMapper.class);
    }
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

    @RequestMapping("/addShopCollection")
    @ResponseBody
    public static String addShopCollection(HttpServletRequest request) throws Exception {
        Integer userId = Integer.parseInt(request.getParameter("userId"));
        Integer shopId = Integer.parseInt(request.getParameter("shopId"));
        ShopCol shopCol = new ShopCol();
        shopCol.setUserId(userId);
        shopCol.setShopId(shopId);
        DataResponse dataResponse = new DataResponse();
        try {
            shopColMapper.insertSelective(shopCol);
            dataResponse.setMsg("添加成功");
            JSONArray jsonArray = JSONArray.fromObject(dataResponse);
            String str = jsonArray.toString();
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
    @RequestMapping("/addActCollection")
    @ResponseBody
    public static String addActCollection(HttpServletRequest request) throws Exception {
        Integer userId = Integer.parseInt(request.getParameter("userId"));
        Integer shopActId = Integer.parseInt(request.getParameter("shopActId"));
        ActCol actCol = new ActCol();
        actCol.setUserId(userId);
        actCol.setShopActId(shopActId);
        DataResponse dataResponse = new DataResponse();
        try {
            actColMapper.insertSelective(actCol);
            dataResponse.setMsg("添加成功");
            JSONArray jsonArray = JSONArray.fromObject(dataResponse);
            String str = jsonArray.toString();
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
    @RequestMapping("/addGoodsCollection")
    @ResponseBody
    public static String addGoodsCollection(HttpServletRequest request) throws Exception {
        Integer userId = Integer.parseInt(request.getParameter("userId"));
        Integer goodsId = Integer.parseInt(request.getParameter("goodsId"));
        GoodsCol goodsCol = new GoodsCol();
        goodsCol.setUserId(userId);
        goodsCol.setGoodsId(goodsId);
        DataResponse dataResponse = new DataResponse();
        try {
            goodsColMapper.insertSelective(goodsCol);
            dataResponse.setMsg("添加成功");
            JSONArray jsonArray = JSONArray.fromObject(dataResponse);
            String str = jsonArray.toString();
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
    @RequestMapping("/selectShopCollection")
    @ResponseBody
    public static String selectShopCollection(HttpServletRequest request) throws Exception {
        Integer userId = Integer.parseInt(request.getParameter("userId"));
        DataResponse dataResponse = new DataResponse();
        try {
            ArrayList<String> shopIds = shopColMapper.selectByUserId(userId);
            ArrayList<Shop> shopArrayList =new ArrayList<Shop>();
            for (int i=0;i<shopIds.size();i++){
                Shop shop = shopMapper.selectByPrimaryKey(Integer.parseInt(shopIds.get(i)));
                shopArrayList.add(shop);
            }
            dataResponse.setData(shopArrayList);
            JSONArray jsonArray = JSONArray.fromObject(dataResponse);
            String str = jsonArray.toString();
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
    @RequestMapping("/selectGoodsCollection")
    @ResponseBody
    public static String selectGoodsCollection(HttpServletRequest request) throws Exception {
        Integer userId = Integer.parseInt(request.getParameter("userId"));
        DataResponse dataResponse = new DataResponse();
        try {
            ArrayList<String> goodsIds = goodsColMapper.selectByUserId(userId);
            ArrayList<Goods> goodsArrayList =new ArrayList<Goods>();
            for (int i=0;i<goodsIds.size();i++){
                Goods goods = goodsMapper.selectByPrimaryKey(Integer.parseInt(goodsIds.get(i)));
                goodsArrayList.add(goods);
            }
            dataResponse.setData(goodsArrayList);
            JSONArray jsonArray = JSONArray.fromObject(dataResponse);
            String str = jsonArray.toString();
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
    @RequestMapping("/selectActCollection")
    @ResponseBody
    public static String selectActCollection(HttpServletRequest request) throws Exception {
        Integer userId = Integer.parseInt(request.getParameter("userId"));
        DataResponse dataResponse = new DataResponse();
        try {
            ArrayList<String> actIds = actColMapper.selectByUserId(userId);
            ArrayList<ShopAct> shopActArrayList =new ArrayList<ShopAct>();
            for (int i=0;i<actIds.size();i++){
                ShopAct shopAct = shopActMapper.selectByPrimaryKey(Integer.parseInt(actIds.get(i)));
                shopActArrayList.add(shopAct);
            }
            dataResponse.setData(shopActArrayList);
            JSONArray jsonArray = JSONArray.fromObject(dataResponse);
            String str = jsonArray.toString();
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
