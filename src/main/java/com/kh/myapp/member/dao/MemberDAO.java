package com.kh.myapp.member.dao;

import java.util.List;

import com.kh.myapp.member.vo.MemberVO;

public interface MemberDAO {
	// 회원등록
	public void memberInsert(MemberVO memberVO);
	
	// 회원정보 가져오기
	public MemberVO getMember(String id);
	
	// 회원목록 가져오기
	public List<MemberVO> getMemberList();
	
	// 회원정보 수정
	public void memberUpdate(MemberVO memberVO);
	
	// 회원정보 삭제
	public void memberDelete(String id);
	
	public MemberVO findID(MemberVO memberVO);
	public MemberVO findPW(MemberVO memberVO);

}
