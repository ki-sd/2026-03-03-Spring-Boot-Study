package com.sist.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.web.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	private final UserMapper mapper;
	
	@GetMapping("/")
	public String main_page() {
		return "main";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	@GetMapping("/user")
	public String mypage(@AuthenticationPrincipal UserDetails userDetails,Model model) {
		model.addAttribute("id",userDetails.getUsername());
		model.addAttribute("roles",userDetails.getAuthorities());
		return "mypage";
	}
	@GetMapping("/all")
	public String all() {
		return "all";
	}
	@GetMapping("/join")
	public String join() {
		return "join";
	}
}
