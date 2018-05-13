package com.rolin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rolin.dao.GoodsMapper;
import com.rolin.dao.ShopActMapper;
import com.rolin.dao.ShopMapper;
import com.rolin.dao.ShopScrollImgMapper;
import com.rolin.entity.Goods;
import com.rolin.entity.Shop;
import com.rolin.entity.ShopDetail;
import com.rolin.utils.CheckMobile;
import com.rolin.utils.DataResponse;
import com.rolin.utils.ShopLocation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

@RequestMapping("/shop")
@Controller
public class ShopController {
    private static ShopMapper shopMapper;
    private static ShopActMapper shopActMapper;
    private static ShopScrollImgMapper shopScrollImgMapper;
    private static GoodsMapper goodsMapper;
    private static ApplicationContext applicationContext;
    static {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        shopMapper = applicationContext.getBean(ShopMapper.class);
        shopActMapper = applicationContext.getBean(ShopActMapper.class);
        shopScrollImgMapper = applicationContext.getBean(ShopScrollImgMapper.class);
        goodsMapper = applicationContext.getBean(GoodsMapper.class);
    }

    @RequestMapping(value="/{shopId}",method= RequestMethod.GET)
    public ModelAndView getShop(@PathVariable String shopId) throws Exception {
        System.out.println("shopController "+shopId);
        ModelAndView mav = new ModelAndView("mobile/shop");
        //mav.addObject("title", "shopManage");
        return mav;
    }

    @ResponseBody
    @RequestMapping(value="/detail",method= RequestMethod.POST,produces = "application/json; charset=utf-8")
    public String shopDetail(HttpServletRequest request) throws Exception {
        System.out.println("/shop/detail");
        Double lng = Double.parseDouble(request.getParameter("lng"));
        Double lat = Double.parseDouble(request.getParameter("lat"));
        DataResponse dataResponse = new DataResponse();
        try {
            Integer shopId = ShopLocation.getShopId(lng,lat);
            if(shopId==null){
                dataResponse.setCode(200);
                dataResponse.setMsg("附近没有店铺");
            }
            else {
                ShopDetail shopDetail = new ShopDetail();
                Shop shop = shopMapper.selectByPrimaryKey(shopId);
                shopDetail.setShop(shop);
                shopDetail.setActs(shopActMapper.selectByShopId(shopId));
                shopDetail.setScrollImgs(shopScrollImgMapper.selectByShopId(shopId));
                dataResponse.setCode(0);
                dataResponse.setData(shopDetail);

            }
            JSONObject jsonObject = JSONObject.fromObject(dataResponse);
            String str = jsonObject.toString();
            System.out.println(str);
            return str;
        }
        catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            dataResponse.setCode(200);
            dataResponse.setMsg("服务器错误");
            JSONObject jsonObject = JSONObject.fromObject(dataResponse);
            String str = jsonObject.toString();
            System.out.println(str);
            return str;
        }


    }
    public class JsonDateValueProcessor implements JsonValueProcessor {
        private String format ="yyyy-MM-dd";
        public Object processArrayValue(Object value, JsonConfig config) {
            return process(value);
        }
        public Object processObjectValue(String key, Object value, JsonConfig config) {
            return process(value);
        }
        private Object process(Object value){
            if(value instanceof Date){
                SimpleDateFormat sdf = new SimpleDateFormat(format,Locale.UK);
                return sdf.format(value);
            }
            return value == null ? "" : value.toString();
        }
    }

    @RequestMapping(value = "/goods",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String shopGoods(HttpServletRequest request) throws Exception {
        System.out.println("/shop/goods");
        Integer shopId=Integer.parseInt(request.getParameter("shopId"));
        Integer page=Integer.parseInt(request.getParameter("page"));
        DataResponse dataResponse = new DataResponse();
        try {
            if(shopId==null){
                dataResponse.setCode(200);
                dataResponse.setMsg("附近没有店铺");
            }
            else {
                ArrayList<Goods> goodsArrayList = goodsMapper.selectByShopId(shopId, page*6);
                dataResponse.setData(goodsArrayList);
            }
            JSONObject jsonObject = JSONObject.fromObject(dataResponse);
            String str = jsonObject.toString();
            System.out.println(str);
            return str;
        }
        catch (Exception e) {
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
