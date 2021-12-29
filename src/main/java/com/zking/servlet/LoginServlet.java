package com.zking.servlet;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session
        HttpSession session = req.getSession();
        //获取到前端传递过来的账号、密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //创建用户登录令牌
        UsernamePasswordToken token=new UsernamePasswordToken(
                username,password
        );
        //获取用户主体信息
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            session.setAttribute("username",username);
            resp.sendRedirect("main.jsp");
        } catch (IncorrectCredentialsException e) {
            session.setAttribute("message","密码有误!");
            resp.sendRedirect("login.jsp");
        } catch (UnknownAccountException e) {
            session.setAttribute("message","账号不存在!");
            resp.sendRedirect("login.jsp");
        }

    }
}
