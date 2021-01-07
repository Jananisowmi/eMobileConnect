package com.emobileconnect.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emobileconnect.dto.RequestStatusUpdateDto;
import com.emobileconnect.dto.ResponseDto;
import com.emobileconnect.entity.RequestTrack;
import com.emobileconnect.exception.CommonException;
import com.emobileconnect.repository.AdminRepository;
import com.emobileconnect.repository.RequestTrackRepository;
import com.emobileconnect.utils.ConnectionStatusEnum;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	RequestTrackRepository requestTrackRepository;

	@Override
	public Optional<ResponseDto> updateRequestStatus(Integer requestId, RequestStatusUpdateDto requestStatusUpdateDto)
			throws CommonException {

		if (!adminRepository.findById(requestStatusUpdateDto.getAdminId()).isPresent()) {
			throw new CommonException("Invalid admin credentials");
		}

		Optional<RequestTrack> request = requestTrackRepository.findById(requestId);

		if (!request.isPresent()) {
			throw new CommonException("Invalid requestId credentials");
		}

		try {
			ConnectionStatusEnum.valueOf(requestStatusUpdateDto.getStatus());
		} catch (Exception e) {
			throw new CommonException("Invalid Status");
		}
		
		request.get().setAdminComments(requestStatusUpdateDto.getAdminComments());
		request.get().setAdminId(requestStatusUpdateDto.getAdminId());
		request.get().setTrackStatus(requestStatusUpdateDto.getStatus());
		
		requestTrackRepository.save(request.get());
		
		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage("connection approved successfully");
		responseDto.setStatusCode("200");
		return Optional.of(responseDto);
	}

}
