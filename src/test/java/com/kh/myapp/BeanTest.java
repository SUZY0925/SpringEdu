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

import com.kh.myapp.login.vo.LoginVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/beanTest.xml")
class BeanTest {

	private Logger logger = LoggerFactory.getLogger(BeanTest.class);
	
	@Autowired
	//@Qualifier("loginVO")
	@Qualifier("conLoginVO")
	LoginVO loginVO;
	
	@Test
	public void test() {
			logger.info(loginVO.toString());
	}
	
	// 빈 등록정보 확인하기
	@Autowired
	DefaultListableBeanFactory df;
	@Test
	public void beans() {
		for(String name : df.getBeanDefinitionNames()) {
			logger.info(name + "\t " + df.getBean(name).getClass().getName());
		}
	}

}
