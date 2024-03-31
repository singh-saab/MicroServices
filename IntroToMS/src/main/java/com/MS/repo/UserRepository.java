package com.MS.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MS.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
