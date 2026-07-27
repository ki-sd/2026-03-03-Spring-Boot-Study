package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.web.service.EmpService;
import com.sist.web.vo.EmpVO;

import java.util.*;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmpController {
	private final EmpService service;
	
	@GetMapping("/emp/list.do")
	public String emp_list(Model model) {
		List<EmpVO> list=service.empListData();
		model.addAttribute("list",list);
		return "/emp/list";
	}
}
