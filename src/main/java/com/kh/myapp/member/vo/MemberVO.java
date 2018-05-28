package com.kh.myapp.member.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/*"ID" VARCHAR2(30 BYTE) NOT NULL ENABLE, 
"PASSWD" VARCHAR2(30 BYTE) NOT NULL ENABLE, 
"NAME" VARCHAR2(10 BYTE) NOT NULL ENABLE, 
"BIRTH" CHAR(8 BYTE) NOT NULL ENABLE, 
"PHONE" VARCHAR2(11 BYTE) NOT NULL ENABLE, 
"GENDER" CHAR(1 BYTE) NOT NULL ENABLE, 
"CDATE" DATE DEFAULT sysdate NOT NULL ENABLE, 
"UDATE" DATE DEFAULT sysdate NOT NULL ENABLE, 
 CHECK (GENDER IN ('M', 'W')) ENABLE, */
public class MemberVO {
	
	@Pattern(regexp="^[\\w=\\.]+@([\\w-]+\\.)+[\\w-]{2,4}",message="이메일 형식이 아닙니다.")
	private String id;
	
	@Size(min=4,max=30,message="비밀번호는 4-30byte로 입력해주세요.")
	private String passwd;
	
	@Size(min=4,max=20,message="이름은 4-20byte로 입력해주세요.")
	private String name;	
	
	@NotNull
	private String birth;
	
	@NotNull
	private String phone;
	
	@NotNull
	private String gender;
	private Date cdate;
	private Date udate;
	
	
	public MemberVO() {
		
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public Date getUdate() {
		return udate;
	}
	public void setUdate(Date udate) {
		this.udate = udate;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", passwd=" + passwd + ", name=" + name + ", birth=" + birth + ", phone=" + phone
				+ ", gender=" + gender + ", cdate=" + cdate + ", udate=" + udate + "]";
	}
	
	
}
