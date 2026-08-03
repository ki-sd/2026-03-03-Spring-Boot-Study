package com.sist.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sist.web.vo.*;
import java.util.*;
import com.sist.web.entity.*;
// 단점: JOIN이 어렵다 / SubQuery를 지원하지 않는다
// 아직 MyBatis가 주류 (MyBatis 8:2 JPA)
@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{
	public BoardEntity findByNo(int no); // 상세보기
	/*
	 *     findByNo
	 *         ---- WHERE no=
	 *     ---- SELECT*
	 *     
	 *     findByNameLike
	 *           WHERE name LIKE 
	 */
	// 직접 SQL문장 생성 => findAll(page)
	@Query(value="""
				SELECT no,subject,name,hit,TO_CHAR(regdate,'yyyy-mm-dd') AS dbday 
				FROM jpaboard 
				ORDER BY no DESC 
				OFFSET :start ROWS FETCH NEXT 10 ROWS ONLY
			""",nativeQuery = true)
	public List<BoardDTO> boardListData(@Param("start") Integer start);
	
}
