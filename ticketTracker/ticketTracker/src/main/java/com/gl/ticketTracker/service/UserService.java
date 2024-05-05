package com.gl.ticketTracker.service;

import com.gl.ticketTracker.dto.RegistrationDto;
import com.gl.ticketTracker.entity.User;

public interface UserService {

	void saveUser(RegistrationDto registrationDto);

	User findByEmail(String email);
}
