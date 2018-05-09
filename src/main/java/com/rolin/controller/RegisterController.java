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

@Controller
public class RegisterController {
    private static UserMapper userMapper;
    private static ApplicationContext applicationContext;
    static {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");//加载spring配置文件
        userMapper = applicationContext.getBean(UserMapper.class);
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public String handleRequest(HttpServletRequest request) throws Exception {
        System.out.println("/register");
        DataResponse dataResponse=new DataResponse();
        try {
            String username = request.getParameter("username");
            String password1 = request.getParameter("password1");
            String password2 = request.getParameter("password2");
            if(username==null||password1==null||password2==null){
                dataResponse.setCode(100);
                dataResponse.setMsg("输入出错，请检查");
                JSONObject jsonObject=JSONObject.fromObject(dataResponse);
                String str=jsonObject.toString();
                return str;
            }
            else if(!password1.equals(password2)){
                dataResponse.setCode(100);
                dataResponse.setMsg("两次输入密码不匹配");
                JSONObject jsonObject=JSONObject.fromObject(dataResponse);
                String str=jsonObject.toString();
                return str;
            }
            else if(userMapper.selectByUsername(username)!=null){
                dataResponse.setCode(100);
                dataResponse.setMsg("用户已存在");
                JSONObject jsonObject=JSONObject.fromObject(dataResponse);
                String str=jsonObject.toString();
                return str;
            }
            else{
                User user=new User();
                user.setUserName(username);
                user.setPassword(password1);
                userMapper.insert(user);
                user.setUserId(userMapper.selectByUsername(username));
                dataResponse.setCode(0);
                dataResponse.setMsg("seccess");
                dataResponse.setData(user);
                JSONObject jsonObject=JSONObject.fromObject(dataResponse);
                String str=jsonObject.toString();
                System.out.println(str);
                return str;
            }
        }
        catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            dataResponse.setCode(200);
            dataResponse.setMsg("服务器出错");
            JSONObject jsonObject=JSONObject.fromObject(dataResponse);
            String str=jsonObject.toString();
            return str;
        }
    }
}
