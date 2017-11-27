package com.elo7.rest.v2.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elo7.rest.infra.versioning.Version;
import com.elo7.rest.v1.models.User;

@RestController
public class HomeController {

	@RequestMapping("/homee")
	@Version("v2")
	public ResponseEntity<User> index() {
		User u =new User("V2 Mario Amaral", "mario.fts@gmail.com");
		return ResponseEntity.ok(u);
	}
}
