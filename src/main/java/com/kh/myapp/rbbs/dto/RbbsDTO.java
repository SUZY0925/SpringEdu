package com.kh.myapp.rbbs.dto;

import java.util.Date;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class RbbsDTO {
	private int rnum, bnum, rgood, rbad, rgroup, rstep, rindent;
	private String rid, rname, rcontent;
	private Date rcdate, rudate;
}
