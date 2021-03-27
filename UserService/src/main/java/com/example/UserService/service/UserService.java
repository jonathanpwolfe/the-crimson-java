package com.example.UserService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.UserService.model.User;
import com.example.UserService.repository.UserRepository;

@Component
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	

	public User getUserById(int id) {
		User user = null;
		user = userRepository.getUserById(id);
		return user;
	}

	public User createUser(User user) {
		if(true){
			//conditions
		userRepository.insertUser(user);
		return user;
		}
		else
		return null;
	}

	public User getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean validate(User user, String password)
	{	
		PasscodeService passcodeService =new PasscodeService();
		if(passcodeService.validate(user.getId(), password)==true)
			return true;
		else
		return false;
	}
}