package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ADto;
import com.netflix.hystrix.HystrixCommandGroupKey;

@RestController
public class AController {
	
	@GetMapping("/A")
	public ADto getA() {
		HystrixCommandGroupKey groupKey = HystrixCommandGroupKey.Factory.asKey("group A");
		ADto value_a = new GetACircuitBreaker(groupKey).execute();
		
		return value_a;
	}
}
