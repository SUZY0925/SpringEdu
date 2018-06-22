package com.kh.myapp.rbbs.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.myapp.rbbs.dto.RbbsDTO;
import com.kh.myapp.util.RecordCriteria;

@Repository
public class RbbsDAOImplXML implements RbbsDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public void write(RbbsDTO rbbsdto) throws Exception {
		sqlSession.insert("rbbsInsert",rbbsdto);
	}

	@Override
	public List<RbbsDTO> list(int bnum, RecordCriteria recordCriteria) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("bnum", bnum);
		map.put("recordCriteria", recordCriteria);
		
		return sqlSession.selectList("rbbsList",map);
	}

	@Override
	public void modify(RbbsDTO rbbsdto) throws Exception {
		sqlSession.update("rbbsUpdate", rbbsdto);
	}

	@Override
	public void delete(int rnum) throws Exception {
		sqlSession.delete("rbbsDelete",rnum);
	}

	@Override
	public RbbsDTO replyView(int rnum) throws Exception {
		return sqlSession.selectOne("rbbsReplyView", rnum);
	}

	@Override
	public void reply(RbbsDTO rbbsdto) throws Exception {
		RbbsDTO rbbsOrgDTO = replyView(rbbsdto.getRnum());
		updateStep(rbbsOrgDTO.getRgroup(), rbbsOrgDTO.getRstep());
		rbbsdto.setBnum(rbbsOrgDTO.getBnum());
		rbbsdto.setRgroup(rbbsOrgDTO.getRgroup());
		rbbsdto.setRstep(rbbsOrgDTO.getRstep()+1);
		rbbsdto.setRindent(rbbsOrgDTO.getRindent()+1);
		sqlSession.insert("rbbsReply", rbbsdto);
	}

	@Override
	public void updateStep(int rgroup, int rstep) throws Exception {
		Map<String,Object> map = new HashMap<>();
		map.put("rgroup", rgroup);
		map.put("rstep", rstep);
		sqlSession.update("rbbsUpdateStep",map);
	}

	@Override
	public List<RbbsDTO> list(int bnum) throws Exception {
		return sqlSession.selectList("rbbsAllList",bnum);
	}

	@Override
	public void goodOrBad(int rnum, String goodOrBad) throws Exception {
		Map<String,Object> map = new HashMap<>();
		map.put("rnum",rnum);
		map.put("goodOrBad", goodOrBad);
		sqlSession.update("goodOrBad",map);
	}

	@Override
	public int replyTotalRec(int bnum) throws Exception {
		return sqlSession.selectOne("rbbsTotalRec",bnum);
	}

	@Override
	public String replyWriterFind(int bnum, int rgroup, int rindent) throws Exception {
		Map<String,Object> map = new HashMap<>();
		map.put("bnum", bnum);
		map.put("rgroup", rgroup);
		map.put("rindent", rindent);
		return sqlSession.selectOne("replyWriterFind", map);
	}
	
	
}
