package com.example.UserService.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.UserService.model.User;
import com.example.UserService.service.UserService;

@RestController
public class UserServiceController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable int id) {
		User possibleUser = userService.getUserById(id);
		if(possibleUser != null) {
			return possibleUser;
		}
		else
			return userService.getAllUsers();
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User newUser = userService.createUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
}

