package com.rubypaper.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter	
@Setter
@ToString
@Entity
public class Board {
	@Id
	@GeneratedValue
	private Long seq;

	private String title;

	@Column(updatable = false)
	private String writer;

	private String content;
	
	// DATE DEFAULT SYSDATE 에러남.. CURRENT_DATE 로 변경
	//@Column(insertable = false, updatable = false, columnDefinition = "DATE DEFAULT SYSDATE")
	@Column(insertable = false, updatable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private Date createDate;

	// @Column(insertable = false, updatable = false, columnDefinition = "number default 0")
	@Column(insertable = false, updatable = false)
	private Long cnt;
}
