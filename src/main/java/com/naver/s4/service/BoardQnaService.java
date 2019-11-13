package com.naver.s4.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.naver.s4.dao.BoardQnaDAO;
import com.naver.s4.model.BoardVO;
import com.naver.s4.util.Pager;

@Service
public class BoardQnaService implements BoardService {
	
	@Inject
	private BoardQnaDAO boardQnaDAO;

	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePager(boardQnaDAO.boardCount(pager));
		
		return boardQnaDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {

		return null;
	}

	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {

		return 0;
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {

		return 0;
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {

		return 0;
	}
	
	

}
