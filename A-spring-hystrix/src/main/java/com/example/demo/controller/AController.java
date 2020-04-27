package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ADto;
import com.example.demo.service.GetACircuitBreaker;

@RestController
public class AController {
	
	@Autowired
	GetACircuitBreaker getACircuitBreaker;
	
	@GetMapping("/A")
	public ADto getA() {
		ADto value_a = getACircuitBreaker.getA();
		
		return value_a;
	}
}