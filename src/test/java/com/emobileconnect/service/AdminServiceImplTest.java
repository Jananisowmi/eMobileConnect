package com.emobileconnect.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.emobileconnect.dto.RequestStatusUpdateDto;
import com.emobileconnect.dto.ResponseDto;
import com.emobileconnect.entity.Admin;
import com.emobileconnect.entity.RequestTrack;
import com.emobileconnect.exception.RequestTrackException;
import com.emobileconnect.repository.AdminRepository;
import com.emobileconnect.repository.RequestTrackRepository;

@ExtendWith(MockitoExtension.class)
public class AdminServiceImplTest {

	@Mock
	private AdminRepository adminRepository;

	@Mock
	private RequestTrackRepository requestTrackRepository;

	@InjectMocks
	private AdminServiceImpl adminServiceImpl;

	private RequestStatusUpdateDto requestStatusUpdateDto ;
	private Admin admin;
	private RequestTrack request;
	private static final Integer REQUEST_ID = 1;
	
	@BeforeEach
	public void setUp() {
		
		requestStatusUpdateDto = RequestStatusUpdateDto.builder().adminComments("OK").adminId(1)
				.status("APPROVED").build();
		admin = Admin.builder().adminId(1).adminName("Admin1").mobileNumber(9872635412L).build();
		request = RequestTrack.builder().trackId(1).trackStatus("INPROGRESS").talktimePlanId(1).userId(1).build();
		
	}
	
	@Test
	public void testupdateRequestStatus() throws RequestTrackException {
		when(adminRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(admin));
		when(requestTrackRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(request));
		
		Optional<ResponseDto> response = adminServiceImpl.updateRequestStatus(REQUEST_ID, requestStatusUpdateDto);
		
		assertNotNull(response);
	}
	
	@Test
	public void testupdateRequestStatusInvalidAdminId() throws RequestTrackException {
		when(adminRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		
		Optional<ResponseDto> response = adminServiceImpl.updateRequestStatus(REQUEST_ID, requestStatusUpdateDto);
		
		  Assertions.assertThrows(RequestTrackException.class, () -> response.get());
	}
	
	@Test
	public void testupdateRequestStatusInvalidRequestId() throws RequestTrackException {
		when(adminRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(admin));
		when(requestTrackRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		
		Optional<ResponseDto> response = adminServiceImpl.updateRequestStatus(REQUEST_ID, requestStatusUpdateDto);
		
		Assertions.assertThrows(RequestTrackException.class, () -> response.get());
		
	}
	
	@Test
	public void testupdateRequestStatusInvalidStatus() throws RequestTrackException {
		when(adminRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(admin));
		when(requestTrackRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(request));
		
		requestStatusUpdateDto.setStatus("ACTIVE");
		
		Optional<ResponseDto> response = adminServiceImpl.updateRequestStatus(REQUEST_ID, requestStatusUpdateDto);
		
		Assertions.assertThrows(RequestTrackException.class, () -> response.get());
		
	}
	
	
}
