package com.rolin.controller;

import com.rolin.dao.GoodsMapper;
import com.rolin.dao.ShopActGoodsMapper;
import com.rolin.dao.ShopActMapper;
import com.rolin.entity.ActivityDetail;
import com.rolin.entity.Goods;
import com.rolin.entity.ShopAct;
import com.rolin.utils.DataResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by 72746 on 2018/4/12.
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {
    private static ShopActMapper shopActMapper;
    private static ShopActGoodsMapper shopActGoodsMapper;
    private static GoodsMapper goodsMapper;
    private static ApplicationContext applicationContext;
    static {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        shopActGoodsMapper = applicationContext.getBean(ShopActGoodsMapper.class);
        shopActMapper = applicationContext.getBean(ShopActMapper.class);
        goodsMapper = applicationContext.getBean(GoodsMapper.class);
    }

    @RequestMapping(value="/{activityId}",method= RequestMethod.GET)
    public ModelAndView getActivity(@PathVariable String activityId) throws Exception {
        ModelAndView mav = new ModelAndView("mobile/activity");
        //mav.addObject("title", "shopManage");
        return mav;
    }

    @RequestMapping(value="/detail",method= RequestMethod.POST,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String activityDetail(HttpServletRequest request)throws Exception {
        Integer activityId = Integer.parseInt(request.getParameter("activityId"));
        DataResponse dataResponse = new DataResponse();
        ActivityDetail activityDetail = new ActivityDetail();
        try {
            ShopAct shopAct = shopActMapper.selectByPrimaryKey(activityId);
            ArrayList<Integer> goodsIds = shopActGoodsMapper.selectByShopActId(activityId);
            ArrayList<Goods> goodsArrayList = new ManagedList<Goods>();
            for (int i = 0; i < goodsIds.size(); i++) {
                goodsArrayList.add(goodsMapper.selectByPrimaryKey(goodsIds.get(i)));
            }
            activityDetail.setShopAct(shopAct);
            activityDetail.setGoodsArrayList(goodsArrayList);
            dataResponse.setData(activityDetail);
            JSONArray jsonArray = JSONArray.fromObject(dataResponse);
            String str = jsonArray.toString();
            System.out.println(str);
            return str;
        } catch (Exception e) {
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
