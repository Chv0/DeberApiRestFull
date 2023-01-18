package com.tendencias.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tendencias.app.dao.UserRepository;
import com.tendencias.app.entity.User;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository users;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<User> findAll() {
		return users.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<User> findAll(Pageable pageable) {
		return users.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<User> findById(Long Id) {
		return users.findById(Id);
	}

	@Override
	@Transactional
	public User save(User user) {
		return users.save(user);
	}

	@Override
	@Transactional
	public void deleteById(Long Id) {
		users.deleteById(Id);
	}
}
