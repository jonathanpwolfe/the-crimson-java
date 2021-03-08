package com.example.UserService.model;

import java.util.Date;


public class User {
	
	int id;
	String username;
	String emailAddress;
	Passcode passcode;
	String firstName;
	Date joinDate;
	Date birthDate;
	int upvotes;
	int downvotes;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Passcode getPasscode() {
		return passcode;
	}
	public void setPasscode(Passcode passcode) {
		this.passcode = passcode;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
}
