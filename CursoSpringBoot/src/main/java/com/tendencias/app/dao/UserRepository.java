package com.tendencias.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tendencias.app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	
}
