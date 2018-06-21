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

import com.kh.myapp.rbbs.dao.RbbsDAO;
import com.kh.myapp.rbbs.dto.RbbsDTO;
import com.kh.myapp.rbbs.service.RbbsService;
import com.kh.myapp.util.RecordCriteria;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })	
class rbbsTest {

	private Logger logger = LoggerFactory.getLogger(rbbsTest.class);
	
	@Autowired
	@Qualifier("rbbsDAOImplXML")
	RbbsDAO rbbsdao;
	
	@Test
	@Disabled
	void listAll_test()  throws Exception {
		List<RbbsDTO> list;
		
		list = rbbsdao.list(1);
		logger.info("size "+list.size());
	}
	
	@Test
	@Disabled
	void write_test() throws Exception {
		RbbsDTO rbbsdto = new RbbsDTO();
		rbbsdto.setBnum(966);
		rbbsdto.setRid("admin@kh.com");
		rbbsdto.setRname("문수지님");
		rbbsdto.setRcontent("댓글테스트0619");
		rbbsdao.write(rbbsdto);
	}
	
	@Test
	@Disabled
	void modify_test() throws Exception {
		RbbsDTO rbbsdto = new RbbsDTO();
		rbbsdto.setRcontent("내용수정0619..");
		rbbsdto.setRnum(1743);
		rbbsdao.modify(rbbsdto);
	}
	
	@Test
	@Disabled
	void reply_test() throws Exception {
		RbbsDTO rbbsdto = new RbbsDTO();
		rbbsdto.setRnum(1743);
		rbbsdto.setRid("suzy@kh.com");
		rbbsdto.setRname("user");
		rbbsdto.setRcontent("나능 대댓 나능 대댓");
		
		rbbsdao.reply(rbbsdto);
	}
	
	
	@Test
	@Disabled
	void goodOrBad_test() throws Exception {
		rbbsdao.goodOrBad(1743, "good");
	}
	
	
   @Test
   @Disabled
   void list() throws Exception {
      RecordCriteria rc = new RecordCriteria(1,10);
      List<RbbsDTO> list = null;
      
      list = rbbsdao.list(1, rc);
      for (RbbsDTO rbbsdto : list) {
			logger.info(rbbsdto.toString());
		}
   }
   
   @Autowired
   @Qualifier("rbbsServiceImplXML")
   RbbsService rbbsService;
   
   @Test
   void totalRecTest() throws Exception {
   	logger.info("댓글개수"+rbbsService.replyTotalRec(966));
   }
	
}
