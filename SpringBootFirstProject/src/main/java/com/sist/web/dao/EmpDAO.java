package com.sist.web.dao;

import org.springframework.stereotype.Repository;

import com.sist.web.mapper.EmpMapper;
import com.sist.web.vo.EmpVO;

import lombok.RequiredArgsConstructor;

import java.util.*;
@Repository
@RequiredArgsConstructor
public class EmpDAO {
	private final EmpMapper mapper;
	
	public List<EmpVO> empListData(){
		return mapper.empListData();
	}
}
