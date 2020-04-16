package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ADto {
	String s1;
	String s2;
	List<String> list;
	
	public ADto() {}
	
	public ADto(String s1, String s2) {
		this.s1 = s1;
		this.s2 = s2;
		list = new ArrayList<String>();
	}
	
	public ADto(String s1, String s2, List<String> list) {
		this.s1 = s1;
		this.s2 = s2;
		this.list = list;
	}
}