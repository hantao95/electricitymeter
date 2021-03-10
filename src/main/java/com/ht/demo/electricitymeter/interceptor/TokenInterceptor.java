package com.ht.demo.electricitymeter.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * token令牌校验拦截器
 * 丁晓忠
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {
	


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception{
       
        return true;
    }
}