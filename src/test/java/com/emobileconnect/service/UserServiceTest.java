package com.emobileconnect.service;

import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

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

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@Mock
	UserRepository userRepository;

	@Mock
	TalktimePlanRepository planRepository;

	@Mock
	MobileNumberRepository mobileNumberRepository;

	@Mock
	RequestTrackRepository requestTrackRepository;

	@InjectMocks
	UserServiceImpl userServiceImpl;

	UserRegistrationRequestDto userRegisterRequest = new UserRegistrationRequestDto();
	UserRegistrationResponseDto userResponse = new UserRegistrationResponseDto();

	User user = new User();
	TalktimePlan plan = new TalktimePlan();
	MobileNumber number = new MobileNumber();
	RequestTrack requestTrack = new RequestTrack();

	@Before
	public void setup() {
		user.setUserName("swethi");
		user.setMobileNumber(785659759L);
		user.setAadharNumber(782782739181L);
		user.setAddress("chennai");
		user.setState("Tamilnadu");
		user.setUserId(1);
		user.setEmailId("k@gmail.com");

		plan.setTalktimePlanId(8);
		plan.setPlanDescription("calls only");
		plan.setPlanType("calls");
		plan.setPrice(499.0);
		plan.setTalktimeRange("unlimited");
		plan.setValidity(28);

		requestTrack.setTrackStatus("Registration Initiated");
		requestTrack.setUserId(1);
		requestTrack.setTalktimePlanId(5);
		requestTrack.setAdminComments("Review pending");

		userRegisterRequest.setEmailId("s@g.com");
		userRegisterRequest.setMobileNumber(8884148999L);
		userRegisterRequest.setAadharNumber(384847368474L);
		userRegisterRequest.setAddress("madurai");
		userRegisterRequest.setPlanId(6);
		userRegisterRequest.setState("TamilNadu");
		userRegisterRequest.setUserName("swathi");

		userResponse.setTrackId(1);
		userResponse.setMessage("Success");
		userResponse.setStatusCode(201);
	}

	@Test
	public void testRegister() throws UserRegistrationException {
		Optional<TalktimePlan> optPlan = Optional.of(plan);
		optPlan.isPresent();
		Optional<MobileNumber> optNumber = Optional.of(number);
		optNumber.isPresent();
		Mockito.when(planRepository.findByTalktimePlanId(Mockito.anyInt())).thenReturn(optPlan);
		Mockito.when(mobileNumberRepository.findByMobileNumber(Mockito.anyLong())).thenReturn(optNumber);
		Mockito.when(userRepository.save(Mockito.any())).thenReturn(user);
		Mockito.when(requestTrackRepository.save(Mockito.any())).thenReturn(requestTrack);
		UserRegistrationResponseDto userRegisterResponseDto = userServiceImpl.register(userRegisterRequest);
		Assert.assertNotNull(userRegisterResponseDto.getStatusCode());
	}

	@Test(expected = UserRegistrationException.class)
	public void testUserRegistrationException() throws UserRegistrationException {
		userRegisterRequest.setEmailId("de3gmail.com");
		userRegisterRequest.setAadharNumber(9867L);
		userRegisterRequest.setMobileNumber(84973L);
		userRegisterRequest.setPlanId(0);
		userRegisterRequest.setState("56hj");
		userRegisterRequest.setUserName("hw62");
		UserRegistrationResponseDto userRegResDTO = userServiceImpl.register(userRegisterRequest);
		assertNotNull(userRegResDTO);
	}

}
