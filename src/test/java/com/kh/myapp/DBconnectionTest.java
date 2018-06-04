package com.kh.myapp;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//테스트환경
@RunWith(SpringJUnit4ClassRunner.class) //  Runwith : 환경을 가져가겠다 .여기선 스프링프레임워크에서 테스트하는 환경을 가져가겠다는 말임.
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })	// 이걸로 인해서 스프링프레임워크를 실행을 안해도 테스트 할 수 있음
//-----------
public class DBconnectionTest {

	private static Logger Logger = LoggerFactory.getLogger(DBconnectionTest.class);
	
	@Autowired // 등록된 bean을 가져다 쓸때 사용하는 어노테이션
	private DataSource ds;
	
	
	@Test
	// DataSource 접속여부 확인 테스트
	public void testConnection() {
		try {
			Connection conn = ds.getConnection();
			Logger.info("성공");
		} catch (SQLException e) {
			Logger.info("실패");
			e.printStackTrace();
		}
		
	}
	
	@Autowired
	private SqlSessionFactory sqlFactory;
	@Test
	//SqlSessionFactory 접속여부 테스트
	public void testSqlSessionFactory() {
		Logger.info(sqlFactory.toString() + " : sessionFactory 접속성공");
	}
	
	
	
	
	@Test
	public void testSqlSessionTemplate() {
		try(SqlSession session = sqlFactory.openSession()) {
			Logger.info(session.toString() + " : session 가져오기 성공");
		} catch(Exception e) {
			Logger.info("session 가져오기 실패");
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
