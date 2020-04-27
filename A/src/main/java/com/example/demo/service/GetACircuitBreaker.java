package com.example.demo.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.ADto;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class GetACircuitBreaker extends HystrixCommand<ADto>{

	public GetACircuitBreaker(HystrixCommandGroupKey group) {
		super(group);
	}

	@Override
	public ADto run() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		
		ADto value_a = (ADto)restTemplate.exchange("http://localhost:8081/B", HttpMethod.GET,null
				,new ParameterizedTypeReference<ADto>(){}).getBody();
		
		return value_a;
	}

	@Override
	protected ADto getFallback() {
		return new ADto("x","x");
	}
}
