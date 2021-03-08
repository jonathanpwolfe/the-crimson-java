package com.example.UserService.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.UserService.repository.PasscodeRepository;

public class PasscodeServiceDAO {
	@Autowired
	private PasscodeRepository passcodeRepository;
	
	public boolean validate(int userId, String password) {
		if(passcodeRepository.getPasscodeById(userId).equals(password))
			return true;
		else
		return false;
	}
}
