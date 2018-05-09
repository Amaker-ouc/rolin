package com.rolin.controller;

import com.rolin.dao.UserMapper;
import com.rolin.entity.User;
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
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    private static UserMapper userMapper;
    private static ApplicationContext applicationContext;
    static {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");//加载spring配置文件
        userMapper = applicationContext.getBean(UserMapper.class);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    @ResponseBody
    public String handleRequest(HttpServletRequest request) throws Exception {
        System.out.println("/login");
        DataResponse dataResponse=new DataResponse();
        String str;
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if(username==null||password==null){
                dataResponse.setCode(100);
                dataResponse.setMsg("用户名或密码为空");
            }
            Integer userId=userMapper.selectByUsername(username);
            if(userId!=null){
                User user=userMapper.selectByPrimaryKey(userId);
                if(user.getPassword().equals(password)) {
                    dataResponse.setCode(0);
                    dataResponse.setMsg("success");
                    dataResponse.setData(user);
                }
                else{
                    dataResponse.setCode(100);
                    dataResponse.setMsg("账号或密码出错");
                }
            }
            else{
                dataResponse.setCode(100);
                dataResponse.setMsg("账号或密码出错");
            }
            JSONObject jsonObject=JSONObject.fromObject(dataResponse);
            str=jsonObject.toString();
            System.out.println(str);
            return str;
        }
        catch (Exception e){
            dataResponse.setCode(200);
            dataResponse.setMsg("服务器出错");
            JSONObject jsonObject=JSONObject.fromObject(dataResponse);
            str=jsonObject.toString();
            return str;
        }
    }
}
