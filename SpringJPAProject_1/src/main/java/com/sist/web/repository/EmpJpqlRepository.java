package com.sist.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.sist.web.entity.QEmp;

import com.sist.web.entity.Emp;
/*
 *     JPA
 *     1. 메서드 규칙 : 자동으로 SQL문장을 제작 => JPQL
 *        -장점 : SQL문장이 자동 생성 => SQL을 모르는경우에도 사용 가능
 *              메서드명으로 SQL확인 가능 => 가독성 좋음
 *        -단점 : 이름의 한계 => 메서드명이 길어질수 있다
 *               ex) findBySalGreaterThanAndEnameLikeAndJobLikeOrderByHiredateDesc
 *               동적쿼리 사용불가 => MyBatis사용
 *                 사용빈도 => 2:8
 *        -사용처: 단순조회 / 기본값 => findByNo(int no)
 *        
 *     2. JPQL : JPA에서 제공하는 객체중심의 SQL문장
 *        -장점 : 표준기술 => 라이브러리가 필요없음 => 바로 사용 가능
 *               객체지향 : 테이블이 아니고 엔티티 객체 이용
 *        -단점 : 문자열 기반 => 오타가 있는 경우 에러처리 어려움
 *               동적쿼리 사용이 어려움
 *        -사용처: 복잡하지 않은 SQL / 수정 / 삭제시에 주로 사용
 *        
 *     3. QueryDSL
 *        -장점 : 타입의 안정성
 *        -단점 : 초기설정이 어려움 => Q-class 생성
 *               QueryDSL의 문법이 까다로움
 *        => 복잡한 JOIN / 필터링 / 페이징
 *     --------------------------------------------
 *     단순 조회 : 메서드 규칙 => SELECT *
 *               => Getter만 있는 interface
 *     복잡한 동적쿼리 / 검색 : QueryDSL / MyBatis
 *     수정 / 삭제 / 정적쿼리 : JPQL
 */
public interface EmpJpqlRepository extends JpaRepository<Emp, Integer> {
	@Query("""
			SELECT e 
			FROM Emp e
			""")
	public List<Emp> empListData();

//	public Emp findByEmpno(int empno);
	@Query("""
			SELECT e 
			FROM Emp e 
			WHERE e.empno=:empno
			""")
	public Emp empDetailData(@Param("empno")int empno);
//	public List<Emp> findByEname(String ename);
	@Query("""
			SELECT e 
			FROM Emp e 
			WHERE e.ename=:ename
			""")
	public List<Emp> empEnameFind(@Param("ename")String ename);
//	// LIKE
//	public List<Emp> findByEnameStartsWith(String ename);
	@Query("""
			SELECT e
			FROM Emp e
			WHERE e.ename LIKE CONCAT(:ename,'%')
			""")
	public List<Emp> empEnameStartsLike(@Param("ename")String ename);
//	public List<Emp> findByEnameEndsWith(String ename);
	@Query("""
			SELECT e
			FROM Emp e
			WHERE e.ename LIKE CONCAT('%',:ename)
			""")
	public List<Emp> empEnameEndsLike(@Param("ename")String ename);
//	public List<Emp> findByEnameContains(String ename);
	@Query("""
			SELECT e
			FROM Emp e
			WHERE e.ename LIKE CONCAT('%',:ename,'%')
			""")
	public List<Emp> empLikeData(@Param("ename")String ename);
//	// 비교
//	public List<Emp> findBySalGreaterThanEqual(int sal);
	@Query("""
			SELECT e
			FROM Emp e
			WHERE e.sal>=:sal
			""")
	public List<Emp> empGreater(@Param("sal")int sal);
//	public List<Emp> findBySalLessThanEqual(int sal);
	@Query("""
			SELECT e
			FROM Emp e
			WHERE e.sal<=:sal
			""")
	public List<Emp> empLess(@Param("sal")int sal);
//	public List<Emp> findBySalBetween(int min,int max);
	@Query("""
			SELECT e
			FROM Emp e
			WHERE e.sal BETWEEN :min AND :max
			""")
	public List<Emp> empBetween(@Param("min")int min,@Param("max")int max);
//	public List<Emp> findByJobAndSalGreaterThanEqual(String job,int sal);
	@Query("""
			SELECT e
			FROM Emp e
			WHERE e.job=:job AND e.sal>=:sal
			""")
	public List<Emp> empJobAndSal(@Param("job")String job,@Param("sal")int sal);
//	public List<Emp> findByJobOrEname(String job,String ename);
	@Query("""
			SELECT e
			FROM Emp e
			WHERE e.job=:job OR e.ename=:ename
			""")
	public List<Emp> empJobOrEname(@Param("job")String job,@Param("ename")String ename);
//	public List<Emp> findByDeptDname(String dname);
	@Query("""
			SELECT e
			FROM Emp e
			JOIN e.dept d
			WHERE d.dname=:dname
			""")
	public List<Emp> empDnameData(@Param("dname")String dname);
//	public List<Emp> findByDeptLoc(String loc);
//	public List<Emp> findByDeptDnameContains(String dname);
	@Query("""
			SELECT e
			FROM Emp e
			JOIN e.dept d
			WHERE d.dname LIKE CONCAT('%',:dname,'%')
			""")
	public List<Emp> empDnameContain(@Param("dname")String dname);
//	// 정렬
//	public List<Emp> findByOrderBySalDesc();
//	// Top-N
//	public List<Emp> findTop3ByOrderBySalDesc();
//	@Query("""
//			SELECT e, RANK() OVER (ORDER BY sal DESC) r
//			FROM Emp e
//			WHERE r<=3
//			""")
//	public List<Emp> empTop3Data();
//	// 중복 제거
//	public List<Emp> findDistinctByJob(String job);
//	@Query("""
//			SELECT DISTINCT e.job
//			FROM Emp e
//			""")
//	public List<Emp> empDistinctJob();
//	// NOT NULL / NULL
//	public List<Emp> findByCommIsNull();
	@Query("""
			SELECT e
			FROM Emp e
			WHERE e.comm IS NULL
			""")
	public List<Emp> empCommNull();
//	public List<Emp> findByCommIsNotNull();
	@Query("""
			SELECT e
			FROM Emp e
			WHERE e.comm IS NOT NULL
			""")
	public List<Emp> empCommNotNull();
//	// in
//	public List<Emp> findByDeptDeptnoIn(List<Integer> deptnos);
	@Query("""
			SELECT e
			FROM Emp e
			JOIN e.dept d
			WHERE d.deptno IN :deptnos
			""")
	public List<Emp> empDeptnoIn(@Param("deptnos")List<Integer> deptnos);
//	// not
//	public List<Emp> findByJobNot(String job);

}
