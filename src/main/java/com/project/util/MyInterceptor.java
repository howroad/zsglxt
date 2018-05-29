/**
 * 
 */
package com.project.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author howroad
 * @Date 2018年5月4日
 * @version 1.0
 */
public class MyInterceptor implements HandlerInterceptor {
		
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("进入拦截器");
		if(request.getSession().getAttribute("session_user")==null) {
			response.sendRedirect(request.getContextPath()+"/html/login.html");
			return false;
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
