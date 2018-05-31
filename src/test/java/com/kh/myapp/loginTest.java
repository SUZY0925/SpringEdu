package com.kh.myapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.myapp.login.service.LoginService;
import com.kh.myapp.login.vo.LoginVO;
import com.kh.myapp.member.vo.MemberVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
class loginTest {
	
	@Autowired
	@Qualifier("loginServiceImplXML")
	LoginService loginService;
	
	private static final Logger logger = LoggerFactory.getLogger(loginTest.class);
	
	@Test
	void test() {
		LoginVO loginVO = new LoginVO();
		loginVO.setId("suzy@kh.com");
		loginVO.setPasswd("1234");
		
		MemberVO memVO = loginService.getMember(loginVO);
		
		logger.info(memVO.toString());
	}
	
	/*// 빈 등록정보 확인하기
	@Autowired
	DefaultListableBeanFactory df;
	@Test
	public void beans() {
		for(String name : df.getBeanDefinitionNames()) {
			logger.info(name + "\t :: " + df.getBean(name).getClass().getName());
		}
	}*/

}
