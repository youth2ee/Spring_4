package com.naver.s4.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.naver.s4.model.BoardNoticeVO;
import com.naver.s4.model.BoardVO;
import com.naver.s4.model.FilesVO;
import com.naver.s4.service.BoardNoticeService;
import com.naver.s4.util.FileSaver;
import com.naver.s4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Inject
	private BoardNoticeService boardNoticeService;
	
	
	@Value("${notice}") //common.properties에서 키값을 통해 value값 호출
	private String board;
	
	
	
	/*
	 * //exception 처리
	 * 
	 * @ExceptionHandler(NullPointerException.class) public ModelAndView getNull() {
	 * ModelAndView mv = new ModelAndView();
	 * mv.setViewName("common/common_500_error"); return mv; }
	 * 
	 * //exception 처리
	 * 
	 * @ExceptionHandler(NumberFormatException.class) public ModelAndView
	 * getNumber() { ModelAndView mv = new ModelAndView();
	 * mv.setViewName("common/common_500_error"); return mv; }
	 * 
	 * //exception 처리
	 * 
	 * @ExceptionHandler(Exception.class) public ModelAndView getException() {
	 * ModelAndView mv = new ModelAndView();
	 * mv.setViewName("common/common_500_error"); return mv; }
	 */
	
	
	
	
	//summer file
	@PostMapping("summerFile")
	public ModelAndView summerFile(MultipartFile file, HttpSession session) throws Exception {
		//System.out.println(file.getOriginalFilename());	
		
		String filename =  boardNoticeService.summerFile(file, session);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/common_ajaxResult");
		mv.addObject("result", filename);
		
		return mv;
	}
	
	
	@PostMapping("summerFileDelete")
	public ModelAndView summerFileDelete(String file, HttpSession session) throws Exception {
		boolean check = boardNoticeService.summerFileDelete(file, session);
		String result = "fail";
		
		if(check) {
			result = "success";
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/common_ajaxResult");
		mv.addObject("result", result);
		
		return mv;
	}
	
	
	
	//file 
	@GetMapping("fileDown")
	public ModelAndView fileDown(FilesVO filesVO) throws Exception {
		filesVO = boardNoticeService.fileSelect(filesVO);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("file", filesVO);
		mv.addObject("board", "notice");
		mv.setViewName("fileDown");
		
		return mv; 
	}
	

	
	@PostMapping("fileDelete")
	public ModelAndView fileDelete(FilesVO filesVO) throws Exception {
		
		System.out.println("Delete");
		System.out.println(filesVO.getFnum());
		
		int result = boardNoticeService.fileDelete(filesVO);
		
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("common/common_ajaxResult");
		mv.addObject("result", result);
		
		return mv;
	}
	
	
	
   //notice
	@RequestMapping("noticeList")
	public ModelAndView boardList(Pager pager) throws Exception{
		List<BoardVO> ar = boardNoticeService.boardList(pager);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		
		//properties 사용하기 : common.properties에서 board 받아오기
		mv.addObject("board", board);
		
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
	public ModelAndView boardWrite(BoardVO boardVO, HttpSession session, MultipartFile [] file) throws Exception {
		//매개변수이름과 파라미터 이름을 맞춰줘야 한다. 따라서 file로 보내므로 file로 받아야 한다.
		//MultipartFile [] file로 받아도 되고, ArrayList<MultipartFile> file로 받아도 된다.
		//MultipartFile []로 받으면 file.length / ArrayList<MultipartFile>로 받으면 file.size()
		//file[i].getOriginalFilename() / file.get(i).getOriginalFilename()
		
		/*
		 * for(int i =0; i<file.length ;i++) {
		 * System.out.println(file[i].getOriginalFilename()); }
		 */
		
		int result = boardNoticeService.boardWrite(boardVO, file ,session);

		 ModelAndView mv = new ModelAndView(); 
		 String msg = "작성 실패";
		  
		  if(result > 0) { 
			  msg = "작성 성공"; 
			  mv.setViewName("redirect:./noticeList"); 
		  }
		  else { 
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
		boardVO = boardNoticeService.boardSelect(boardVO);
		
		//위지위그 : what you see is what you get (WYSIWYG)
		boardVO.setContents(boardVO.getContents().replace("\r\n", "<br>"));
		
		mv.addObject("board", "notice");
		mv.addObject("dto", boardVO);
		mv.setViewName("board/boardSelect");
		
		return mv; 
	}
	
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.GET)
	public ModelAndView boardUpdate(int num) throws Exception {
		ModelAndView mv = new ModelAndView();
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(num);
		
		//BoardNoticeVO boardNoticeVO = (BoardNoticeVO)boardVO;
		//mv.addObject("count", boardNoticeVO.getFiles().size());

		mv.addObject("board", "notice");
		mv.addObject("dto", boardNoticeService.boardSelect(boardVO));
		mv.setViewName("board/boardUpdate");
		
		return mv;
	}
	
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public ModelAndView boardUpdate(BoardVO boardVO, MultipartFile [] file, HttpSession session) throws Exception {
		int result =  boardNoticeService.boardUpdate(boardVO, file, session);
		
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
