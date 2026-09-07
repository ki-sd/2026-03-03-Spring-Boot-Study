package com.sist.web.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
/*
 *     1. 동작 순서
 *     2. JWT 개념
 *     3. SpringSecurity 동작
 *     4. 각 클래스 역할
 *        AuthenticationFilter / AuthenticationProvider
 *        JwtSecurityConfig
 *     5. Controller = ThymeLeaf
 *    -----------------------------------------------------
 *     1. 동작 순서
 *          |
 *        로그인 요청
 *          | = POST : /member/login
 *        AuthController
 *          | = AuthenticationManager.authenticate()
 *            = 인증 여부 확인
 *        CustomUserDetailsService
 *          | = 사용자 검색
 *        UserDetails
 *          | = 저장 => 인증 성공
 *        Authentication 성공
 *          |
 *        AuthenticationProvider
 *          | = createToken()
 *        JWT 발급 => 기간 => Cookie에 저장
 *          |
 *        브라우저
 *          |
 *        JwtAuthenticationFilter
 *          | = Authentication 헤더 확인
 *          | = 토큰 추출
 *          | = JWT 검증
 *          | = username 추출
 *          | = UserDetails 조회
 *          | = SecurityContext 정보 저장
 *        Controller에 접근
 *        ------------------------------
 *        JWT (JSON WEB Token)
 *        xxxxx.yyyyy.zzzzz
 *                    |Signature
 *              |Payload
 *               (실제 정보 저장)
 *        |Header
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	private final UserDetailsService userDetailService;
	private final JwtTokenProvider provider;
	
	public JwtAuthenticationFilter(UserDetailsService userDetailService,JwtTokenProvider provider) {
		this.userDetailService=userDetailService;
		this.provider=provider;
	}
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token=null;
		String header=request.getHeader("Authorization");
		
		// Authoriztion Header 확인
		if(header!=null && header.startsWith("Bearer")) {
			token=header.substring(7);
		
		// Header가 없으면 Cookie 확인
			if(token==null && request.getCookies()!=null) {
				for(Cookie cookie:request.getCookies()) {
					if("accessToken".equals(cookie.getName())) {
						token=cookie.getValue();
						break;
					}
				}
			}
			
		// JWT가 존재하면 인증
			if(token!=null && provider.validate(token)) {
				String username=provider.getUsername(token);
				UserDetails user=userDetailService.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken auth=new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		}
		try {
			filterChain.doFilter(request, response);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
