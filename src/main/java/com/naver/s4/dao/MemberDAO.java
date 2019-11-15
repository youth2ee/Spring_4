package com.naver.s4.dao;

import com.naver.s4.model.MemberVO;

public interface MemberDAO {

	//memberJoin
	public int memberJoin(MemberVO memberVO) throws Exception;
	
	//memberLogin
	public MemberVO memberLogin(MemberVO memberVO) throws Exception;
	
	//update : 회원정보 업데이트
	public int memberUpdate(MemberVO memberVO) throws Exception;
	
	//delete
	public int memberDelete(MemberVO memberVO) throws Exception;

	//pointUpdate : 포인트 업데이트
	public int memberPointUpdate(MemberVO memberVO) throws Exception;
	
	//id체크
	public MemberVO memberIdCheck(MemberVO memberVO) throws Exception;
}
