package com.kh.myapp.login.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.myapp.login.vo.LoginVO;
import com.kh.myapp.member.vo.MemberVO;

@Repository
public class LoginDAOImplJDBC implements LoginDAO {
	
	// Bean으로 등록된 DataSource를 jdbcTemplate가 생성자참조?하기위해서 사용하는 방법~
	/*private JdbcTemplate jdbcTemplate;
	@Autowired
	public void setDataSource(DataSource dataSource) {	
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}*/
	
	
	// Bean으로 등록된 JdbcTemplate를 바로 Autowried해서 사용하는 방법~
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public MemberVO getMember(LoginVO loginVO) {
		// 인자를 memberVO로 in..받아서,  out으로 나가는건 memVO
		
		StringBuffer sql = new StringBuffer();
		sql.append("select * from member where id=? and passwd=?");
		MemberVO memVO = this.jdbcTemplate.queryForObject(
								sql.toString(), new Object[] {loginVO.getId(), loginVO.getPasswd()},
								new BeanPropertyRowMapper<MemberVO>(MemberVO.class));

		return memVO;
	}

	@Override
	public MemberVO findID(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO findPW(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return null;
	}


}
