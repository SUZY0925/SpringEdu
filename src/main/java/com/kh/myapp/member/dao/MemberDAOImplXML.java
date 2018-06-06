package com.kh.myapp.member.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.myapp.member.vo.MemberVO;

// mybatis를 이용해서 구현한거
@Repository
public class MemberDAOImplXML implements MemberDAO { // mybatis를 사용해서 구현하는거..인터페이스는 똑같음! mybatis는 sql만 따로 빼서..쓰는거?

	@Autowired
	private SqlSession sqlSession; // 이미 컨테이너에 올라와있는거 주입받는거임..(?)

	@Override
	public void memberInsert(MemberVO memberVO) {
		sqlSession.insert("memberInsert",memberVO);
	}

	@Override
	public MemberVO getMember(String id) {
		return sqlSession.selectOne("getByMemberId",id);
	}

	@Override
	public List<MemberVO> getMemberList() {
		return sqlSession.selectList("getMemberList");
	}

	@Override
	public void memberUpdate(MemberVO memberVO) {
		sqlSession.update("memberUpdate",memberVO);
		
	}

	@Override
	public void memberDelete(String id) {
		sqlSession.delete("memberDelete",id);
	}
	
	@Override
	public MemberVO findID(MemberVO memberVO) {
		return sqlSession.selectOne("findID",memberVO);
//		return sqlSession.getMapper(MemberDAO.class).findId(name, phone); // String 인자로 들어올 경우 사용
//		MemberService에서 파라미터가 @param 붙여져서 들어옴
//		mapper.xml에서 parameterType 없어도됨? 없어야함?		
	}

	@Override
	public MemberVO findPW(MemberVO memberVO) {
		return sqlSession.selectOne("findPW",memberVO);
	}

}
