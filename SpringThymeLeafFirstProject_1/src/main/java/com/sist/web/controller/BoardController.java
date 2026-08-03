package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

import com.sist.web.entity.BoardEntity;
import com.sist.web.service.BoardService;
import com.sist.web.vo.BoardDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("board/") // 중복되는 경로
public class BoardController {
	private final BoardService bService;
/*
 *    => 값을 받는 경우 @RequestParam 사용
 *    => null값이 있는 경우 required=false
 *    => 그 외는 SpringFramework 와 동일
 *    
 *    ThymeLeaf
 *      서버에서 HTML 파일 + 데이터를 결합하는 기술
 *      
 *      동작 순서
 *      ------
 *       브라우저
 *         | ==== 요청 (<a>,<form>)
 *       Spring Container => DispatcherServlet
 *         | ==== Model에 데이터 전달
 *       ThymeLeaf의 엔진
 *         | ==== HTML + Data 결합
 *       완성된 HTML
 *         |
 *       브라우저 출력
 *       
 *     Spring 통합 => @Controller, Model, @RequestParam
 *     표현식 지원 => ${} , @{} , *{}
 *     객체 : #number => 페이지를 나눠서 처리
 *     디렉티브 : th:
 *       th:text => 데이터 출력
 *       th:utext => html을 출력
 *       th:each => for
 *       th:if => 조건문
 *       ----- 반대 th:unless (else)
 *       th:href => 링크, th:src , th:value , th:action
 *       
 *       객체
 *        => #datas : 날짜 변환
 *           <span th:text="${#datas.format(data,"yyyy-MM-dd")}">
 *        => #strings : 문자열 제어
 *           <span th:text="${#strings.length(name)}">
 *        => #lists : 배열 출력
 *        => #numbers : 숫자 출력
 *        => #authentication : 보안
 */
	@GetMapping("list")
	public String board_list(Model model,@RequestParam(value="page", defaultValue = "1")String page) {
		if(page==null) page="1";
		int curpage=Integer.parseInt(page);
		final int ROW=10;
		int start=(curpage*ROW)-ROW;
		List<BoardDTO> list=bService.boardListData(start);
		int count=bService.boardRowCount();
		int totalpage=(int)Math.ceil(count/10.0);
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		return "board/list";
	}
	@GetMapping("detail")
	public String board_detail(@RequestParam(value="no")int no,Model model) {
		BoardEntity vo=bService.findByNo(no);
		vo.setHit(vo.getHit()+1);
		bService.boardUpdate(vo);
		vo=bService.findByNo(no);
		model.addAttribute("vo", vo);
		return "board/detail";
	}
	@GetMapping("insert")
	public String board_insert() {
		return "board/insert";
	}
	@PostMapping("insert_ok")
	public String board_insert_ok(@ModelAttribute("vo")BoardEntity vo) {
		bService.boardInsert(vo);
		return "redirect:/board/list";
	}
	@GetMapping("delete")
	public String board_delete(@RequestParam(value="no")int no,Model model) {
		model.addAttribute("no", no);
		return "board/delete";
	}
	@PostMapping("delete_ok")
	public String board_delete_ok(@ModelAttribute("vo")BoardEntity vo,Model model) {
		String res="no";
		boolean bCheck=bService.boardDelete(vo);
		if(bCheck) {
			res="yes";
		}
		model.addAttribute("res", res);
		return "board/delete_ok";
	}
	@GetMapping("update")
	public String board_update(@RequestParam(value="no")int no,Model model) {
		BoardEntity vo=bService.findByNo(no);
		model.addAttribute("vo", vo);
		return "board/update";
	}
	@PostMapping("update_ok")
	public String board_update_ok(@ModelAttribute("vo")BoardEntity vo,Model model) {
		String res="no";
		boolean bCheck=bService.boardUpdate(vo);
		if(bCheck) {
			res="yes";
		}
		model.addAttribute("res", res);
		model.addAttribute("no", vo.getNo());
		return "board/update_ok";
	}
}
