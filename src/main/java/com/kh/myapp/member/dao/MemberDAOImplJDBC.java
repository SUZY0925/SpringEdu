package com.kh.myapp.member.dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.myapp.member.vo.MemberVO;

@Repository("memberDAO")	// Repository : 자동으로 컨테이너에 올라감.
public class MemberDAOImplJDBC implements MemberDAO{
	
	private JdbcTemplate jdbcTemplate; // 스프링에서 제공되는 jdbc
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 회원등록
	@Override
	public void insert(MemberVO memberVO) {

		StringBuffer sql = new StringBuffer();
		
		sql.append("insert into member(id, passwd, name, birth, phone, gender) ");
		sql.append("values(?,?,?,?,?,?)");

		this.jdbcTemplate.update(sql.toString(),memberVO.getId(), memberVO.getPasswd(), memberVO.getName()
				,memberVO.getBirth(), memberVO.getPhone(), memberVO.getGender() );
	}

	// 회원정보 가져오기
	@Override
	public MemberVO getMember(String id) {
		
		StringBuffer sql = new StringBuffer();
		MemberVO memberVO = new MemberVO();
		
		sql.append("select * from member where id=?");
		
		memberVO= (MemberVO) this.jdbcTemplate.queryForObject(sql.toString(), new Object[] {id},new BeanPropertyRowMapper<MemberVO>(MemberVO.class));
		
		return memberVO;
	}

	// 회원목록 가져오기
	@Override
	public ArrayList<MemberVO> getMemberList() {
		
		ArrayList<MemberVO> list = new ArrayList<>();
		
		StringBuffer sql = new StringBuffer();
		sql.append("select * from member");
		
		list = (ArrayList<MemberVO>) this.jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<MemberVO>(MemberVO.class));
		
		return list;
	}

	// 회원정보 수정
	@Override
	public void update(MemberVO memberVO) {
		
		StringBuffer sql = new StringBuffer();
		sql.append("update member set ");
		sql.append("passwd = ? , name = ?, birth = ?, phone = ?, gender = ? ");
		sql.append("where id = ?");
		
		this.jdbcTemplate.update(sql.toString(), memberVO.getPasswd(), memberVO.getName(),
				memberVO.getBirth(), memberVO.getPhone(), memberVO.getGender(), memberVO.getId());
	}

	// 회원정보 삭제
	@Override
	public void delete(String id) {
		this.jdbcTemplate.update("delete from member where id = ?", id);
	}

}
