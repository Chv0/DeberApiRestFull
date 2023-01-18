package com.tendencias.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tendencias.app.entity.User;
import com.tendencias.app.service.UserService;


@RestController
@RequestMapping("/api/users")


public class UserController {
	@Autowired
	private UserService users;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED) .body(users.save(user));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value ="id") Long Id){
		Optional<User> user=users.findById(Id);
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody User userDetails, @PathVariable(value = "id") Long userId){
		Optional<User> user = users.findById(userId);
		
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		user.get().setName(userDetails.getName());
		user.get().setSurename(userDetails.getSurename());
		user.get().setEmail(userDetails.getEmail());
		user.get().setEnabled(userDetails.getEnabled());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(users.save(user.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable (value = "id") Long userId){
		
		if (!users.findById(userId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		users.deleteById(userId);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<User> readAll() {
		
		List<User> user = StreamSupport.stream(users.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return user;
	}
	
}
