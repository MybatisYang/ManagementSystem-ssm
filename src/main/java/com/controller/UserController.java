package com.controller;

import com.pojo.User;
import com.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zjzhou
 * @version 1.0
 */


//@Controller注解用于标示本类为web层控制组件
@Controller
//在默认情况下springmvc的实例都是单例模式，以使用scope域将其注解为每次都创建一个新的实�?
@Scope("prototype")
public class UserController {

    @Autowired
    UserService userService;

    //登录
    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request){
        //调用Service层
        boolean loginType = userService.login(user.getUsername(),user.getPassword());
        //登陆成功
        if(loginType){
            //如果验证通过,则将用户信息传到前台
            request.setAttribute("user",user);
            //并跳转到index.jsp页面
            return "index";
            //登陆失败
        }else{
            request.setAttribute("message","用户名密码错误！");
            return "login";
        }

    }


    //注册
    @RequestMapping("/register")
    public String register(User user){
        boolean registerType = userService.register(user);

            return "register";

    }
}

