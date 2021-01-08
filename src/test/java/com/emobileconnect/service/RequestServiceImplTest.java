package com.emobileconnect.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import com.emobileconnect.dto.AdminRequestTrackDto;
import com.emobileconnect.entity.RequestTrack;
import com.emobileconnect.repository.RequestTrackRepository;

@RunWith(MockitoJUnitRunner.class) 
public class RequestServiceImplTest {

	@Mock
	ModelMapper modelMapper;

	@Mock
	RequestTrackRepository requestTrackRepo;
	
	@InjectMocks
	RequestServiceImpl requestServiceImpl;

	AdminRequestTrackDto requestDto ;
	RequestTrack requestTrack;
	List<AdminRequestTrackDto> adminRequesDtotList;
	List<RequestTrack> requesTrack;

	@Before
	public void init() {

		requestDto = new AdminRequestTrackDto("validated",12,"approved");
		requestTrack = new RequestTrack(1,"validated",12,43,23,"approved");

		requesTrack = new ArrayList<>();
		requesTrack.add(requestTrack);
	}

	@Test
	public void testRequests() {

		//WHEN 
		Mockito.when(requestTrackRepo.findAll()).thenReturn(requesTrack);
		Mockito.when(modelMapper.map(requestTrack,AdminRequestTrackDto.class)).thenReturn(requestDto);
		List<AdminRequestTrackDto> actual = requestServiceImpl.getAllRequest();
		
		//THEN
		assertEquals(adminRequesDtotList.size(), actual.size());
		
	}

}
