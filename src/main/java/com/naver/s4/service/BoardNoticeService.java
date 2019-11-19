package com.naver.s4.service;

import java.lang.reflect.Member;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.naver.s4.dao.BoardNoticeDAO;
import com.naver.s4.model.BoardVO;
import com.naver.s4.util.FileSaver;
import com.naver.s4.util.Pager;

@Service
public class BoardNoticeService implements BoardService {

	@Inject
/*	@Qualifier("BoardNoticeDAO")*/
	private BoardNoticeDAO boardNoticeDAO;
	
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePager(boardNoticeDAO.boardCount(pager));
		
		return boardNoticeDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		return boardNoticeDAO.boardSelect(boardVO);
	}

	@Override
	public int boardWrite(BoardVO boardVO, HttpSession session) throws Exception {
		
		String realpath = session.getServletContext().getRealPath("resources/upload/notice");
		
		FileSaver fileSaver = new FileSaver();
		String filename = fileSaver.save0(realpath, boardVO.getFile());
		
		boardVO.setFilename(filename);
		boardVO.setOriginalname(boardVO.getFile().getOriginalFilename());
		
		System.out.println(filename);
		System.out.println(boardVO.getFile().getOriginalFilename());
		System.out.println(realpath);
		
		boardNoticeDAO.boardWriteFile(boardVO);
		boardNoticeDAO.boardWrite(boardVO);
		
		return 0; 
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		return boardNoticeDAO.boardUpdate(boardVO);
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		return boardNoticeDAO.boardDelete(boardVO);
	}

}
