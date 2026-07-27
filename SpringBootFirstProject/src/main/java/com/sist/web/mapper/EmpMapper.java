package com.sist.web.mapper;
/*
 *     1. Mapper => SQL
 *     2. DAO => Mapper 연동 : 데이터베이스 연결
 *     3. Service => DAO 기능 구현 = 로그인/주소 자르기
 *     4. Controller => 브라우저에 출력할 데이터 전송
 *     5. JSp / HTML 출력
 *              ---- ThymeLeaf
 */
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.EmpVO;

import java.util.*;
@Mapper
@Repository
public interface EmpMapper {
	@Select("""
				SELECT empno,ename,job,TO_CHAR(hiredate,'yyyy-mm-dd') AS dbday, sal
				FROM emp
				ORDER BY empno
			"""
			)
	public List<EmpVO> empListData();
}
