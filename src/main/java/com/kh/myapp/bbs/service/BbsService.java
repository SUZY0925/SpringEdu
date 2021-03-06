package com.kh.myapp.bbs.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kh.myapp.bbs.dto.BbsDTO;
import com.kh.myapp.util.FindCriteria;
import com.kh.myapp.util.RecordCriteria;

public interface BbsService {

	// 글쓰기
	void write(BbsDTO bbsdto) throws Exception;

	// 전체 글목록 가져오기
	List<BbsDTO> list() throws Exception;
	
	// 페이징된 글 목록 가져오기
	List<BbsDTO> list(RecordCriteria recordCriteria) throws Exception;

	// 페이징된 글 목록 수 가져오기
	int getListCount() throws Exception;
	
	// 검색한 글목록가져오기
	List<BbsDTO> searchList(FindCriteria findCriteria) throws Exception;

	// 검색한 글 전체 수 가져오기
	int getSearchListCount(FindCriteria findCriteria) throws Exception;
	
	// Controller에서 했던 일을 Service에서 해주기 위해 분기....용 list.. request받아오기위한..
	void list(HttpServletRequest request) throws Exception;
	
	// 글내용 가져오기
	BbsDTO view(Integer bNum) throws Exception;

	// 글수정하기
	void modify(BbsDTO bbsdto) throws Exception;

	//글삭제하기
	void delete(Integer bNum) throws Exception;

	// 다음글 이전글 이동
	void pageNav(Integer bNum, Integer np) throws Exception;

	//원글 가져오기
	BbsDTO replyView(Integer bNum) throws Exception;

	// 답글 등록하기
	void reply(BbsDTO bbsdto) throws Exception;

	void updateStep(BbsDTO bbsdto) throws Exception;

	void updateHit(Integer bnum) throws Exception;
}
