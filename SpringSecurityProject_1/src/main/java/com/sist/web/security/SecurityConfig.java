package com.sist.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		/*
		 *     접근권한
		 *     
		 *     로그인
		 *     로그아웃
		 *     자동로그인
		 *     
		 *     Controller
		 *        |
		 *     SecurityConfig  =>  URL 별 권한 설정
		 *        |
		 *     CutomUserDetailsService  =>  사용자 정보 / 권한 정보
		 *     
		 *     => ${}    th:each="vo:${list}"
		 *                        [[${vo.name}]]
		 *     => ${sessionScope.id} => JSP
		 *        => ${session.id} => ThymeLeaf
		 *        
		 *     => .roles("ADMIN") => ROLE_ADMIN
		 *     
		 *     authority : 권한
		 *     springmember : enable / userid username userpwd
		 */
		//   1. 인증 => 권한 부여
		http
			.csrf(csrf->csrf.disable())
			.authorizeHttpRequests(auth->auth
					.requestMatchers("/","/login").permitAll()
					.requestMatchers("/user").authenticated()
					.requestMatchers("/admin").hasRole("ADMIN")
					.anyRequest().permitAll()
			)
		// 2. 로그인
			.formLogin(form->form
					.loginPage("/login")
					.loginProcessingUrl("/login")     // Controller 처리가 아니라 Security에서 인터셉트로 처리
					.defaultSuccessUrl("/",true)
					.failureUrl("/login?error")
					.permitAll()
			)
		// 3. 로그아웃
			.logout(logout->logout
					.logoutSuccessUrl("/")
			);
		return http.build();
	}
	// PasswordEncoding => 암호화
}
