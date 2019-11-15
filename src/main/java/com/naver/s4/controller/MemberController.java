package com.naver.s4.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naver.s4.model.MemberVO;
import com.naver.s4.service.MemberServiceImpl;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@Inject
	private MemberServiceImpl memberServiceImpl;

	@GetMapping(value = "memberJoin")
	public void memberJoin() throws Exception {
	}
	
	@PostMapping(value = "memberJoin") 
	public ModelAndView memberJoin(MemberVO memberVO) throws Exception {
		int result = memberServiceImpl.memberJoin(memberVO);
		String msg = "회원가입 실패";
		
		ModelAndView mv = new ModelAndView();
		
		if(result > 0) {
			msg = "회원가입 성공";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", "../");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@RequestMapping(value = "memberDelete")
	public ModelAndView memberDelete(MemberVO memberVO) throws Exception {
		int result = memberServiceImpl.memberDelete(memberVO);
		String msg = "탈퇴 실패";
	
		ModelAndView mv = new ModelAndView();
		if(result > 0) {
			msg = "탈퇴 성공";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", "../");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	
	
}
