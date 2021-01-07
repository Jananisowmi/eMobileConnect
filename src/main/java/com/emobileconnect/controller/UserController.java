package com.emobileconnect.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emobileconnect.dto.UserRegistrationRequestDto;
import com.emobileconnect.dto.UserRegistrationResponseDto;
import com.emobileconnect.exception.UserRegistrationException;
import com.emobileconnect.service.UserService;

@RestController
public class UserController {	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;

	/**
	 * This method will register the users requesting for new mobile Connection
	 * 
	 * @param UserRegistrationRequestDto
	 * 
	 * @throws UserRegistrationException thrown when registration fails
	 * @return UserRegistrationResponseDto which includes track id,success code, success/failure message.
	 */
	@PostMapping("/users/newRequest")
	public ResponseEntity<UserRegistrationResponseDto> register(@RequestBody UserRegistrationRequestDto userRequestDto)
			throws UserRegistrationException {
		LOGGER.info("register method in UserController started");
		UserRegistrationResponseDto userResponseDto = userService.register(userRequestDto);
		return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
	}
}
