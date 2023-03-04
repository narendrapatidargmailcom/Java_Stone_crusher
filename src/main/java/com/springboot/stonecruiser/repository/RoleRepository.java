package com.springboot.stonecruiser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.stonecruiser.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
