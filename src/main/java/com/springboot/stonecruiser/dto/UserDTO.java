package com.springboot.stonecruiser.dto;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDTO {
	private Long id;
	private String userCode;
	private String firstName;
	private String lastName;
	private String emailId;
	private String mobNumber;
	private String password;
	private Set<RoleDTO> roles;
	private Collection<? extends GrantedAuthority> authorities;
}

