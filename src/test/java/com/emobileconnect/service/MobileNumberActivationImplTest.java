package com.emobileconnect.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import com.emobileconnect.dto.AdminRequestTrackDto;
import com.emobileconnect.entity.RequestTrack;
import com.emobileconnect.repository.RequestTrackRepository;

@RunWith(MockitoJUnitRunner.class)
public class MobileNumberActivationImplTest {

	@Mock
	ModelMapper modelMapper;

	@Mock
	RequestTrackRepository requestTrack;

	@Test
	public void testRequests() {

		// GIVEN
		List<AdminRequestTrackDto> adminRequestList = new ArrayList<>();
		/*
		 * AdminRequestTrackDto request1 = new AdminRequestTrackDto(); request1.s
		 */

		/*
		 * RequestTrack requestTrack = new RequestTrack(12,"asdasd",12,12,34,"asdasds");
		 * 
		 * requestTrack.s
		 * 
		 * adminRequestList.add(null)
		 * 
		 * 
		 * //WHEN Mockito.when(requestTrack.findAll()).then(null);
		 * 
		 * 
		 * //THEN
		 */

	}

}
