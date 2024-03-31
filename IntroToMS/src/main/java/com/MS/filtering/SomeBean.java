package com.MS.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@JsonFilter("someBeanFilter")
public class SomeBean {

	
	String val1;
	String val2;
	String val3;
}
