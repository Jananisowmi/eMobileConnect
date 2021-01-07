package com.emobileconnect.service;

import com.emobileconnect.dto.UserRegistrationRequestDto;
import com.emobileconnect.dto.UserRegistrationResponseDto;
import com.emobileconnect.exception.UserRegistrationException;

public interface UserService {

	UserRegistrationResponseDto register (UserRegistrationRequestDto userRequestDto) throws UserRegistrationException;
}
