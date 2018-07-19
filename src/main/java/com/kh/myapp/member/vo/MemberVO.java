package com.kh.myapp.member.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

/*"ID" VARCHAR2(30 BYTE) NOT NULL ENABLE, 
"PASSWD" VARCHAR2(30 BYTE) NOT NULL ENABLE, 
"NAME" VARCHAR2(10 BYTE) NOT NULL ENABLE, 
"BIRTH" CHAR(8 BYTE) NOT NULL ENABLE, 
"PHONE" VARCHAR2(11 BYTE) NOT NULL ENABLE, 
"GENDER" CHAR(1 BYTE) NOT NULL ENABLE, 
"CDATE" DATE DEFAULT sysdate NOT NULL ENABLE, 
"UDATE" DATE DEFAULT sysdate NOT NULL ENABLE, 
 CHECK (GENDER IN ('M', 'W')) ENABLE, */
@Data
public class MemberVO {
	
	
	@Pattern(regexp="^[\\w=\\.]+@([\\w-]+\\.)+[\\w-]{2,4}",message="이메일 형식이 아닙니다.")
	private String id;
	
	@Size(min=4,max=30,message="비밀번호는 4-30byte로 입력해주세요.")
	private String passwd;
	
	@Size(min=3,max=20,message="이름은 3-20byte로 입력해주세요.")
	private String name;	
	
	@NotNull
	private String birth;
	
	@NotNull
	private String phone;
	
	@NotNull
	private String gender;
	private Date cdate;
	private Date udate;
	
	private MultipartFile uploadFile; // 첨부파일이 여러개일 경우 배열로 받음
	private String filename;
	
	
	
}
