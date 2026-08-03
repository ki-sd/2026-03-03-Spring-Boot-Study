package com.sist.web.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;
//NO                                        NOT NULL NUMBER
//NAME                                      NOT NULL VARCHAR2(51)
//SUBJECT                                   NOT NULL VARCHAR2(2000)
//CONTENT                                   NOT NULL CLOB
//PWD                                       NOT NULL VARCHAR2(10)
//REGDATE                                            DATE
//HIT                                                NUMBER
@Entity // 오라클 column과 매칭
@Table(name="board") // 오라클 table과 매칭
@DynamicUpdate // 필요시 업데이트 설정
@Data
// save(vo) 객체(Entity) === Column 연동
/*
 *  JPA (Java Persistence API)
 *  자바 객체와 DB 데이터를 연결해주는 ORM 표준 기술
 *  ------  -------- 컬럼
 *     |        |
 *     ----------
 *      | 자동 SQL문장 생성
 *      
 *  기존
 *    Java Object
 *        |------------ SQL 직접 생성
 *     오라클 테이블 연결
 *  
 *  JPA
 *    Java Object
 *        |------------ JPA를 이용해 SQL 자동 생성
 *     오라클 테이블 연결
 *     
 *   데이터베이스 테이블
 *   ---------------
 *    id    name age
 *   
 *   => @Entity
 *      public class Member{
 *      	@Id
 *      	private String id ...
 *          private String name;
 *          private int age;
 *      }
 */
public class BoardEntity {
	@Id // 자동증가 컬럼 => 자동으로 SQL문장 제작
	private int no;
	private int hit;
	private String name,subject,content;
	@Column(insertable = true,updatable = false)
	private String pwd;
	@Column(insertable = true,updatable = false)
	private String regdate;
	
	@PrePersist
	public void regdate() {
		this.regdate=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
}
