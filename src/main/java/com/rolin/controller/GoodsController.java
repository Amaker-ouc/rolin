package com.rolin.controller;

import com.rolin.dao.GoodsMapper;
import com.rolin.dao.GoodsModuleMapper;
import com.rolin.dao.ModuleDetailMapper;
import com.rolin.entity.*;
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
import java.util.ArrayList;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    private static GoodsMapper goodsMapper;
    private static GoodsModuleMapper goodsModuleMapper;
    private static ModuleDetailMapper moduleDetailMapper;
    private static ApplicationContext applicationContext;
    static {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");//����spring�����ļ�
        goodsMapper = applicationContext.getBean(GoodsMapper.class);
        goodsModuleMapper = applicationContext.getBean(GoodsModuleMapper.class);
        moduleDetailMapper = applicationContext.getBean(ModuleDetailMapper.class);
    }

    @RequestMapping(value="/{goodsId}",method= RequestMethod.GET)
    public ModelAndView getGoods(@PathVariable String goodsId) throws Exception {
        ModelAndView mav = new ModelAndView("mobile/goods");
        //mav.addObject("title", "shopManage");
        return mav;
    }

    @RequestMapping(value = "/detail",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String goodsDetail(HttpServletRequest request) throws Exception {
        Integer goodsId = Integer.parseInt(request.getParameter("goodsId"));
        DataResponse dataResponse =new DataResponse();
        try {
            Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
            ArrayList<GoodsModule> goodsModules = goodsModuleMapper.selectByGoodsId(goodsId);
            ArrayList<ModuleList> moduleLists = new ManagedList<ModuleList>();
            for (int i = 0; i < goodsModules.size(); i++) {
                ModuleList moduleList = new ModuleList();
                ArrayList<ModuleDetail> moduleDetails = moduleDetailMapper.selectByGoodsModuleId(goodsModules.get(i).getGoodsModuleId());
                moduleList.setModuleDetails(moduleDetails);
                moduleLists.add(moduleList);
            }
            ModuleDetailList moduleDetailList = new ModuleDetailList();
            moduleDetailList.setGoods(goods);
            moduleDetailList.setModuleLists(moduleLists);
            dataResponse.setData(moduleDetailList);
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
    @RequestMapping(value = "/add",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String goodsAdd(HttpServletRequest request) throws Exception {
        Integer goodsId = Integer.parseInt(request.getParameter("goodsId"));
        DataResponse dataResponse =new DataResponse();
        try {
            Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
            ArrayList<GoodsModule> goodsModules = goodsModuleMapper.selectByGoodsId(goodsId);
            ArrayList<ModuleList> moduleLists = new ManagedList<ModuleList>();
            for (int i = 0; i < goodsModules.size(); i++) {
                ModuleList moduleList = new ModuleList();
                ArrayList<ModuleDetail> moduleDetails = moduleDetailMapper.selectByGoodsModuleId(goodsModules.get(i).getGoodsModuleId());
                moduleList.setModuleDetails(moduleDetails);
                moduleLists.add(moduleList);
            }
            ModuleDetailList moduleDetailList = new ModuleDetailList();
            moduleDetailList.setGoods(goods);
            moduleDetailList.setModuleLists(moduleLists);
            dataResponse.setData(moduleDetailList);
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
