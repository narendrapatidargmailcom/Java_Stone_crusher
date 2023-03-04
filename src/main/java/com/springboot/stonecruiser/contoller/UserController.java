package com.springboot.stonecruiser.contoller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.stonecruiser.dto.UserDTO;
import com.springboot.stonecruiser.entity.User;
import com.springboot.stonecruiser.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/users")
public class UserController {
    
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>> getUserDetails(@PathVariable Long id){
		
	Optional<User> user=userRepository.findById(id);
		return ResponseEntity.ok(user) ;
	}
}
