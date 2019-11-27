package com.naver.s4.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.naver.s4.model.BoardVO;
import com.naver.s4.service.BoardNoticeService;
import com.naver.s4.util.Pager;

//@Controller
@RestController //해당클래스의 모든 메서드가 @ResponseBody를 포함한다면 아예 전문적인 컨트롤러임을 명시한다.
public class JasonController {
	
	@Inject
	private BoardNoticeService boardNoticeService;

	
	@GetMapping("/getJson3")
	//@ResponseBody
	public List<BoardVO> getJson3(Pager pager) throws Exception {
		List<BoardVO> ar = boardNoticeService.boardList(pager);
		
		return ar;
	}
	
	
	@GetMapping("/getJson2")
	//@ResponseBody //보내는게 데이터니까 response에 담아서 요청한 곳으로 바로 보내줘. view가지말구.
	public BoardVO getJson2(BoardVO boardVO) throws Exception {
		//ModelAndView mv = new ModelAndView();
		boardVO = boardNoticeService.boardSelect(boardVO);
		
		/*
		String jmessage = "{"
				+ "\"writer\":\""+boardVO.getWriter()
				+"\",\"title\":\""+boardVO.getTitle()+
				"\",\"contents\":\""+boardVO.getContents()+"\""
				+ "}";
		*/
		//mv.addObject("result", jmessage);
		//mv.setViewName("common/common_ajaxResult");
		
		//return mv;
		return boardVO;
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
