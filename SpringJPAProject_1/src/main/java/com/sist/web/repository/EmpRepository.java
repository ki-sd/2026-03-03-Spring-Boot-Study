package com.sist.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import com.sist.web.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {
	public Emp findByEmpno(int empno);
	public List<Emp> findByEname(String ename);
	// LIKE
	public List<Emp> findByEnameStartsWith(String ename);
	public List<Emp> findByEnameEndsWith(String ename);
	public List<Emp> findByEnameContains(String ename);
	// 비교
	public List<Emp> findBySalGreaterThanEqual(int sal);
	public List<Emp> findBySalLessThanEqual(int sal);
	public List<Emp> findBySalBetween(int min,int max);
	public List<Emp> findByJobAndSalGreaterThanEqual(String job,int sal);
	public List<Emp> findByJobOrEname(String job,String ename);
	public List<Emp> findByDeptDname(String dname);
	public List<Emp> findByDeptLoc(String loc);
	public List<Emp> findByDeptDnameContains(String loc);
	// 정렬
	public List<Emp> findByOrderBySalDesc();
	// Top-N
	public List<Emp> findTop3ByOrderBySalDesc();
	// 중복 제거
	public List<Emp> findDistinctByJob(String job);
	// NOT NULL / NULL
	public List<Emp> findByCommIsNull();
	public List<Emp> findByCommIsNotNull();
	// in
	public List<Emp> findByDeptDeptnoIn(List<Integer> deptnos);
	// not
	public List<Emp> findByJobNot(String job);
	
}
