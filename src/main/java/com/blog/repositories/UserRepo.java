package com.blog.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entity.User;
import com.blog.payloads.UserDto;

public interface UserRepo extends JpaRepository<User,Integer> {
	

	Optional<User>findByEmail(String email);
	void save(UserDto user);
	
}
