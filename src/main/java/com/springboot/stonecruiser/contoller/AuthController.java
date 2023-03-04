package com.springboot.stonecruiser.contoller;
 
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.stonecruiser.dto.JwtResponseDto;
import com.springboot.stonecruiser.dto.UserDTO;
import com.springboot.stonecruiser.security.JwtTokenProvider;
import com.springboot.stonecruiser.service.AuthService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authservice;
    
   
    
    @PostMapping("/login")
    public ResponseEntity<JwtResponseDto> login(@RequestBody UserDTO userDto) {
    	System.out.println("entering in login");
    	JwtResponseDto jwtResponseDto= authservice.login(userDto);
    //	JwtResponseDto jwtResponseDto = new JwtResponseDto();
    //	jwtResponseDto.setToken(response);
		return ResponseEntity.ok(jwtResponseDto);
    	
    }
}
