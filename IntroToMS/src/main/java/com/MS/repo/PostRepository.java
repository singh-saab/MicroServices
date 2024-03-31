package com.MS.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MS.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
