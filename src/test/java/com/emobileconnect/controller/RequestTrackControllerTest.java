package com.emobileconnect.controller;

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
import com.emobileconnect.exception.TrackRecordNotFoundException;
import com.emobileconnect.service.RequestTrackService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RequestTrackControllerTest {

	@InjectMocks
	private RequestTrackController controller;

	@Mock
	private RequestTrackService service;

	@Test
	public void getTrackStatusOK() throws TrackRecordNotFoundException {
		TrackResponsedto response = new TrackResponsedto();
		response.setTrackStatus("Approved");
		response.setAdminComments("The request has been approved ");
		response.setMessage("Success");
		response.setStatusCode(200L);

		Mockito.when(service.getTrackstatus(Mockito.anyInt())).thenReturn(response);

		ResponseEntity<TrackResponsedto> controllerRespone = controller.getTrackstatus(1);

		assertEquals(response.getTrackStatus(), controllerRespone.getBody().getTrackStatus());

	}
}
