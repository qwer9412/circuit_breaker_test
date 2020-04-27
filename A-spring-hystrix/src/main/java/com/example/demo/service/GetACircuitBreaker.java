package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.ADto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class GetACircuitBreaker {
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@GetMapping("/A")
	@HystrixCommand(fallbackMethod = "getFallback")
	public ADto getA() {
		
		ADto value_a = (ADto)restTemplate.exchange("http://localhost:8081/B", HttpMethod.GET,null
				,new ParameterizedTypeReference<ADto>(){}).getBody();
		
		return value_a;
	}

	public ADto getFallback() {
		return new ADto("x","x");
	}
}
