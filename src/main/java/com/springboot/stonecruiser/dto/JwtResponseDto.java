package com.springboot.stonecruiser.dto;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponseDto {
    
	private Long id;
	private String token;
	private String type="Bearer";
	private String username;
	private String email;
	private List<String> roles; 
}
