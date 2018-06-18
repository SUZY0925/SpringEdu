package com.kh.myapp.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kh.myapp.bbs.dao.BbsDAO;
import com.kh.myapp.bbs.dto.BbsDTO;
import com.kh.myapp.util.FindCriteria;
import com.kh.myapp.util.PageCriteria;
import com.kh.myapp.util.RecordCriteria;

@Service
public class BbsServiceImplXML implements BbsService {

	@Autowired
	@Qualifier("bbsDAOImplXML")
	private BbsDAO bbsdao;
	
	@Override
	public void write(BbsDTO bbsdto) throws Exception {
		bbsdao.write(bbsdto);
	}

	@Override
	public List<BbsDTO> list() throws Exception {
		return bbsdao.list();
	}

	@Override
	public List<BbsDTO> list(RecordCriteria recordCriteria) throws Exception {
		return bbsdao.list(recordCriteria);
	}

	@Override
	public int getListCount() throws Exception {
		return bbsdao.getListCount();
	}

	@Override
	public BbsDTO view(Integer bNum) throws Exception {
		bbsdao.updateHit(bNum);
		return bbsdao.view(bNum);
	}

	@Override
	public void modify(BbsDTO bbsdto) throws Exception {
		bbsdao.modify(bbsdto);
	}

	@Override
	public void delete(Integer bNum) throws Exception {
		bbsdao.delete(bNum);
	}

	@Override
	public BbsDTO pageNav(Integer bNum, Integer np) throws Exception {
		return bbsdao.pageNav(bNum, np);
	}

	@Override
	public BbsDTO replyView(Integer bNum) throws Exception {
		return bbsdao.replyView(bNum);
	}

	@Override
	public void reply(BbsDTO bbsdto) throws Exception {
		bbsdao.reply(bbsdto);
	}

	@Override
	public void updateStep(BbsDTO bbsdto) throws Exception {
		bbsdao.updateStep(bbsdto);
	}

	@Override
	public List<BbsDTO> searchList(FindCriteria findCriteria) throws Exception {
		return bbsdao.searchList(findCriteria);
	}

	@Override
	public int getSearchListCount(FindCriteria findCriteria) throws Exception {
		return bbsdao.getSearchListCount(findCriteria);
	}

	@Override
	public void updateHit(Integer bnum) throws Exception {
		bbsdao.updateHit(bnum);
	}

}
