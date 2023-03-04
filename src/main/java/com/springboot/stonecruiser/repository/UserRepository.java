package com.springboot.stonecruiser.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.stonecruiser.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public Optional<User> findByCodeAndPassword(String userCode,String password);

	public Optional<User> findByCode(String username);
	
	public Optional<User> findById(long id);
}
