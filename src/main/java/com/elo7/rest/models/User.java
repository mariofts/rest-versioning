package com.elo7.rest.models;

import java.time.LocalDateTime;

public class User {

	public User(String email, String fullName) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.registrationDate = LocalDateTime.now();
	}

	private String email;
	private String fullName;
	private LocalDateTime registrationDate;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

}
