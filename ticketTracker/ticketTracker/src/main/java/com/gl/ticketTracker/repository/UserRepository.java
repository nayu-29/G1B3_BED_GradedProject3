package com.gl.ticketTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.ticketTracker.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
