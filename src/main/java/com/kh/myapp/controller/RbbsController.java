package com.kh.myapp.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.myapp.rbbs.dto.RbbsDTO;
import com.kh.myapp.rbbs.service.RbbsService;
import com.kh.myapp.util.PageCriteria;
import com.kh.myapp.util.RecordCriteria;

@RestController
@RequestMapping("/rbbs")
public class RbbsController {
	
		private static final Logger logger = LoggerFactory.getLogger(RbbsController.class);
	
	@Autowired
	@Qualifier("rbbsServiceImplXML")
	RbbsService rs;
	
	@RequestMapping(value="/write", method=POST)
	public ResponseEntity<String> write(@RequestBody RbbsDTO rbbsdto) { // @RequestBody http의 body에 해당하는 부분에 있는 name을 RbbsDTO와 binding시키는..
		ResponseEntity<String> responseEntity = null;
		logger.info("댓글내용 : " + rbbsdto.toString());
		
		try {
			rs.write(rbbsdto);
			responseEntity = new ResponseEntity<String>("Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>("Fail", HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	@RequestMapping(value="/list/{bnum}/{reReqPage}",method=GET)
	public ResponseEntity<List<RbbsDTO>> list(@PathVariable int bnum,@PathVariable int reReqPage) {
		ResponseEntity<List<RbbsDTO>> responseEntity = null;
		RecordCriteria recordCriteria = new RecordCriteria(reReqPage);
		
		try {
			responseEntity = new ResponseEntity<>(rs.list(bnum, recordCriteria), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	/*
	@RequestMapping(value="/map/{bnum}/{reReqPage}",method=GET)
	public Map<String, Object> map(@PathVariable int bnum,@PathVariable int reReqPage) {
		
		RecordCriteria recordCriteria = new RecordCriteria(reReqPage);
		List<RbbsDTO> list = null;
		Map<String,Object> map = new HashMap<>();
		
		try {
			list = rs.list(bnum, recordCriteria);
			
			map.put("result", Boolean.TRUE);
			map.put("data", list);
			} catch (Exception e) {
				map.put("result", Boolean.FALSE);
		}
		return map;
	}
	
	// list, map, map2중에서 map2를 가장 추천..^^ ResponseEntity사용하니까..
	@RequestMapping(value="/map2/{bnum}/{reReqPage}",method=GET)
	public ResponseEntity<Map<String,Object>> map2(@PathVariable int bnum,@PathVariable int reReqPage) {
		
		ResponseEntity<Map<String,Object>> responseEntity = null;
		RecordCriteria recordCriteria = new RecordCriteria(reReqPage);
		Map<String,Object> map = new HashMap<>();
		
		try {
			map.put("item", rs.list(bnum,recordCriteria));
			responseEntity = new ResponseEntity<>(map,HttpStatus.OK);
			} catch (Exception e) {
			responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}*/
	
	@RequestMapping(value="/map/{bnum}/{reReqPage}",method=GET)
	public ResponseEntity<Map<String,Object>> map2(@PathVariable int bnum,@PathVariable int reReqPage) throws Exception {
		
		ResponseEntity<Map<String,Object>> responseEntity = null;
		RecordCriteria recordCriteria = new RecordCriteria(reReqPage, 10);
		Map<String,Object> map = new HashMap<>();
		try {
			// 페이지 처리 
			PageCriteria pageCriteria = new PageCriteria(recordCriteria, rs.replyTotalRec(bnum), 10);
			//rs.replyWriterFind(bnum, rgroup, rindent); 전 댓글 작성자..찾기;
			map.put("rec", rs.list(bnum,recordCriteria));
			
			map.put("pageCriteria", pageCriteria);
			
			responseEntity = new ResponseEntity<>(map,HttpStatus.OK);
			} catch (Exception e) {
			responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@RequestMapping(value="/modify", method = PUT)
	public ResponseEntity<String> modify(@RequestBody RbbsDTO rbbsdto) {
		ResponseEntity<String> responseEntity = null;
		
		try {
			rs.modify(rbbsdto);
			responseEntity = new ResponseEntity<String>("Success",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>("Fail",HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	

	@RequestMapping(value="/delete/{rnum}",method = DELETE)
	public ResponseEntity<String> delete(@PathVariable int rnum) {
		ResponseEntity<String> responseEntity = null;
	
		try {
			rs.delete(rnum);
			responseEntity = new ResponseEntity<String>("Success",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>("Fail",HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
	@RequestMapping(value="/good/{rnum}",method=PUT)
	public ResponseEntity<String> good(@PathVariable int rnum) {
		ResponseEntity<String> responseEntity = null;
		try {
			rs.goodOrBad(rnum,"good");
			responseEntity = new ResponseEntity<String>("Success",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>("Fail",HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	
	@RequestMapping(value="/bad/{rnum}",method=PUT)
	public ResponseEntity<String> bad(@PathVariable int rnum) {
		ResponseEntity<String> responseEntity = null;
		
		try {
			rs.goodOrBad(rnum,"bad");
			responseEntity = new ResponseEntity<String>("Success",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>("Fail",HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	
	@RequestMapping(value="/reply",method=POST)
	public ResponseEntity<String> reply(@RequestBody RbbsDTO rbbsdto) { // @RequestBody http의 body에 해당하는 부분에 있는 name을 RbbsDTO와 binding시키는..
		ResponseEntity<String> responseEntity = null;
		logger.info("대댓글내용 : " + rbbsdto.toString());
		
		try {
			rs.reply(rbbsdto);
			responseEntity = new ResponseEntity<String>("Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>("Fail", HttpStatus.BAD_REQUEST);
		}
		
		return responseEntity;
	}
	
}
