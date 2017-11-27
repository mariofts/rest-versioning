package com.elo7.rest.v1.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elo7.rest.infra.versioning.Version;
import com.elo7.rest.v1.models.User;

@RestController("HomeControllerV1")
public class HomeController {

	@RequestMapping("/homee")
	@Version("v1")
	public ResponseEntity<User> index(HttpServletRequest request) {
		System.out.println(request.getRequestURI());
		User u =new User("V1 Mario Amaral", "mario.fts@gmail.com");
		return ResponseEntity.ok(u);
	}
}
