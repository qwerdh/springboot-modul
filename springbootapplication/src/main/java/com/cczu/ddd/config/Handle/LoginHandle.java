package com.cczu.ddd.config.Handle;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ddd
 * @create 2020-03-04    16:56
 **/
public class LoginHandle implements HandlerInterceptor {
    // 拦截器
    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception{
        Object user=request.getSession().getAttribute("username");
        if(user==null){
            // 未登录
            request.setAttribute("message","账户未登陆");
            // 转发请求 ，并显示错误消息
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
        else{
            // 已登录
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


}
