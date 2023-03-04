package com.springboot.stonecruiser.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.springboot.stonecruiser.dto.JwtResponseDto;
import com.springboot.stonecruiser.dto.UserDTO;
import com.springboot.stonecruiser.model.CustomUserDetails;
import com.springboot.stonecruiser.security.JwtTokenProvider;
import com.springboot.stonecruiser.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	 @Autowired
	  private JwtTokenProvider jwtTokenProvider;
	
	@Override
	public JwtResponseDto login(UserDTO userDto) {
    	System.out.println("entering in auth service");

		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUserCode(),userDto.getPassword()));
    	System.out.println("out in auth service");
    	CustomUserDetails userdetails= (CustomUserDetails)authentication.getPrincipal();
    	SecurityContextHolder.getContext().setAuthentication(authentication);
    	String token = jwtTokenProvider.genrateToken(authentication);
    	System.out.println("out in auth service");
    	List<String> roles = userdetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
    	JwtResponseDto jwtResponseDto = new JwtResponseDto();
    	jwtResponseDto.setId(userdetails.getId());
    	jwtResponseDto.setToken(token);
    	jwtResponseDto.setType("Bearer"); 
    	jwtResponseDto.setUsername(userdetails.getUsername());  
    	jwtResponseDto.setEmail(userdetails.getEmail());	 
    	jwtResponseDto.setRoles(roles);
		return jwtResponseDto;
	}

}
