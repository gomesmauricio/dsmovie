package com.devsuperior.dsmovie.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmovie.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
}
