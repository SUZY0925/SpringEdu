package com.kh.myapp;

import java.util.List;

import org.junit.jupiter.api.Disabled;
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
import com.kh.myapp.util.FindCriteria;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })	
class BbsTest {
	
	private Logger logger = LoggerFactory.getLogger(BbsTest.class);
	
	@Autowired
	@Qualifier("bbsDAOImplXML")
	BbsDAO bbsdao;
	
	
	@Test
	@Disabled
	void insert_test() throws Exception {
		BbsDTO bbsdto = new BbsDTO();
		bbsdto.setBtitle("제목테스트4..");
		bbsdto.setBname("이름4..");
		bbsdto.setBcontent("내용4..");
		bbsdto.setBhit(0);
		bbsdao.write(bbsdto);
	}
	
	@Test
	@Disabled
	void list_test()  throws Exception {
		List<BbsDTO> list;
		
		list = bbsdao.list();
		logger.info("size "+list.size());
	}
	
	
	@Test
	@Disabled
	void view_test() throws Exception{
		BbsDTO bbsdto = new BbsDTO();
		bbsdto = bbsdao.view(1);
		logger.info(bbsdto.toString());
	}
	
	
	
	@Test
	@Disabled
	void modify_test() throws Exception{
		BbsDTO bbsdto = new BbsDTO();
		bbsdto.setBtitle("수정제목");
		bbsdto.setBnum(948);
		bbsdto.setBcontent("수정내용");
		bbsdao.modify(bbsdto);
		
		bbsdto = bbsdao.view(948);
		logger.info(bbsdto.toString());
	}
	
	@Test
	@Disabled
	void delete_test() throws Exception{
		bbsdao.delete(949);
	}
	
	
	@Test
	@Disabled
	void reply_test() throws Exception{
		BbsDTO bbsdto = new BbsDTO();
		bbsdto.setBtitle("답변제목");
		bbsdto.setBname("답변이름");
		bbsdto.setBcontent("답변내용");
		bbsdto.setBhit(0);
		bbsdto.setBgroup(948);
		bbsdto.setBstep(1);
		bbsdto.setBindent(1);
		bbsdao.reply(bbsdto);
	}
	
	@Test
	@Disabled
	void replyView_test() throws Exception{
		logger.info(bbsdao.replyView(950).toString());
	}
	
	
	@Test
	@Disabled
	void searchList_test() throws Exception{
		FindCriteria findCriteria= new FindCriteria(1,"T","수정");
		List<BbsDTO> lst = bbsdao.searchList(findCriteria);
		
		for (BbsDTO bbsDTO : lst) {
			logger.info(bbsDTO.toString());
		}
	}
	
	@Test
	void getSearchListCount_test() throws Exception{
		FindCriteria findCriteria = new FindCriteria();
		findCriteria.setOption("C");
		findCriteria.setSearch("수정");
		logger.info(bbsdao.getSearchListCount(findCriteria)+"");
	}
}
