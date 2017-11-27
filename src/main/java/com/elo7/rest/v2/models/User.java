package com.elo7.rest.v2.models;

import java.time.LocalDateTime;

public class User {

	private String email;
	private String name;
	private String surName;
	private LocalDateTime registrationDate;
	
	public User(String name, String surName, String email) {
		super();
		this.email = email;
		this.name = name;
		this.surName = surName;
		this.registrationDate = LocalDateTime.now();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

}