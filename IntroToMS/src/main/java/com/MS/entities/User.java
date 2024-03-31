package com.MS.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "user_details")
public class User {
	
	@Id
	@GeneratedValue
	int id;
	
	@Size(min = 2 , message="size must be of two characters")
	@NotNull(message="name should not be null")
	String name;
	
	@Past(message="please enter date in the past")
	@NotNull(message="birthdate should not be null")
	LocalDate birthdate;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	List<Post>posts;

	public User(int id,
			@Size(min = 2, message = "size must be of two characters") @NotNull(message = "name should not be null") String name,
			@Past(message = "please enter date in the past") @NotNull(message = "birthdate should not be null") LocalDate birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}
	
	
}
