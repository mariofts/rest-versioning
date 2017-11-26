package com.elo7.rest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elo7.rest.models.User;

@RestController
public class HomeController {

	@RequestMapping("/")
	public ResponseEntity<User> index() {
		User u =new User("mario.fts@gmail.com", "Mario Amaral");
		return ResponseEntity.ok(u);
	}
}
