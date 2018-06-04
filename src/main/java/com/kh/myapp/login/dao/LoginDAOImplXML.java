package com.kh.myapp.login.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.myapp.login.vo.LoginVO;
import com.kh.myapp.member.vo.MemberVO;

@Repository
public class LoginDAOImplXML implements LoginDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public MemberVO getMember(LoginVO loginVO) {
		return sqlSession.selectOne("getMemberLogin",loginVO);
	}

	@Override
	public MemberVO findID(MemberVO memberVO) {
		Map<String,Object> parameters = new HashMap<String,Object>();
		parameters.put("name", memberVO.getName());
		parameters.put("phone", memberVO.getPhone());
		return sqlSession.selectOne("findID",parameters);
	}

	@Override
	public MemberVO findPW(MemberVO memberVO) {
		Map<String,Object> parameters = new HashMap<String,Object>();
		parameters.put("id", memberVO.getId());
		parameters.put("birth", memberVO.getBirth());
		return sqlSession.selectOne("findPW",parameters);
	}
	
	
}
