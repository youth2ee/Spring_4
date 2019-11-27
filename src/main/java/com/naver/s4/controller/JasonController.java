package com.naver.s4.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.naver.s4.model.BoardVO;
import com.naver.s4.service.BoardNoticeService;

@Controller
public class JasonController {
	
	@Inject
	private BoardNoticeService boardNoticeService;

	
	
	@GetMapping("/getJson2")
	public ModelAndView getJson2(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardVO = boardNoticeService.boardSelect(boardVO);
		
		
		
		
		return mv;
	}
	
	
	

	@GetMapping("/getJson1")
	public ModelAndView getJson1() throws Exception  {
		//name = pooh, age = 10
		String jmessage = "{ \"name\":\"pooh\" , \"age\":27 }";
		System.out.println(jmessage);
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", jmessage);
		mv.setViewName("common/common_ajaxResult");
		
		return mv;
	}
	
	
}
