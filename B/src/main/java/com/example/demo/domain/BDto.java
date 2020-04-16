package com.example.demo.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BDto {
	private String s1;
	private String s2;
	private List<String> list;
}