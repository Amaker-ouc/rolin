package com.rolin.controller;

import com.rolin.dao.ActivityRecommendMapper;
import com.rolin.entity.ActivityRecommend;
import com.rolin.entity.ShopAct;
import com.rolin.utils.DataResponse;
import com.rolin.utils.HttpConnection;
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
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/moment")
public class MomentController {
    private static ActivityRecommendMapper activityRecommendMapper;
    private static ApplicationContext applicationContext;
    static {
        applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        activityRecommendMapper=applicationContext.getBean(ActivityRecommendMapper.class);
    }
    @RequestMapping("/")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("/moment");
        ModelAndView mav = new ModelAndView("mobile/moment");
        //mav.addObject("title", "shopManage");
        return mav;
    }


    @RequestMapping(value = "/recommend",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String momentRecommend(HttpServletRequest request) throws Exception{
        String userId=request.getParameter("userId");
        Map<String,String> map=new HashMap<String,String>();
        map.put("userId",userId);
        String recommendActId=HttpConnection.jsonPost("http://127.0.0.1:5000/recommend_activity",map);
        JSONArray json = JSONArray.fromObject(recommendActId);
        List<Integer> actIds= (List<Integer>)JSONArray.toCollection(json, Integer.class);
        DataResponse dataResponse =new DataResponse();
        try {
            ArrayList<ActivityRecommend> activityRecommends=new ArrayList<ActivityRecommend>();
            for (Integer actId : actIds) {
                ActivityRecommend activityRecommend=activityRecommendMapper.selectByActId(actId);
                activityRecommends.add(activityRecommend);
            }
            dataResponse.setData(activityRecommends);
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
