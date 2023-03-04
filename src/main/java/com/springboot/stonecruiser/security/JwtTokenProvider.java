package com.springboot.stonecruiser.security;

import java.util.Date;
import java.security.Key;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {
  

	@Value("${quckstore.app.jwtExpirationMs}")
	private long expireTime;
	
	@Value("${quckstore.app.jwtSecret}")
	private String jwtSecret;
	
	public String genrateToken(Authentication authentication) {
		
		String username = authentication.getName(); 
		
		Date currentDate = new Date();
		Date expireDate =  new Date(currentDate.getTime() + expireTime);
		
		String token =Jwts.builder()
		.setSubject(username)
		.setIssuedAt(currentDate)
		.setExpiration(expireDate)
		.signWith(getKey())
		.compact();
		return token;
		
	}

	private Key getKey() {
		return Keys.hmacShaKeyFor(
				 Decoders.BASE64.decode(jwtSecret)
				);
	}
	
	
	public String  getUsernameFromToken(String token) {
		  Claims claims =  Jwts.parserBuilder()
		   .setSigningKey(getKey())
		   .build()
		   .parseClaimsJws(token)
		   .getBody();
		  String username = claims.getSubject();
		  return username;
	}
	
	public boolean validateToken(String token) throws Exception {
		
		try {
			Jwts.parserBuilder()
			.setSigningKey(getKey())
			.build()
			.parse(token);
			return true;
		}catch (MalformedJwtException e) {
			throw new Exception( "Invalid Jwt token");
		}catch (ExpiredJwtException e) {
			throw new Exception( "Expired Jwt token");
		}catch (UnsupportedJwtException e) {
			throw new Exception( "unsupported Jwt token");
		}catch (IllegalArgumentException e) {
			throw new Exception( " Jwt claims token is empty token");
		}
		
	}
}
