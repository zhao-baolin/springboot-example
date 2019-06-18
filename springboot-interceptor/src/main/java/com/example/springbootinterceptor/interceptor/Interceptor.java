package com.example.springbootinterceptor.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/18
 */
public class Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //在调用controller方法之前会调用此方法


        //System.out.println(request.getServletPath());
        //stem.out.println(request.getRequestURI());
        //System.out.println(request.getHeader("token"));
        //System.out.println(request.getSession());


        //重定向到c
        response.sendRedirect("/Index/c");

        //return false为拦截  return true为放行
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //controller处理完毕后 调用这里
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //页面渲染完毕后调用这里
    }
}
