package com.zking.controller;

import com.zking.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String goLogin(){return "login";}

    @RequiresPermissions("书本修改")
    @RequestMapping("/update")
    public String updateUser(){
        return "admin/updateUser";
    }

    @RequestMapping("/login")
    public String login(User user, HttpSession session) {
        //先获取主体对象
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(
                user.getUsername(),user.getPassword()
        );
        System.out.println(user);
        boolean f=true;
        try {
            subject.login(token);
            session.setAttribute("username",user.getUsername());
        } catch (AuthenticationException e) {
            f=false;
        }
        if (f){
            return "main";
        }else{
            return "login";
        }
    }
}
