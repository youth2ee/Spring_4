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
	public ModelAndView boardList(Pager pager, int result) throws Exception{
		List<BoardVO> ar = boardNoticeService.boardList(pager);
		
		ModelAndView mv = new ModelAndView();
		
			mv.addObject("list", ar);
			mv.addObject("board", "notice");
			
			mv.addObject("result", result);
			
			if(result == 0) {
				mv.addObject("pager", pager);								
			} else {
				pager.setPerPage(5);
				mv.addObject("pager", pager);
			}
			
			mv.setViewName("board/boardList");

		
		return mv;
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public ModelAndView boardWrite() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "notice");
		mv.setViewName("board/boardWrite");
		
		return mv;
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public ModelAndView boardWrite(BoardVO boardVO) throws Exception {
		int result = boardNoticeService.boardWrite(boardVO);

		ModelAndView mv = new ModelAndView();
		String msg = "작성 실패";
		
		if(result > 0) {
			msg = "작성 성공";
			mv.setViewName("redirect:./noticeList");
		} else {
			mv.addObject("msg", msg);
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/common_result");			
		}
		
		return mv;
	}
	
	@RequestMapping("noticeDelete")
	public ModelAndView boardDelete(BoardVO boardVO) throws Exception {
		int result = boardNoticeService.boardDelete(boardVO);
		
		ModelAndView mv = new ModelAndView();
		String msg = "삭제 실패";
		
		if(result > 0) {
			msg = "삭제 성공";
			mv.setViewName("redirect:./noticeList");
		} else {
			mv.addObject("msg", msg);
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/common_result");			
		}
		
		return mv;
	}
	
	@RequestMapping("noticeSelect")
	public ModelAndView boardSelect(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "notice");
		mv.addObject("dto", boardNoticeService.boardSelect(boardVO));
		mv.setViewName("board/boardSelect");
		
		return mv; 
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.GET)
	public ModelAndView boardUpdate(int num) throws Exception {
		ModelAndView mv = new ModelAndView();
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(num);
		mv.addObject("board", "notice");
		mv.addObject("dto", boardNoticeService.boardSelect(boardVO));
		mv.setViewName("board/boardUpdate");
		
		return mv;
	}
	
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public ModelAndView boardUpdate(BoardVO boardVO) throws Exception {
		int result =  boardNoticeService.boardUpdate(boardVO);
		
		ModelAndView mv = new ModelAndView();
		String msg = "수정 실패";
		
		if(result > 0) {
			msg = "수정 성공";
			mv.setViewName("redirect:./noticeList");
		} else {
			mv.addObject("msg", msg);
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/common_result");			
		}
		
		return mv;
	}
	
	
	
}
