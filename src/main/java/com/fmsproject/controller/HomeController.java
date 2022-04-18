package com.fmsproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/p1")
public class HomeController {

	@GetMapping
	public String getHomeResponse() {
		return "Welcome to the Feedback Management System";
	}
}
