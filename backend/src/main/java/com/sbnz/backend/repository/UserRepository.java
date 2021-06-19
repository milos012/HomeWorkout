package com.sbnz.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbnz.backend.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findeUserById(Long id);

}
