package com.sist.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sist.web.entity.Emp;
import com.sist.web.entity.QDept;
import com.sist.web.entity.QEmp;

import lombok.RequiredArgsConstructor;
/*
 *   1. window<showview<other<gradle<Gradle Tasks
 *   2. ./gradlew clean compileJava
 *      터미널에서 실행 
 *   3. project폴더에서 gradle > refresh
 *   4. project < clean설정
 *   Q-class : 데이터베이스를 검색할때 사용하는 Java 코드 생성 
 *       => Query DSL => 자동으로 생성
 *       Dept => QDept  
 */
@Repository
@RequiredArgsConstructor
public class EmpQueryRepository {
   private final JPAQueryFactory queryFactory;
   /*
    @Query("SELECT e FROM Emp e") 
    // Emp는 테이블이 아니고 Entity 객체명 
    // 반드시 별칭을 사용해야 된다 
    public List<Emp> empListData();
    
    // Emp findByEmpno(int empno);
    @Query("SELECT e FROM Emp e WHERE e.empno=:empno")
    public Emp empDetailData(@Param("empno") int empno);
    
    // List<Emp> findByEname(String ename);
    @Query("SELECT e FROM Emp e WHERE e.ename=:ename")
    public List<Emp> empEnameFind(@Param("ename") String ename);
    
    // List<Emp> findByEnameStartsWith(String ename);
    @Query("SELECT e FROM Emp e WHERE e.ename LIKE CONCAT(:ename,'%')")
    // :ename||'%'
    public List<Emp> empEnameStartsLike(@Param("ename") String ename);
    // => eDao2.empEnameStartsLike("K")
    
    // List<Emp> findByEnameContains(String ename);
    @Query("SELECT e FROM Emp e WHERE e.ename LIKE CONCAT('%',:ename,'%')")
    public List<Emp> empLikeData(@Param("ename") String ename);
    // %A%
    // List<Emp> findBySalGreaterThanEqual(int sal);
    @Query("SELECT e FROM Emp e WHERE e.sal>=:sal")
    List<Emp> findBySalGreaterThanEqual(@Param("sal") int sal);
    
    // List<Emp> findBySalBetween(int min,int max);
    @Query("SELECT e FROM Emp e WHERE e.sal BETWEEN :min AND :max")
    List<Emp> findBySalBetween(@Param("min")int min,
    		  @Param("max")int max);
    
    // List<Emp> findByJobAndSalGreaterThan(String job,int sal);
    @Query("SELECT e FROM Emp e "
    	  +"WHERE e.job=:job AND e.sal>:sal")
    List<Emp> findByJobAndSalGreaterThan(
    		@Param("job")String job,
    		@Param("sal")int sal);
    
    //List<Emp> findByDeptDname(String dname);
    @Query("SELECT e FROM Emp e "
    	  +"JOIN e.dept d "
    	  +"WHERE d.dname=:dname")
    List<Emp> findByDeptDname(@Param("dname") String dname);
    
    // List<Emp> findByDeptDnameContains(String dname);
    @Query("SELECT e FROM Emp e "
      	  +"JOIN e.dept d "
      	  +"WHERE d.dname LIKE CONCAT('%',:dname,'%')")
    List<Emp> findByDeptDnameContains(
    		@Param("dname") String dname);
    @Query("SELECT e FROM Emp e "
    	  +"WHERE e.comm IS NULL")
    List<Emp> findByCommIsNull();
    // List<Emp> findByJobNot(String job);
    @Query("SELECT e FROM Emp e "
    	  +"WHERE e.job<>:job")
    List<Emp> findByJobNot(@Param("job") String job);
    
    // List<Emp> findByDeptDeptnoIn(List<Integer> deptnos);
    @Query("SELECT e FROM Emp e "
    	  +"WHERE e.dept.deptno IN :deptnos")
    List<Emp> findByDeptDeptnoIn(@Param("deptnos")List<Integer> deptnos);
    */
   //  @Query("SELECT e FROM Emp e") : JPQL  
   //  Emp findByEmpno(int empno) : 메소드 규칙
   // QueryDSL
   public Emp findByEmpno(int empno)
   {
	   QEmp emp=QEmp.emp; // Q-class
	   return (Emp) queryFactory.from(emp)
			              .where(emp.empno.eq(empno))
			              .fetchOne();
   }
   
