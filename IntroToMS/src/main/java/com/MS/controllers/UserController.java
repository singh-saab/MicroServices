package com.MS.controllers;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.MS.dao.UserDao;
import com.MS.entities.User;
import com.MS.exceptions.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	UserDao dao;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path="/users")
	List<User>getUsers(){
		return dao.getUsers();
	}
	
	
	
	@GetMapping(path="/users/{id}")
	EntityModel<User> getUser(@PathVariable int id) {
		User user = dao.getUser(id);
		
		if(user==null) {
			throw new UserNotFoundException("User with id " + id + " is not present");
		}
		
		EntityModel<User> newUser = EntityModel.of(user);
		WebMvcLinkBuilder links =  linkTo(methodOn(this.getClass()).getUsers());
		newUser.add(links.withRel("all-users"));
		return newUser;
	}
	
	@PostMapping(path="/users")
	ResponseEntity<User> CreateUser(@Valid @RequestBody User user) {
		 User savedUser = dao.createUser(user);
		 URI location = ServletUriComponentsBuilder
				 .fromCurrentRequest()
				 .path("/{id}")
				 .buildAndExpand(savedUser.getId()).toUri();
		 return ResponseEntity.created(location).body(savedUser);
		
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		dao.deleteUser(id);
	}
	
	@GetMapping("/hello")
	public String hello() {
		Locale locale = LocaleContextHolder.getLocale();
		System.out.println(messageSource.getMessage("good.morning.message",null,"blank", locale));
		return messageSource.getMessage("good.morning.message", null, "blank message", locale);
	}

}
