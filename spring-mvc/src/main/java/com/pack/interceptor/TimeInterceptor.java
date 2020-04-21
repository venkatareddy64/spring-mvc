package com.pack.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TimeInterceptor extends HandlerInterceptorAdapter {
	long x,y;
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler)throws Exception{
		x=System.currentTimeMillis();
	return true;	
	}
	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response,Object handler,ModelAndView modelAndView)throws Exception{
		y=System.currentTimeMillis();
	System.out.println("time taken to process "+request.getRequestURI()+"is :"+(y-x)+"milliseconds");	
	}
	
	

}
