package com.springboot.stonecruiser.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.stonecruiser.entity.User;
import com.springboot.stonecruiser.model.CustomUserDetails;
import com.springboot.stonecruiser.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByCode(username).orElseThrow(
				() -> new UsernameNotFoundException("User not found with usercode and password" + username));
		Set<GrantedAuthority> authorities = user.getRoles().stream()
				.map((roles) -> new SimpleGrantedAuthority(roles.getRole())).collect(Collectors.toSet());
      
	//	return new org.springframework.security.core.userdetails.User(user.getCode(), user.getPassword(), authorities);
		return  CustomUserDetails.build(user);
	}

}
