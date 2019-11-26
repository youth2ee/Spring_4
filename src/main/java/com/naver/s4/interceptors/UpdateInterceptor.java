package com.naver.s4.interceptors;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.naver.s4.model.BoardVO;
import com.naver.s4.model.MemberVO;

@Component
public class UpdateInterceptor extends HandlerInterceptorAdapter {
	
	//Controller 종료 후 : ex) 로그인한 사람 중, 글쓴사람만 업데이트 하기
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		//id받기
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("member");
		memberVO.getId();
		
		//writer받기
		Map<String, Object> map = modelAndView.getModel();
		BoardVO boardVO = (BoardVO)map.get("dto");
		boardVO.getWriter();
		
		//board명 받기
		String board = (String)map.get("board");
		
		
		if(!memberVO.getId().equals(boardVO.getWriter())) {
			modelAndView.setViewName("common/common_result");
			modelAndView.addObject("path", "./"+board+"List");
			modelAndView.addObject("msg", "권한이 없습니다.");
			
		}
		
		super.postHandle(request, response, handler, modelAndView);
	}

}
