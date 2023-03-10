package com.tendencias.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tendencias.app.entity.User;

@Service
public interface UserService {
	public Iterable<User> findAll();
	
	public Page<User> findAll(Pageable pageable);
	
	public Optional<User> findById(Long Id);
	
	public User save(User user);
	
	public void deleteById(Long Id);
}
