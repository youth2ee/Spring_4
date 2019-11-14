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
	public ModelAndView boardWrite() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "qna");
		mv.setViewName("board/boardWrite");
		
		return mv;
	}
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public ModelAndView boardWrite(BoardVO boardVO) throws Exception {
		int result = boardQnaService.boardWrite(boardVO);
	
		ModelAndView mv = new ModelAndView();
		String msg = "작성 실패";
		
		if(result > 0) {
			msg = "작성 성공";
			mv.setViewName("redirect:./qnaList");
		} else {
			mv.addObject("msg", msg);
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/common_result");
		}
		
		return mv;
	}
	
	@RequestMapping("qnaDelete") 
	public ModelAndView boardDelete(BoardVO boardVO) throws Exception {
		int result = boardQnaService.boardDelete(boardVO);
		
		ModelAndView mv = new ModelAndView();
		String msg = "삭제 실패";
		
		if(result > 0) {
			msg = "삭제 성공";
			mv.setViewName("redirect:./qnaList");
		} else {
			mv.addObject("msg", msg);
			mv.addObject("path", "./qnaList");
			mv.setViewName("common/common_result");
		}
		
		return mv;
	}
	
	
	@RequestMapping("qnaSelect")
	public ModelAndView boardSelect(BoardVO boardVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", "qna");
		mv.addObject("dto", boardQnaService.boardSelect(boardVO)); 
		mv.setViewName("board/boardSelect");
		
		return mv;
	}
	
	
	@RequestMapping(value = "qnaUpdate", method = RequestMethod.GET)
	public ModelAndView boardUpdate(int num) throws Exception {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(num);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", boardQnaService.boardSelect(boardVO));
		mv.addObject("board", "qna");
		mv.setViewName("board/boardUpdate");
		
		return mv;
	}
	
	@RequestMapping(value = "qnaUpdate", method = RequestMethod.POST)
	public ModelAndView boardUpdate(BoardVO boardVO) throws Exception {
		int result = boardQnaService.boardUpdate(boardVO);
		ModelAndView mv = new ModelAndView();
		String msg = "수정 실패";
		
		if(result > 0) {
			msg = "수정 성공";
			mv.setViewName("redirect:./qnaList");
		} else {
			mv.addObject("msg", msg);
			mv.addObject("path", "qna/qnaList");
			mv.setViewName("common/common_result");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "qnaReply", method = RequestMethod.GET)
	public ModelAndView boardReply(int num) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("num", num);
		mv.setViewName("board/boardReply");
		
		return mv;
	}
	
	
	@RequestMapping(value = "qnaReply", method = RequestMethod.POST)
	public ModelAndView boardReply(BoardVO boardVO) throws Exception {
		int result = boardQnaService.boardReply(boardVO);
		
		ModelAndView mv = new ModelAndView();
		String msg = "댓글 추가 실패";
		
		if(result > 0) {
			msg = "댓글 추가 성공";
			mv.setViewName("redirect:./qnaList");
		} else {
			mv.addObject("msg", msg);
			mv.addObject("path", "qna/qnaList");
			mv.setViewName("common/common_result");
		}
		
		return mv;
	}

}
