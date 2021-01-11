package com.emobileconnect.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.emobileconnect.dto.UserRegistrationRequestDto;
import com.emobileconnect.dto.UserRegistrationResponseDto;
import com.emobileconnect.entity.MobileNumber;
import com.emobileconnect.entity.RequestTrack;
import com.emobileconnect.entity.TalktimePlan;
import com.emobileconnect.entity.User;
import com.emobileconnect.exception.UserRegistrationException;
import com.emobileconnect.repository.MobileNumberRepository;
import com.emobileconnect.repository.RequestTrackRepository;
import com.emobileconnect.repository.TalktimePlanRepository;
import com.emobileconnect.repository.UserRepository;
import com.emobileconnect.utils.ConnectionStatusEnum;
import com.emobileconnect.utils.MobileConnectionConstants;
import com.emobileconnect.utils.Validator;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RequestTrackRepository requestTrackRepository;

	@Autowired
	TalktimePlanRepository talktimePlanRepository;

	@Autowired
	MobileNumberRepository mobileNumberRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	/**
	 * This method will register the users requesting for new mobile Connection
	 * 
	 * @param UserRegistrationRequestDto
	 * 
	 * @throws UserRegistrationException thrown when registration fails
	 * @return UserRegistrationResponseDto which includes track id,success code,
	 *         success/failure message.
	 */
	@Override
	public UserRegistrationResponseDto register(UserRegistrationRequestDto userRequestDto)
			throws UserRegistrationException {

		LOGGER.info("register method in UserService started");

		if (!new Validator().validateUserName(userRequestDto.getUserName()))
			throw new UserRegistrationException(MobileConnectionConstants.INVALID_USER_NAME);

		if (!new Validator().validateStateName(userRequestDto.getState()))
			throw new UserRegistrationException(MobileConnectionConstants.INVALID_STATE_DECLARATION);

		if (!new Validator().validateEmail(userRequestDto.getEmailId()))
			throw new UserRegistrationException(MobileConnectionConstants.INVALID_EMAIL_ID);

		if (!new Validator().validateMobileNumber(userRequestDto.getMobileNumber()))
			throw new UserRegistrationException(MobileConnectionConstants.INVALID_MOBILE_NUMBER);

		if (!new Validator().validateAadharNumber(userRequestDto.getAadharNumber())) {
			throw new UserRegistrationException(MobileConnectionConstants.INVALID_ADHAR_NUMBER);
		}

		User checkUserEmail = userRepository.findByEmailId(userRequestDto.getEmailId());
		if (checkUserEmail != null) {
			throw new UserRegistrationException(MobileConnectionConstants.EMAIL_ALREADY_EXISTS);
		}

		User checkUserAadharNumber = userRepository.findByAadharNumber(userRequestDto.getAadharNumber());
		if (checkUserAadharNumber != null) {
			throw new UserRegistrationException(MobileConnectionConstants.ADHAR_NUMBER_ALREADY_EXISTS);
		}

		Optional<TalktimePlan> checkTalktimePlan = talktimePlanRepository
				.findByTalktimePlanId(userRequestDto.getPlanId());
		if (!checkTalktimePlan.isPresent()) {
			throw new UserRegistrationException(MobileConnectionConstants.NO_PLAN_EXISTS);
		}

		Optional<MobileNumber> checkAvailableNumber = mobileNumberRepository
				.findByMobileNumber(userRequestDto.getMobileNumber());
		if (!checkAvailableNumber.isPresent()) {
			throw new UserRegistrationException(MobileConnectionConstants.NO_MOBILE_NUMBER_EXISTS);
		} else {
			mobileNumberRepository.updateMobileNumberStatus(userRequestDto.getMobileNumber());
		}

		User user = new User();
		BeanUtils.copyProperties(userRequestDto, user);
		User userResponse = userRepository.save(user);

		RequestTrack requestTrack = new RequestTrack();
		requestTrack.setTrackStatus(ConnectionStatusEnum.INPROGRESS.name());
		requestTrack.setUserId(userResponse.getUserId());
		requestTrack.setTalktimePlanId(userRequestDto.getPlanId());
		RequestTrack trackOrder = requestTrackRepository.save(requestTrack);

		UserRegistrationResponseDto userResponseDto = new UserRegistrationResponseDto();
		userResponseDto.setTrackId(trackOrder.getTrackId());
		userResponseDto.setStatusCode(HttpStatus.CREATED.value());
		userResponseDto.setMessage(MobileConnectionConstants.REGISTRATION_SUCCESS_MESSAGE);
		return userResponseDto;
	}

}
