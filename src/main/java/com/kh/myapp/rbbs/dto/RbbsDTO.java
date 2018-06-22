package com.kh.myapp.rbbs.dto;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class RbbsDTO {
	private int rnum, bnum, rgood, rbad, rgroup, rstep, rindent;
	private String rid, rname, rcontent;
	/*@JsonFormat(pattern="yyyy/MM/dd")*/
	private Date rcdate, rudate;
}
