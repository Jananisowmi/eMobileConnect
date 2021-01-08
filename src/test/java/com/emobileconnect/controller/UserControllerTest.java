package com.emobileconnect.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.emobileconnect.dto.UserRegistrationRequestDto;
import com.emobileconnect.dto.UserRegistrationResponseDto;
import com.emobileconnect.exception.UserRegistrationException;
import com.emobileconnect.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	@Mock
	UserService userService;

	@InjectMocks
	UserController userController;

	UserRegistrationRequestDto userRegisterRequest = new UserRegistrationRequestDto();
	UserRegistrationResponseDto userResponse = new UserRegistrationResponseDto();

	@Before
	public void setup() {
		userRegisterRequest.setEmailId("s@gmail.com");
		userRegisterRequest.setMobileNumber(8884148999L);
		userRegisterRequest.setAadharNumber(384847368474L);
		userRegisterRequest.setAddress("madurai");
		userRegisterRequest.setPlanId(1);
		userRegisterRequest.setState("TamilNadu");
		userRegisterRequest.setUserName("swathi");

		userResponse.setTrackId(1);
		userResponse.setMessage("Success");
		userResponse.setStatusCode(201);

	}

	@Test
	public void testRegister() throws UserRegistrationException {

		Mockito.when(userService.register(Mockito.any())).thenReturn(userResponse);
		ResponseEntity<UserRegistrationResponseDto> actual = userController.register(userRegisterRequest);
		ResponseEntity<UserRegistrationResponseDto> expected = new ResponseEntity<UserRegistrationResponseDto>(
				userResponse, HttpStatus.CREATED);
		assertEquals(expected.getStatusCode().value(), actual.getStatusCodeValue());

	}
}
