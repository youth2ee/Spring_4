package com.naver.s4.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	//Controller 진입 전 : ex) 로그인해야 글하나 볼수있게 하기
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		boolean result = false;
		Object obj = request.getSession().getAttribute("member");
		
		if(obj != null) {
			result = true;
		} else {
			response.sendRedirect("../member/memberLogin");
		}
		
		//true면 controller로 보내기
		//false면 controller로 안보내기
		
		return result;
	}
	
	
}
