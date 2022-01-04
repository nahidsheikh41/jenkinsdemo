package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/users")
	public User save (@RequestBody User User) {
		try {
		return userRepository.save(User);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/users")
	public List<User> get () {
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User get(@PathVariable String id) {
		Optional<User> User = userRepository.findById(id);
		if (User.isPresent()) {
			return User.get();
		}
		throw new RuntimeException("Not found for the id "+id);

	}
	
	@PutMapping("/users/{id}")
	public User update (@PathVariable String id, @RequestBody User User) {
		User.setId(id);
		return userRepository.save(User);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<HttpStatus> delete (@PathVariable String id) {
		userRepository.deleteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
}