   //List<Emp> findByEname(String ename);
   //@Query("SELECT e FROM Emp e WHERE e.ename=:ename")
   /*
    *    from(테이블 : Q-class 객체)
    *    where(조건)
    *    orderBy(컬럼.desc())
    *    groupBy(컬럼)
    *    having(조건)
    *    
    *    연산자 : eq = 
    *           > gt
    *           < goe
    */
   public List<Emp> findByEname(String ename){
	   QEmp emp=QEmp.emp; // Q-class
	   return (List<Emp>)queryFactory.from(emp)
			             .where(emp.ename.eq(ename))
			             .fetch();
   }
   /*
    *   List<Emp> findByEnameStartsWith(String ename);
        @Query("SELECT e FROM Emp e WHERE e.ename LIKE CONCAT(:ename,'%')")
    */
   // ename%
   public List<Emp> findByEnameStartsWith(String ename)
   {
	   QEmp emp=QEmp.emp;
	   return (List<Emp>)queryFactory.from(emp)
			  .where(emp.ename.startsWith(ename))
			  .fetch();
   }
   // %ename
   public List<Emp> findByEnameEndsWith(String ename)
   {
	   QEmp emp=QEmp.emp;
	   return (List<Emp>)queryFactory.from(emp)
			  .where(emp.ename.endsWith(ename))
			  .fetch();
   }
   // %ename%
   public List<Emp> findByEnameContains(String ename)
   {
	   QEmp emp=QEmp.emp;
	   return (List<Emp>)queryFactory.from(emp)
			  .where(emp.ename.contains(ename))
			  .fetch();
   }
   // 비교연산자 
   /*
    *    = : eq()  emp.sal.eq(3000)  sal=3000
    *    ------------------------------------------
    *    < : lt()  emp.sal.lt(3000)  sal<3000
    *              LessThan
    *    > : gt()  emp.sal.gt(3000)  sal>3000
    *              GreaterThan
    *    <= : loe() emp.sal.loe(3000)  sal<=3000
    *              LessThanEqual
    *    >= : goe() emp.sal.goe(3000)  sal>=3000
    *              GreaterThanEqual
    *    -------------------------------------------
    *    != : ne()  emp.sal.ne(3000)  sal<>3000
    *    
    *    메소드가 연산자 명칭을 그대로 사용 
    *    between() in()
    * 
    */
   //List<Emp> findBySalGreaterThanEqual(int sal);
   //@Query("SELECT e FROM Emp e WHERE e.sal>=:sal")
   //List<Emp> findBySalGreaterThanEqual(@Param("sal") int sal);
   public List<Emp> findBySalGreaterThanEqual(int sal)
   {
	   QEmp emp=QEmp.emp;
	   return (List<Emp>) queryFactory.from(emp)
			      .where(emp.sal.goe(sal))
			      .fetch();
	   // sal>=?  sal<=? sal<? sal>? sal<>? sal=?
	   // emp.sal.goe(sal)
	   // emp.sal.loe(sal)
	   // emp.sal.lt(sal)
	   // emp.sal.gt(sal)
	   // emp.sal.ne(sal)
	   // emp.sal.eq(sal)
   }
   /*
    *  @Query("SELECT e FROM Emp e WHERE e.sal BETWEEN :min AND :max")
    List<Emp> findBySalBetween(@Param("min")int min,
    		  @Param("max")int max);
    */
   public List<Emp> findBySalBetween(int min,int max)
   {
	   QEmp emp=QEmp.emp;
	   return (List<Emp>) queryFactory.from(emp)
			      .where(emp.sal.between(min, max))
			      .fetch();
   }
   // AND / OR 
   //List<Emp> findByJobAndSalGreaterThan(String job,int sal);
   //@Query("SELECT e FROM Emp e "
   	  //+"WHERE e.job=:job AND e.sal>:sal")
   public List<Emp> findByJobAndSalGreaterThan(String job,int sal)
   {
	   QEmp emp=QEmp.emp;
	   return (List<Emp>) queryFactory.from(emp)
			      .where(emp.job.eq(job).and(emp.sal.gt(sal)))
			      .fetch();
	   /*
	    *  return (List<Emp>) queryFactory.from(emp)
			      .where(emp.job.eq(job),emp.sal.gt(sal))
			      .fetch();
		   return (List<Emp>) queryFactory.from(emp)
			      .where(emp.job.eq(job).or(emp.sal.gt(sal)))
			      .fetch();
	    */
   }
   // 부서명 / 근무지 
   /*
    *   //List<Emp> findByDeptDname(String dname);
	    @Query("SELECT e FROM Emp e "
	    	  +"JOIN e.dept d "
	    	  +"WHERE d.dname=:dname")
	    List<Emp> findByDeptDname(@Param("dname") String dname);
    */
   // 정렬 
   /*
    *   orderBy
    */
   public List<Emp> findByOrderBySal()
   {
	   QEmp emp=QEmp.emp;
	   return (List<Emp>) queryFactory.from(emp)
			      .orderBy(emp.sal.desc())
			      .fetch();
   }
   // Top-N
   /*
    *  String jpql="SELECT e FROM Emp e "
			      +"ORDER BY e.sal DESC";
	   List<Emp> list=em.createQuery(jpql,Emp.class)
			          .setMaxResults(3)
			          .getResultList();*/
   public List<Emp> findByTop3Sal()
   {
	   QEmp emp=QEmp.emp;
	   return (List<Emp>) queryFactory.from(emp)
			      .orderBy(emp.sal.desc())
			      .limit(3)
			      .fetch();
   }
    
