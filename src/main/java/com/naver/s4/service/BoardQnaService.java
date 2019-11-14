package com.naver.s4.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.naver.s4.dao.BoardQnaDAO;
import com.naver.s4.model.BoardQnaVO;
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
		return boardQnaDAO.boardSelect(boardVO);
	}

	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		return boardQnaDAO.boardWrite(boardVO);
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		return boardQnaDAO.boardUpdate(boardVO);
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		return boardQnaDAO.boardDelete(boardVO) ;
	}
	

	public int boardReply(BoardVO boardVO) throws Exception {
		BoardQnaVO parentVO =  (BoardQnaVO)boardQnaDAO.boardSelect(boardVO);
		int result = boardQnaDAO.boardReplyUpdate(parentVO);
		
		parentVO.setTitle(boardVO.getTitle());
		parentVO.setWriter(boardVO.getWriter());
		parentVO.setContents(boardVO.getContents());
		parentVO.setStep(parentVO.getStep()+1);
		parentVO.setDepth(parentVO.getDepth()+1);
		
		/*
		 * BoardQnaVO boardQnaVO = new BoardQnaVO();
		 * boardQnaVO.setTitle(boardVO.getTitle());
		 * boardQnaVO.setWriter(boardVO.getWriter());
		 * boardQnaVO.setContents(boardVO.getContents());
		 * boardQnaVO.setRef(parentVO.getRef());
		 * boardQnaVO.setStep(parentVO.getStep()+1);
		 * boardQnaVO.setDepth(parentVO.getDepth()+1);
		 */
			
		return boardQnaDAO.boardReply(parentVO);
	}
	

}
