package com.kh.myapp.member.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.kh.myapp.member.dao.MemberDAO;
import com.kh.myapp.member.vo.MemberVO;

@Service
public class MemberServiceImplXML implements MemberService {

	@Autowired 
	@Qualifier("memberDAOImplXML")
	MemberDAO memberDAO;	
	
	@Override
	public void memberInsert(MemberVO memberVO) {
		memberDAO.memberInsert(memberVO);
	}

	@Override
	public MemberVO getByMemberId(String id) {
		return memberDAO.getMember(id);
	}

	@Override
	public List<MemberVO> getMemberList() {
		return memberDAO.getMemberList();
	}

	@Override
	public void memberUpdate(MemberVO memberVO) {
		memberDAO.memberUpdate(memberVO);
	}

	@Override
	public void memberDelete(String id) {
		memberDAO.memberDelete(id);
	}

	@Override
	public MemberVO findID(MemberVO memberVO) {
		return memberDAO.findID(memberVO);
	}

	@Override
	public MemberVO findPW(MemberVO memberVO) {
		return memberDAO.findPW(memberVO);
	}

}
