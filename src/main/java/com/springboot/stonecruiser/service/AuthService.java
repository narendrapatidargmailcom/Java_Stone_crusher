package com.springboot.stonecruiser.service;

import com.springboot.stonecruiser.dto.JwtResponseDto;
import com.springboot.stonecruiser.dto.UserDTO;

public interface AuthService {
	JwtResponseDto login(UserDTO userDto);
} 
