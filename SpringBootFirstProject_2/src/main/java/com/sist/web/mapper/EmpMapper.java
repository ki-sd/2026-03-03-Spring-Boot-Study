package com.sist.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sist.web.vo.EmpVO;

@Mapper
public interface EmpMapper {
	@Select("""
			SELECT empno,ename,job,sal
			FROM emp
			""")
	public List<EmpVO> empListData();
}
