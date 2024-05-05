package com.gl.ticketTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.ticketTracker.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(String name);
}
