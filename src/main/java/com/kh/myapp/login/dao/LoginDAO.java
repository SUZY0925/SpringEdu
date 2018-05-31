package com.kh.myapp.login.dao;

import com.kh.myapp.login.vo.LoginVO;
import com.kh.myapp.member.vo.MemberVO;

public interface LoginDAO {
	
	// 아이디와 비밀번호로 회원정보 가져오기
	public MemberVO getMember(LoginVO loginVO);
	
}
