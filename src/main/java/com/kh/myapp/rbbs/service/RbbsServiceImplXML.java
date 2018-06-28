package com.kh.myapp.rbbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kh.myapp.rbbs.dao.RbbsDAO;
import com.kh.myapp.rbbs.dto.RbbsDTO;
import com.kh.myapp.util.RecordCriteria;

@Service
public class RbbsServiceImplXML implements RbbsService {

	@Autowired
	@Qualifier("rbbsDAOImplXML")
	RbbsDAO rbbsdao;

	@Override
	public void write(RbbsDTO rbbsdto) throws Exception {
		rbbsdao.write(rbbsdto);
	}

	@Override
	public List<RbbsDTO> list(int bnum, RecordCriteria recordCriteria) throws Exception {
		return rbbsdao.list(bnum, recordCriteria);
	}

	@Override
	public List<RbbsDTO> list(int bnum) throws Exception {
		return rbbsdao.list(bnum);
	}

	@Override
	public void modify(RbbsDTO rbbsdto) throws Exception {
		rbbsdao.modify(rbbsdto);
	}

	@Override
	public void delete(int rnum) throws Exception {
		rbbsdao.delete(rnum);
	}

	@Override
	public RbbsDTO replyView(int rnum) throws Exception {
		return rbbsdao.replyView(rnum);
	}

	@Override
	public void reply(RbbsDTO rbbsdto) throws Exception {
		rbbsdao.reply(rbbsdto);
	}

	@Override
	public void updateStep(int rgroup, int rstep) throws Exception {
		rbbsdao.updateStep(rgroup, rstep);
	}

	@Override
	public void goodOrBad(int rnum, String goodOrBad) throws Exception {
		rbbsdao.goodOrBad(rnum, goodOrBad);
	}

	@Override
	public int replyTotalRec(int bnum) throws Exception {
		return rbbsdao.replyTotalRec(bnum);
	}

}
