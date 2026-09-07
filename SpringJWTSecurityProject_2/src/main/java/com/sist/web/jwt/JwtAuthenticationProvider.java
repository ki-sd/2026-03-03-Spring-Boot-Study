package com.sist.web.jwt;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
@Component
public class JwtAuthenticationProvider {
	private final String SECRET="aBGOnKVsDzWfppGDu3sA5fZt9JCMDVS8qgP1xwX60PI";
	public String createToken(String username,String role) {
		return Jwts.builder()
				.setSubject(username) // 사용자 ID 저장 {sub: admin}
				.claim("role", role) // 권한 추가 => ROLE_ADMIN
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+3600000))
				.signWith(Keys.hmacShaKeyFor(SECRET.getBytes()))
				.compact();
	}
	public String getUsername(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(SECRET.getBytes())
				.build()
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}
	public boolean validate(String token) {
		try {
			Jwts.parserBuilder()
				.setSigningKey(SECRET.getBytes())
				.build()
				.parseClaimsJws(token);
				return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
