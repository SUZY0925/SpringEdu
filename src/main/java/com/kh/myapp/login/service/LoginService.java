package com.kh.myapp.login.service;

import com.kh.myapp.login.vo.LoginVO;
import com.kh.myapp.member.vo.MemberVO;

public interface LoginService {
	
	public MemberVO getMember(LoginVO loginVO) ;
	
	public MemberVO findID(MemberVO memberVO);
	
	public MemberVO findPW(MemberVO memberVO);
}
