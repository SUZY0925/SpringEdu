package com.kh.myapp.rbbs.dao;

import java.util.List;

import com.kh.myapp.rbbs.dto.RbbsDTO;
import com.kh.myapp.util.RecordCriteria;

public interface RbbsDAO {

	// 댓글등록
	void write(RbbsDTO rbbsdto) throws Exception;

	// 댓글 목록
	List<RbbsDTO> list(int bnum, RecordCriteria recordCriteria) throws Exception;
	
	// 댓글목록 전체보기
	List<RbbsDTO> list(int bnum) throws Exception;

	// 글수정하기
	void modify(RbbsDTO rbbsdto) throws Exception;

	//글삭제하기
	void delete(int rnum) throws Exception;

	//원글 가져오기
	RbbsDTO replyView(int rnum) throws Exception;

	// 댓글 등록하기
	void reply(RbbsDTO rbbsdto) throws Exception;

	void updateStep(int rgroup, int rstep) throws Exception;

	void goodOrBad(int rnum, String goodOrBad) throws Exception;

	// 댓글 갯수
	int replyTotalRec(int bnum) throws Exception;

}
