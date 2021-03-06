package com.kh.myapp.login.vo;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/*"ID" VARCHAR2(30 BYTE) NOT NULL ENABLE, 
"PASSWD" VARCHAR2(30 BYTE) NOT NULL ENABLE, 
*/
public class LoginVO {
	
	@Pattern(regexp="^[\\w=\\.]+@([\\w-]+\\.)+[\\w-]{2,4}",message="이메일 형식이 아닙니다.")
	private String id;
	
	@Size(min=4,max=30,message="비밀번호는 4-30byte로 입력해주세요.")
	private String passwd;
	
	public LoginVO() {
		
	}
	
	public LoginVO(LoginVO loginVO) {
			this.id= loginVO.getId();
			this.passwd = loginVO.getPasswd();
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

	@Override
	public String toString() {
		return "LoginVO [id=" + id + ", passwd=" + passwd + "]";
	}
	
	
}
