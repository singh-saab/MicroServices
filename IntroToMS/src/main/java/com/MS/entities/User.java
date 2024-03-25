package com.MS.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {
	
	int id;
	
	@Size(min = 2 , message="size must be of two characters")
	String name;
	
	@Past(message="please enter date in the past")
	LocalDate birthdate;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int id ,String name, LocalDate birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
}