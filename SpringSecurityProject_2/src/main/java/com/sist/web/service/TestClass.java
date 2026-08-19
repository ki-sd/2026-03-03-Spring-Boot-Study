package com.sist.web.service;
/*
 *     인증 처리
 *     1. 사용자가 로그인 요청
 *        => username(ID), password(PWD)
 *     2. UsernamePasswordAuthenticationFilter 요청을 인터셉트
 *     3. UsernamePasswordAuthenticationToken 인증용 객체 생성
 *     4. 토큰 => AuthenticationManager 에 전송
 *                      |
 *               AuthenticationProvider
 *                      |
 *               UserDetailsService 를 통해서 DB에서 사용자 정보 조회
 *                      |
 *               조회된 데이터 (사용자 정보)
 *                          --------
 *                          UserDetails
 *     5. 인증성공 => SecurityContext에 저장
 *                  | Principal
 *                  
 *        => UserDetails
 *        => UsetDetailsService
 *        => PasswordEncoding
 */
public class TestClass {

}
