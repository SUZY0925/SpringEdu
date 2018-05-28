package com.kh.myapp.member.dao;

import java.util.ArrayList;

import com.kh.myapp.member.service.MemberService;
import com.kh.myapp.member.vo.MemberVO;

public class MemberMapperDAO implements MemberService{	// mybatis를 사용해서 구현하는거..인터페이스는 똑같음! mybatis는 sql만 따로 빼서..쓰는거?

	@Override
	public void memberInsert(MemberVO memberVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberVO getByMemberId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MemberVO> getMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void memberUpdate(MemberVO memberVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void memberDelete(String id) {
		// TODO Auto-generated method stub
		
	}

}
