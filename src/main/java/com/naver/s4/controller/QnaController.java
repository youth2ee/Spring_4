package com.naver.s4.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naver.s4.model.BoardQnaVO;
import com.naver.s4.model.BoardVO;
import com.naver.s4.service.BoardQnaService;
import com.naver.s4.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@Inject
	private BoardQnaService boardQnaService;
	
	@RequestMapping("qnaList")
	public ModelAndView boardList(Pager pager) throws Exception {
		List<BoardVO> ar =  boardQnaService.boardList(pager);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.addObject("board", "qna");

		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.GET)
	public ModelAndView boardWrite(Model model) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "qna");
		mv.setViewName("board/boardWrite");
		
		return mv;
	}
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public ModelAndView boardWrite(BoardVO boardVO) throws Exception {
		int result = boardQnaService.boardWrite(boardVO);
		String msg = "작성 실패";
		
		if(result > 0) {
			msg = "작성 성공";
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", msg);
		mv.addObject("path", "qna/qnaList");
		mv.setViewName("common/common_result");
		
		return mv;
		
	}
	
}