   /*
    *   @Query("SELECT e FROM Emp e "
    	  +"WHERE e.comm IS NULL")
	    List<Emp> findByCommIsNull();
	    // List<Emp> findByJobNot(String job);
	    @Query("SELECT e FROM Emp e "
	    	  +"WHERE e.job<>:job")
	    List<Emp> findByJobNot(@Param("job") String job);
	    
	    // List<Emp> findByDeptDeptnoIn(List<Integer> deptnos);
	    @Query("SELECT e FROM Emp e "
	    	  +"WHERE e.dept.deptno IN :deptnos")
    */
   // Distinct
   public List<Integer> findDistinctSal()
   {
	   QEmp emp=QEmp.emp;
	   return (List<Integer>) queryFactory.select(emp.sal)
			                  .distinct()
			                  .from(emp)
			                  .fetch();
   }
   // NULL 
   public List<Emp> findByCommIsNull()
   {
	   QEmp emp=QEmp.emp;
	   return (List<Emp>) queryFactory.from(emp)
			      .where(emp.comm.isNull())
			      .fetch();
	   /*
	    *   return (List<Emp>) queryFactory.from(emp)
			      .where(emp.comm.isNotNull())
			      .fetch();
	    */
   }
   // IN
   /*
    *  List<Emp> findByDeptDeptnoIn(List<Integer> deptnos);
	    @Query("SELECT e FROM Emp e "
	    	  +"WHERE e.dept.deptno IN :deptnos")
    */
   public List<Emp> findByDeptDeptnoIn(List<Integer> deptnos)
   {
	   QEmp emp=QEmp.emp;
	   return (List<Emp>) queryFactory.from(emp)
			      .where(emp.dept.deptno.in(deptnos)) // != (ne)
			      .fetch();
   }
   // NOT
   /*
    *   @Query("SELECT e FROM Emp e "
	    	  +"WHERE e.job<>:job")
	    List<Emp> findByJobNot(@Param("job") String job);
    */
   public List<Emp> findByJobNot(String job)
   {
	   QEmp emp=QEmp.emp;
	   return (List<Emp>) queryFactory.from(emp)
			      .where(emp.job.ne(job)) // != (ne)
			      .fetch();
   }
   /*
    *   //List<Emp> findByDeptDname(String dname);
	    @Query("SELECT e FROM Emp e "
	    	  +"JOIN e.dept d "
	    	  +"WHERE d.dname=:dname")
	    List<Emp> findByDeptDname(@Param("dname") String dname);
    */
   public List<Emp> findByDeptDname(String dname)
   {
	   QEmp emp=QEmp.emp;
	   QDept dept=QDept.dept;
	   return (List<Emp>) queryFactory.from(emp)
		                  .join(emp.dept,dept)
		                  .where(dept.dname.eq(dname))
		                  .fetch();
   }
   public List<Emp> findByDeptDnameLike(String dname)
   {
	   QEmp emp=QEmp.emp;
	   QDept dept=QDept.dept;
	   return (List<Emp>) queryFactory.from(emp)
		                  .join(emp.dept,dept)
		                  .where(dept.dname.contains(dname))
		                  .fetch();
   }
}
