package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

import com.sist.web.entity.BoardEntity;
import com.sist.web.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("board/") // 중복되는 경로
public class BoardController {
	private final BoardService bService;
	
	@GetMapping("list")
	public String board_list(Model model,@RequestParam(value="page", defaultValue = "1")String page) {
		if(page==null) page="1";
		int curpage=Integer.parseInt(page);
		final int ROW=10;
		int start=(curpage*ROW)-ROW;
		List<BoardEntity> list=bService.boardListData(start);
		int count=bService.boardRowCount();
		int totalpage=(int)Math.ceil(count/10.0);
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		return "board/list";
	}
}
