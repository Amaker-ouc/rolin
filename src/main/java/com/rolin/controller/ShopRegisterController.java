package com.rolin.controller;

import com.rolin.dao.ShopMapper;
import com.rolin.entity.Shop;
import com.rolin.utils.DataResponse;
import net.sf.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ShopRegisterController {
    private static ShopMapper shopMapper;
    private static ApplicationContext applicationContext;
    static {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");//加载spring配置文件
        shopMapper = applicationContext.getBean(ShopMapper.class);
    }

    @RequestMapping(value = "/shopRegister",method = RequestMethod.POST)
    @ResponseBody
    public String handleRequest(HttpServletRequest request) throws Exception {
        System.out.println("/shopRegister");
        DataResponse dataResponse = new DataResponse();
        try {
            String userId=request.getParameter("userId");
            String shopName = request.getParameter("shopName");
            double lng = Double.parseDouble(request.getParameter("lng"));
            double lat = Double.parseDouble(request.getParameter("lat"));

            if(shopMapper.selectByShopName(shopName)==null) {
                Shop shop = new Shop();
                shop.setUserId(Integer.valueOf(userId));
                shop.setShopName(shopName);
                shop.setLat(lat);
                shop.setLng(lng);
                shopMapper.insert(shop);
                shop = shopMapper.selectByShopName(shopName);
                dataResponse.setCode(0);
                dataResponse.setMsg("success");
                dataResponse.setData(shop);
                JSONObject jsonObject = JSONObject.fromObject(dataResponse);
                String str = jsonObject.toString();
                System.out.println(str);
                return str;
            }
            else{
                dataResponse.setCode(200);
                dataResponse.setMsg("店铺名已存在");
                JSONObject jsonObject = JSONObject.fromObject(dataResponse);
                String str = jsonObject.toString();
                return str;
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            dataResponse.setCode(200);
            dataResponse.setMsg("服务器出错");
            JSONObject jsonObject = JSONObject.fromObject(dataResponse);
            String str = jsonObject.toString();
            return str;
        }
    }
}
