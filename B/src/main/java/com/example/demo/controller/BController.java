package com.example.demo.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.BDto;

@RestController
public class BController {
	
	@GetMapping("/B")
	public BDto getB() {
		return new BDto("o","o",Arrays.asList("hello","world"));
	}
}
