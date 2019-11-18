package com.naver.s4.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public void memberJoin() throws Exception {}

	@PostMapping(value = "memberJoin")
	public ModelAndView memberJoin(MemberVO memberVO) throws Exception {

		
		
		
		int result = memberServiceImpl.memberJoin(memberVO);
		String msg = "회원가입 실패";

		ModelAndView mv = new ModelAndView();

		if (result > 0) {
			msg = "회원가입 성공";
		}

		mv.addObject("msg", msg);
		mv.addObject("path", "../");
		mv.setViewName("common/common_result");

		return mv;
	}

	@GetMapping(value = "memberIdCheck")
	public Model memberIdCheck(MemberVO memberVO, Model model) throws Exception {
		memberVO = memberServiceImpl.memberIdCheck(memberVO);

		String msg = "중복된 아이디입니다.";

		if (memberVO == null) {
			// 아이디 사용가능
			msg = "사용가능한 아이디입니다.";
		}

		model.addAttribute("vo", memberVO);
		model.addAttribute("msg", msg);

		return model;
	}

	@GetMapping("memberLogin")
	public void memberLogin() throws Exception {}

	@PostMapping("memberLogin")
	public String memberLogin(MemberVO memberVO, HttpSession session) throws Exception {
		memberVO = memberServiceImpl.memberLogin(memberVO);
		
		
		if (memberVO != null) {
			String birth =  memberVO.getBirth();
			birth =  birth.substring(0, 10);
			memberVO.setBirth(birth);
			session.setAttribute("member", memberVO);
		}

		return "redirect:../";
	}

	@GetMapping("memberLogout")
	public String memberLogout(HttpSession session) throws Exception {
		// 1. 세션에 있는 vo지우기
		// session.removeAttribute("member");

		// 2. 세션의 시간을 0으로 만들어서 vo지우기
		session.invalidate();

		return "redirect:../";
	}

	@GetMapping("memberMypage")
	public void memberMypage() throws Exception {
	}

	@RequestMapping(value = "memberDelete")
	public ModelAndView memberDelete(MemberVO memberVO, HttpSession session) throws Exception {
		int result = memberServiceImpl.memberDelete(memberVO);
		String msg = "탈퇴 실패";

		ModelAndView mv = new ModelAndView();
		if (result > 0) {
			msg = "탈퇴 성공";
		}

		mv.addObject("msg", msg);
		mv.addObject("path", "../");
		mv.setViewName("common/common_result");

		session.invalidate();

		return mv;
	}

	@GetMapping("memberUpdate")
	public void memberUpdate() throws Exception {
	}

	@PostMapping("memberUpdate")
	public ModelAndView memberUpdate(MemberVO memberVO, HttpSession session) throws Exception {		
		int result = memberServiceImpl.memberUpdate(memberVO);
		String msg = "수정 실패";

		ModelAndView mv = new ModelAndView();
		if (result > 0) {
			msg = "수정 성공";
			session.setAttribute("member", memberVO);
		}

		mv.addObject("msg", msg);
		mv.addObject("path", "../");
		mv.setViewName("common/common_result");

		return mv;
	}
	
	@GetMapping("memberSearchId")
	public void memberSearchId() throws Exception {
	}
	
	@PostMapping("memberSearchId")
	public ModelAndView memberSearchId(MemberVO memberVO) throws Exception{
		memberVO = memberServiceImpl.memberSearchId(memberVO);
		ModelAndView mv = new ModelAndView();
		String id = "";
		String id_1 = "";
		String id_2 = "";
		String re = "";
		
		if(memberVO != null) {
			id = memberVO.getId();
			id_1 = id.substring(0, 3);
			id_2 = id.substring(2);
			
			for(int i =0; i < id_2.length();i++) {
				re = re + "*";
			}
			
			id_2 = id_2.replaceAll(id_2, re);
			id = id_1 + id_2;

			mv.addObject("id", id);
		} else {
			mv.addObject("msg", "아이디를 찾을 수 없습니다.");
		}
		
		mv.setViewName("member/memberSearchId");
	
		return mv;
	}
	
	@GetMapping("memberSearchPw")
	public void memberSearchPw() throws Exception{
	}
	
	
	@PostMapping("memberSearchPw")
	public ModelAndView memberSearchPw(MemberVO memberVO) throws Exception{
		memberVO = memberServiceImpl.memberSearchPw(memberVO);
		ModelAndView mv = new ModelAndView();
		
		if(memberVO != null) {
			mv.addObject("pw", memberVO.getPw());
		} else {
			mv.addObject("msg", "비밀번호를 찾을 수 없습니다.");
		}
		
		mv.setViewName("member/memberSearchPw");
		
		return mv;
	}
	
	
}
