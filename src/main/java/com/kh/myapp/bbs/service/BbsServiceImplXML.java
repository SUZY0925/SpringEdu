package com.kh.myapp.bbs.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	public List<BbsDTO> searchList(FindCriteria findCriteria) throws Exception {
		return bbsdao.searchList(findCriteria);
	}

	@Override
	public int getSearchListCount(FindCriteria findCriteria) throws Exception {
		return bbsdao.getSearchListCount(findCriteria);
	}

	@Override
	public void list(HttpServletRequest request) throws Exception {
		int reqPage = 0;
		if (request.getParameter("reqPage") == null || request.getParameter("reqPage") == "") {
			reqPage = 1;
		} else {
			reqPage = Integer.parseInt(request.getParameter("reqPage"));
		}
		
		String option = request.getParameter("option");
		String search = request.getParameter("search");
		
		List<BbsDTO> list = null;
		PageCriteria pc = null;
		RecordCriteria rc = null;
				
		// 검색조건이 없는 경우
				if(option == null || search.trim().equals("")) {
					rc = new RecordCriteria(reqPage);
					list = list(rc);
					int totalRec = getListCount();
					pc = new PageCriteria(rc,totalRec);
					
		// 검색조건이 있는 경우			
				} else {
					rc = new FindCriteria(reqPage,option,search);
					list = searchList((FindCriteria)rc);
					int totalRec = getSearchListCount((FindCriteria)rc);
					pc = new PageCriteria(rc, totalRec);
					
					request.setAttribute("findCriteria", (FindCriteria)rc);
				}
				
				request.setAttribute("list", list);
				request.setAttribute("page", pc);
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
	public void pageNav(Integer bNum, Integer np) throws Exception {
		bbsdao.pageNav(bNum, np);
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
	public void updateHit(Integer bnum) throws Exception {
		bbsdao.updateHit(bnum);
	}


}
