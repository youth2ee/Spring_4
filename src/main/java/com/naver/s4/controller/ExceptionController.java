package com.naver.s4.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

//예외처리하는 컨트롤러 만들때 쓰는 어노테이션
@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView getNull() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/common_500_error");
		return mv;
	}
	
	
	/*
	 * @ResponseStatus(HttpStatus.NOT_FOUND) public ModelAndView getClient() {
	 * 
	 * ModelAndView mv = new ModelAndView();
	 * mv.setViewName("common/common_500_error"); return mv; }
	 */
	

}
