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
import com.example.UserService.service.UserServiceDAO;

@RestController
public class UserServiceController {
	
	@Autowired
	private UserServiceDAO userServiceDAO;
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable int id) {
		User possibleUser = userServiceDAO.getUserById(id);
		if(possibleUser != null) {
			return possibleUser;
		}
		else
			return userServiceDAO.getAllUsers();
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User newUser = userServiceDAO.createUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
}
