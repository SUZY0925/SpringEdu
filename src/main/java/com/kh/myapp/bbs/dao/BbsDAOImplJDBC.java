package com.kh.myapp.bbs.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kh.myapp.bbs.dto.BbsDTO;
import com.kh.myapp.util.FindCriteria;
import com.kh.myapp.util.PageCriteria;

@Repository
public class BbsDAOImplJDBC implements BbsDAO {

	@Override
	public void write(BbsDTO bbsdto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BbsDTO> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BbsDTO> list(PageCriteria pageCriteria) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getListCount() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BbsDTO view(Integer bNum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(BbsDTO bbsdto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer bNum) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BbsDTO pageNav(Integer bNum, Integer np) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BbsDTO replyView(Integer bNum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reply(BbsDTO bbsdto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStep(Integer bgroup, Integer bstep) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BbsDTO> searchList(FindCriteria findCriteria) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSearchListCount(FindCriteria findCriteria) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


}
