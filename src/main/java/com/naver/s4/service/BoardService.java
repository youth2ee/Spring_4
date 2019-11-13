package com.naver.s4.service;

import java.util.List;

import com.naver.s4.model.BoardVO;
import com.naver.s4.util.Pager;

public interface BoardService {

	//list
	public List<BoardVO> boardList(Pager pager) throws Exception;
	
	//select
	public BoardVO boardSelect(BoardVO boardVO) throws Exception;
	
	//write
	public int boardWrite(BoardVO boardVO) throws Exception;
	
	//update
	public int boardUpdate(BoardVO boardVO) throws Exception;
	
	//delete
	public int boardDelete(BoardVO boardVO) throws Exception;
	
}
