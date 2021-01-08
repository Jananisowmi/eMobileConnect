package com.emobileconnect.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.emobileconnect.dto.TrackResponsedto;
import com.emobileconnect.entity.RequestTrack;
import com.emobileconnect.exception.TrackRecordNotFoundException;
import com.emobileconnect.repository.RequestTrackRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RequestTrackServiceTest {
	
	@InjectMocks
	private RequestTrackServiceImpl service;
	
	@Mock
	private RequestTrackRepository repository;
	
	@Test
	public void getTrackStatusOK() {
		TrackResponsedto response = getResponse();
	
		Mockito.when(repository.findByTrackId(Mockito.anyInt())).thenReturn(getTrackResponse());
		TrackResponsedto actualResponse = service.getTrackstatus(1);
		assertEquals(response.getTrackStatus(), actualResponse.getTrackStatus());
		
	}
	
	@Test(expected = TrackRecordNotFoundException.class)
	public void getTractStatusException() {
		TrackResponsedto response = getResponse();
		
		Mockito.when(repository.findByTrackId(Mockito.anyInt())).thenReturn(null);
		TrackResponsedto actualResponse = service.getTrackstatus(1);
		
	}

	private RequestTrack getTrackResponse() {
		RequestTrack trackResponse = new RequestTrack();
		trackResponse.setTrackStatus("Approved");
		trackResponse.setAdminComments("The request has been approved");
		return trackResponse;
	}
	
	
	

	private TrackResponsedto getResponse() {
		TrackResponsedto response = new TrackResponsedto();
		RequestTrack trackResponse = getTrackResponse();
		response.setTrackStatus(trackResponse.getTrackStatus());
		response.setAdminComments(trackResponse.getAdminComments());
		response.setMessage("Success");
		response.setStatusCode(200L);
		
		return response;
	}

}
