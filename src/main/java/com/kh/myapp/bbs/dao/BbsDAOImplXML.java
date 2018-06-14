package com.kh.myapp.bbs.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.myapp.bbs.dto.BbsDTO;
import com.kh.myapp.util.FindCriteria;
import com.kh.myapp.util.PageCriteria;

@Repository
public class BbsDAOImplXML implements BbsDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void write(BbsDTO bbsdto) {
		sqlSession.insert("insert", bbsdto);
	}

	@Override
	public List<BbsDTO> list() {
		return sqlSession.selectList("list");
	}
	
	@Override
	public List<BbsDTO> list(PageCriteria pageCriteria) {
		return sqlSession.selectList("listPageCri",pageCriteria);
	}

	@Override
	public int getListCount() {
		return sqlSession.selectOne("totalRec");
	}

	@Override
	public BbsDTO view(Integer bNum) {
		return sqlSession.selectOne("view",bNum);
	}

	@Override
	public void modify(BbsDTO bbsdto) {
		sqlSession.update("modify",bbsdto);
	}

	@Override
	public void delete(Integer bNum) {
		sqlSession.delete("delete",bNum);
	}

	@Override
	public BbsDTO pageNav(Integer bNum, Integer np) {
		return null;
	}

	@Override
	public BbsDTO replyView(Integer bNum) {
		return sqlSession.selectOne("replyView", bNum);
	}

	@Override
	public void reply(BbsDTO bbsdto) {
		sqlSession.insert("reply",bbsdto);
	}

	@Override
	public void updateStep(Integer bgroup, Integer bstep) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BbsDTO> searchList(FindCriteria findCriteria) {
		return sqlSession.selectList("listFindCri",findCriteria);
	}

	@Override
	public int getSearchListCount(FindCriteria findCriteria) {
		return sqlSession.selectOne("searchTotalRec",findCriteria);
	}

	

}
