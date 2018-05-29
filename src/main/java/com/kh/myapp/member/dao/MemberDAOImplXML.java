package com.kh.myapp.member.dao;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.kh.myapp.member.service.MemberService;
import com.kh.myapp.member.vo.MemberVO;

// mybatis를 이용해서 구현한거
@Repository
public class MemberDAOImplXML implements MemberDAO { // mybatis를 사용해서 구현하는거..인터페이스는 똑같음! mybatis는 sql만 따로 빼서..쓰는거?

	@Autowired
	private SqlSession sqlSession; // 이미 컨테이너에 올라와있는거 주입받는거임..(?)

	@Override
	public void insert(MemberVO memberVO) {
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
	public void update(MemberVO memberVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

}
