package com.sist.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/*
 *     1. 로그인 요청 : POST => /member/login
 *     2. AuthController
 *         => AuthenticationManager 인증의 위임
 *         => AuthenticationManager는 userDetailService 통해 데이터베이스에서 사용자 검색 => 비번/아이디 일치 확인
 *     3. JWT 발급 / 쿠키에 저장
 *         => JwtTokenProvider
 *            => 1) 인증 성공 여부 => 아이디+권한을 포함한 데이터를 JWT 토큰에 추가
 *               2) JWT 토큰을 Cookie에 저장
 *               3) /home으로 이동
 *     4. JwtAuthenticationFilter
 *         => 다른 페이지 요청시 
 *            브라우저는 쿠키, JWT Header
 *                        ---------- JS
 *               | 쿠키 읽어서 accessToken 추출
 *                 => UserDetailsService 정보 읽어서
 *                 => SecurityContextHolder에 저장
 *     5. 컨트롤러 접근 완료
 */


@Configuration
@EnableWebSecurity
public class JwtSecurityConfig {
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	
	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter(UserDetailsService uds,JwtTokenProvider provider) {
		return new JwtAuthenticationFilter(uds,provider);
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http,JwtAuthenticationFilter filter) throws Exception{
		// 위조방지
		http
			.csrf(csrf->csrf.disable())
			.sessionManagement(session->
					session.sessionCreationPolicy(
							SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(auth->auth
					.requestMatchers("/","/login","member/login").permitAll()
					.requestMatchers("/admin").hasRole("ADMIN")
					.requestMatchers("/user").hasAnyRole("USER","ADMIN")
					.anyRequest().permitAll())
			.addFilterBefore(filter,UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	
}
