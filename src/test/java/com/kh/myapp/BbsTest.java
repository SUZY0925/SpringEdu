package com.kh.myapp;

import java.util.List;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.myapp.bbs.dao.BbsDAO;
import com.kh.myapp.bbs.dto.BbsDTO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })	
class BbsTest {
	
	private Logger logger = LoggerFactory.getLogger(BbsTest.class);
	
	@Autowired
	@Qualifier("bbsDAOImplXML")
	BbsDAO bbsdao;
	
	/*@Test
	void insert_test() {
		BbsDTO bbsdto = new BbsDTO();
		bbsdto.setBtitle("제목테스트4..");
		bbsdto.setBname("이름4..");
		bbsdto.setBcontent("내용4..");
		bbsdto.setBhit(0);
		bbsdao.write(bbsdto);
	}
	
	@Ignore
	@Test
	void list_test() {
		List<BbsDTO> list;
		
		list = bbsdao.list();
		logger.info("size "+list.size());
	}
	
	
	@Test
	void view_test() {
		BbsDTO bbsdto = new BbsDTO();
		bbsdto = bbsdao.view(1);
		logger.info(bbsdto.toString());
	}
	*/
	
	/*
	@Test
	void modify_test() {
		BbsDTO bbsdto = new BbsDTO();
		bbsdto.setBtitle("수정제목");
		bbsdto.setBnum(948);
		bbsdto.setBcontent("수정내용");
		bbsdao.modify(bbsdto);
		
		bbsdto = bbsdao.view(948);
		logger.info(bbsdto.toString());
	}
	
	@Test
	void delete_test() {
		bbsdao.delete(949);
	}
	*/
	
/*	@Test
	void reply_test() {
		BbsDTO bbsdto = new BbsDTO();
		bbsdto.setBtitle("답변제목");
		bbsdto.setBname("답변이름");
		bbsdto.setBcontent("답변내용");
		bbsdto.setBhit(0);
		bbsdto.setBgroup(948);
		bbsdto.setBstep(1);
		bbsdto.setBindent(1);
		bbsdao.reply(bbsdto);
	}*/
	
	@Test
	void replyView_test() {
		logger.info(bbsdao.replyView(950).toString());
	}

}
