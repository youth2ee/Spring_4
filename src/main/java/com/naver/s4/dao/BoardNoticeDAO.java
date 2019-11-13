package com.naver.s4.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.naver.s4.model.BoardVO;
import com.naver.s4.util.Pager;

@Repository
public class BoardNoticeDAO implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;
	public final static String NAMESPACE = "noticeMapper.";
	
	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"boardList", pager);
	}

	@Override
	public int boardCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"boardCount", pager) ;
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
