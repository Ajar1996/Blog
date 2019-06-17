package com.Ajar.Blog.Interceptors;

import com.Ajar.Blog.Pojo.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
拦截器
对后台权限进行控制
 */
public class LoginCheck extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object arg2) throws Exception {
        //如果是登录login则放行
        if (request.getRequestURL().indexOf("/login")>0) {
            return true;
        }
        //如果登录的是控制台的用户
        User user = (User)request.getSession().getAttribute("user");
        if(user.getUserStatus()==1) {
            return true;
        }
        if(user!=null){
            response.sendRedirect(request.getContextPath() + "/index");
        }
        if (user==null){
            //没登录过又不登录login页面,转发到登录页面
            request.setAttribute("msg", "你还没登录");
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }
        return false;
    }
}
