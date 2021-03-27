package com.example.UserService.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "", schema ="")
public class User {
	@Id
	@Column(name = "")
	private int id;
	@Column(name = "")
	private String username;
	@Column(name = "")
	private String emailAddress;
	@Column(name = "")
	private Passcode passcode;
	@Column(name = "")
	private String firstName;
	@Column(name = "")
	private Date joinDate;
	@Column(name = "")
	private Date birthDate;
	@Column(name = "")
	private int totalUpvotes;
	@Column(name = "")
	private int totalDownvotes;
	@Column(name = "")
	private int totalKarma;
	@Column(name = "")
	private int postCount;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(schema = "", name = "", joinColumns = @JoinColumn(name = "userid"), inverseJoinColumns = @JoinColumn(name = "userid"))
	List<User> friends;
	
	
	public List<User> getFriends() {
		return friends;
	}
	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
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
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public int getUpvotes() {
		return totalUpvotes;
	}
	public void setUpvotes(int upvotes) {
		this.totalUpvotes = upvotes;
	}
	public int getDownvotes() {
		return totalDownvotes;
	}
	public void setDownvotes(int downvotes) {
		this.totalDownvotes = downvotes;
	}
	
}

