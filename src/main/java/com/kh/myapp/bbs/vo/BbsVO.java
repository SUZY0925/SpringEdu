package com.kh.myapp.bbs.vo;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@Slf4j	// 로그 멤버변수 생성 log
public class BbsVO {
	private int bNum;			// 게시글번호
	private String bTitle;	// 제목
	private String bId;		// 작성자ID
	private String bName;	// 작성자이름
	private Date bCdate;		// 작성일시
	private Date bUdate;		// 수정일시
	private int bHit;			// 조회수
	private String bContent;// 글내용
	private int bGroup;		// 답글그룹
	private int bStep;	// 답변글의 단계
	private int bIndent;	// 답변글 들여쓰기
	
}
