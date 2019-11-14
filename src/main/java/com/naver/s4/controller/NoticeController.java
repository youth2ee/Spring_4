package com.naver.s4.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naver.s4.model.BoardVO;
import com.naver.s4.service.BoardNoticeService;
import com.naver.s4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Inject
	private BoardNoticeService boardNoticeService;

	@RequestMapping("noticeList")
	public ModelAndView boardList(Pager pager) throws Exception{
		List<BoardVO> ar = boardNoticeService.boardList(pager);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.addObject("board", "notice");
		
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public ModelAndView boardWrite(Model model) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "notice");
		mv.setViewName("board/boardWrite");
		
		return mv;
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public ModelAndView boardWrite(BoardVO boardVO) throws Exception {
		int result = boardNoticeService.boardWrite(boardVO);
		String msg = "작성 실패";
		
		if(result > 0) {
			msg = "작성 성공";
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", msg);
		mv.addObject("path", "notice/noticeList");
		mv.setViewName("common/common_result");

		return mv;
	}
	
	
	
}
