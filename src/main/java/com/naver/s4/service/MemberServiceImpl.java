package com.naver.s4.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.naver.s4.dao.MemberDAOImpl;
import com.naver.s4.model.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAOImpl memberDAOImpl;

	@Override
	public int memberJoin(MemberVO memberVO) throws Exception {
		return memberDAOImpl.memberJoin(memberVO);
	}

	@Override
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		return null;
	}

	@Override
	public int memberUpdate(MemberVO memberVO) throws Exception {
		return 0;
	}

	@Override
	public int memberDelete(MemberVO memberVO) throws Exception {
		return memberDAOImpl.memberDelete(memberVO);
	}

	@Override
	public int memberPointUpdate(MemberVO memberVO) throws Exception {
		return 0;
	}

}
