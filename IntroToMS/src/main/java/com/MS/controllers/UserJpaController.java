package com.MS.controllers;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

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
import com.MS.entities.Post;
import com.MS.entities.User;
import com.MS.exceptions.UserNotFoundException;
import com.MS.repo.PostRepository;
import com.MS.repo.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaController {

	@Autowired
	UserRepository userRepo;

	@Autowired
	PostRepository postRepo;

	@Autowired
	private MessageSource messageSource;

	@GetMapping(path = "/jpa/users")
	List<User> getUsers() {
		return userRepo.findAll();
	}

	@GetMapping(path = "/jpa/users/{id}")
	EntityModel<User> getUser(@PathVariable int id) {
		Optional<User> user = userRepo.findById(id);

		if (user.isEmpty()) {
			throw new UserNotFoundException("User with id " + id + " is not present");
		}

		EntityModel<User> newUser = EntityModel.of(user.get());
		WebMvcLinkBuilder links = linkTo(methodOn(this.getClass()).getUsers());
		newUser.add(links.withRel("all-users"));
		return newUser;
	}

	@GetMapping(path = "/jpa/users/{id}/posts")
	List<Post> getPostsOfUser(@PathVariable int id) {
		Optional<User> user = userRepo.findById(id);

		if (user.isEmpty()) {
			throw new UserNotFoundException("User with id " + id + " is not present");
		}

		return user.get().getPosts();
	}

	@PostMapping(path = "/jpa/users")
	ResponseEntity<User> CreateUser(@Valid @RequestBody User user) {

		User savedUser = userRepo.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).body(savedUser);

	}

	@PostMapping(path = "/jpa/users/{id}/posts")
	ResponseEntity<Post> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post) {

		Optional<User> user = userRepo.findById(id);

		if (user.isEmpty()) {
			throw new UserNotFoundException("User with id " + id + " is not present");
		}
			
		post.setUser(user.get());
		Post savedPost = postRepo.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId())
				.toUri();
		return ResponseEntity.created(location).body(savedPost);

	}
	
	
	

	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepo.deleteById(id);
	}



}
