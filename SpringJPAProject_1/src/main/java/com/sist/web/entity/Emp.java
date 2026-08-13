package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.*;
import lombok.Getter;
import lombok.Setter;
//EMPNO                                     NOT NULL NUMBER(4)
//ENAME                                              VARCHAR2(10)
//JOB                                                VARCHAR2(9)
//MGR                                                NUMBER(4)
//HIREDATE                                           DATE
//SAL                                                NUMBER(7,2)
//COMM                                               NUMBER(7,2)
//DEPTNO                                             NUMBER(2)
@Entity
@Table(name="EMP")
@Getter@Setter
public class Emp {
	@Id
	private int empno;
	private int sal;
	private Integer mgr;
	private Integer comm;
	private String ename,job;
	private Date hiredate;
	
	@ManyToOne
	@JoinColumn(name="deptno")
	private Dept dept;
}
