package com.kh.myapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.myapp.member.service.MemberService;
import com.kh.myapp.member.vo.MemberVO;

//@RunWith(SpringJUnit4ClassRunner.class) junit4버전 사용
@ExtendWith(SpringExtension.class) // junit5버전 사용
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

class MybatisTest {
	private static final Logger logger = LoggerFactory.getLogger(loginTest.class);
	@Autowired
	DefaultListableBeanFactory df;
	@Test
	public void beans() {
		for(String name : df.getBeanDefinitionNames()) {
			logger.info(name + "\t " + df.getBean(name).getClass().getName());
		}
	}
/*	private static final Logger logger = LoggerFactory.getLogger(MybatisTest.class);
	
	@Autowired
	@Qualifier("memberServiceImplXML")
	MemberService memberService;
	
	@Test
	public void test() {
		MemberVO memberVO = memberService.getByMemberId("admin@kh.com");
		logger.info(memberVO.toString());
	}*/
	
}
