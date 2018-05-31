package com.kh.myapp;


import java.util.List;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.myapp.member.dao.MemberDAO;
import com.kh.myapp.member.vo.MemberVO;

//테스트환경
@RunWith(SpringJUnit4ClassRunner.class) //  Runwith : 환경을 가져가겠다 .여기선 스프링프레임워크에서 테스트하는 환경을 가져가겠다는 말임.
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })	// 이걸로 인해서 스프링프레임워크를 실행을 안해도 테스트 할 수 있음
//-----------
public class JdbcTemplateTest {

	private static Logger Logger = LoggerFactory.getLogger(JdbcTemplateTest.class);

	// 이미 DataSource, memberDAO를 컨테이너에 올려놨기 때문에 그냥 ..쓰면되는거임 인스턴스화 할필요 ㄴㄴ
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	@Qualifier("memberDAOImplJDBC")
	private MemberDAO memberDAO;

	
	@Test @Ignore
	public void test() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("suzy@kh.com");
		memberVO.setPasswd("1234");
		memberVO.setName("관리자");
		memberVO.setBirth("19920925");
		memberVO.setPhone("01012345678");
		memberVO.setGender("W");
		memberDAO.memberInsert(memberVO);
	}
	
	
	// 빈 등록정보 확인하기
	@Autowired
	DefaultListableBeanFactory df;
	@Test
	public void beans() {
		for(String name : df.getBeanDefinitionNames()) {
			Logger.info(name + "\t " + df.getBean(name).getClass().getName());
		}
	}
	
	
	// 회원정보 가져오기
	@Test
	public void getMamber() {
		MemberVO memberVO = memberDAO.getMember("admin@kh.com");
		Logger.info(memberVO.toString());
	}
	
	
	// 회원목록 가져오기
	@Test @Ignore
	public void getMemberList() {
		List<MemberVO> list;
		list = memberDAO.getMemberList();
		
			for(MemberVO memberVO : list) {
				Logger.info(memberVO.toString());
			}
		}
	
	
	// 회원정보수정
	@Test  @Ignore
	public void update() {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("admin@kh.com");
		memberVO.setPasswd("4321");
		memberVO.setName("관리자");
		memberVO.setPhone("01012345678");
		memberVO.setBirth("19920925");
		memberVO.setGender("W");
		memberDAO.memberUpdate(memberVO);
		
		memberVO = memberDAO.getMember("admin@kh.com");
		Logger.info(memberVO.toString());
	}
	
	
	// 회원삭제
	@Test @Ignore
	public void delete() {
		memberDAO.memberDelete("admin2@kh.com");
	}
	

}
