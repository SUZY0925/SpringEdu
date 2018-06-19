package com.kh.myapp.rbbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.kh.myapp.rbbs.dao.RbbsDAO;
import com.kh.myapp.rbbs.dto.RbbsDTO;
import com.kh.myapp.util.RecordCriteria;

@Repository
public class RbbsServiceImplXML implements RbbsService {

	@Autowired
	@Qualifier("rbbsDAOImplXML")
	RbbsDAO rbbsdao;
	
	@Override
	public void write(RbbsDTO rbbsdto) throws Exception{
		rbbsdao.write(rbbsdto);
	}

	@Override
	public List<RbbsDTO> list(int bnum, RecordCriteria recordCriteria) throws Exception{
		return rbbsdao.list(bnum, recordCriteria);
	}

	@Override
	public List<RbbsDTO> list(int bnum) throws Exception{
		return rbbsdao.list(bnum);
	}

	@Override
	public void modify(RbbsDTO rbbsdto) throws Exception{
		rbbsdao.modify(rbbsdto);
	}

	@Override
	public void delete(String rnum) throws Exception{
		rbbsdao.delete(rnum);
	}

	@Override
	public RbbsDTO replyView(int bnum) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reply(RbbsDTO rbbsdto) throws Exception{
		rbbsdao.reply(rbbsdto);
	}

	@Override
	public void updateStep(int bgroup, int bstep) throws Exception{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void goodOrBad(String rnum, String goodOrBad) throws Exception{
		// TODO Auto-generated method stub
		
	}

	@Override
	public int replyTotalRec(int bnum) throws Exception{
		return rbbsdao.replyTotalRec(bnum);
	}

	@Override
	public String replyWriterFind(int bnum, int rgroup, int rindent) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}

}
