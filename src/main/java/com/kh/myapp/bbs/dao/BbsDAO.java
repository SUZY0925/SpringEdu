package com.kh.myapp.bbs.dao;

import java.util.List;

import com.kh.myapp.bbs.dto.BbsDTO;
import com.kh.myapp.util.FindCriteria;
import com.kh.myapp.util.PageCriteria;

public interface BbsDAO {

	// 글쓰기
	void write(BbsDTO bbsdto);

	// 전체 글목록 가져오기
	List<BbsDTO> list();
	
	List<BbsDTO> list(PageCriteria pageCriteria);

	int getListCount();
	
	// 글내용 가져오기
	BbsDTO view(Integer bNum);

	// 글수정하기
	void modify(BbsDTO bbsdto);

	//글삭제하기
	void delete(Integer bNum);

	// 다음글 이전글 이동
	BbsDTO pageNav(Integer bNum, Integer np);

	//원글 가져오기
	BbsDTO replyView(Integer bNum);

	// 답글 등록하기
	void reply(BbsDTO bbsdto);

	void updateStep(Integer bgroup, Integer bstep);

	// 검색한 글목록가져오기
	List<BbsDTO> searchList(FindCriteria findCriteria);

	// 검색한 글 전체 수 가져오기
	int getSearchListCount(FindCriteria findCriteria);

}