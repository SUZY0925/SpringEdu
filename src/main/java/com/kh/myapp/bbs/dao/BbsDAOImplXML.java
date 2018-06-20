package com.kh.myapp.bbs.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.myapp.bbs.dto.BbsDTO;
import com.kh.myapp.util.FindCriteria;
import com.kh.myapp.util.PageCriteria;
import com.kh.myapp.util.RecordCriteria;

@Repository
public class BbsDAOImplXML implements BbsDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void write(BbsDTO bbsdto) throws Exception{
		sqlSession.insert("insert", bbsdto);
	}

	@Override
	public List<BbsDTO> list() throws Exception{
		return sqlSession.selectList("list");
	}
	
	@Override
	public List<BbsDTO> list(RecordCriteria recordCriteria) throws Exception{
		return sqlSession.selectList("listRecordCri",recordCriteria);
	}

	@Override
	public int getListCount() throws Exception{
		return sqlSession.selectOne("totalRec");
	}

	@Override
	public BbsDTO view(Integer bNum) throws Exception{
		return sqlSession.selectOne("view",bNum);
	}

	@Override
	public void modify(BbsDTO bbsdto) throws Exception{
		sqlSession.update("modify",bbsdto);
	}

	@Override
	public void delete(Integer bNum) throws Exception{
		sqlSession.delete("delete",bNum);
	}

	@Override
	public void pageNav(Integer bNum, Integer np) throws Exception{
		/*Map<String,Object> map = new HashMap<>();
		map.put("bnum", bNum);
		map.put("np", np);
		
		view(sqlSession.selectOne("pageNav",map));*/
	}

	@Override
	public BbsDTO replyView(Integer bNum) throws Exception{
		return sqlSession.selectOne("replyView", bNum);
	}

	@Override
	public void reply(BbsDTO bbsdto) throws Exception{
		
		updateStep(bbsdto);
		
		bbsdto.setBhit(0);
		bbsdto.setBstep(bbsdto.getBstep()+1);
		bbsdto.setBindent(bbsdto.getBindent()+1);
		
		sqlSession.insert("reply",bbsdto);
	}

	@Override
	public void updateStep(BbsDTO bbsdto) throws Exception{
		sqlSession.update("step", bbsdto);
	}

	@Override
	public List<BbsDTO> searchList(FindCriteria findCriteria) throws Exception{
		return sqlSession.selectList("listFindCri",findCriteria);
	}

	@Override
	public int getSearchListCount(FindCriteria findCriteria) throws Exception{
		return sqlSession.selectOne("searchTotalRec",findCriteria);
	}

	@Override
	public void updateHit(Integer bnum) throws Exception {
		sqlSession.update("hit", bnum);
	}


}
