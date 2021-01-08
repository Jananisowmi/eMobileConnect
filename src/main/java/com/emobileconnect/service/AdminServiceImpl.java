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

		adminRepository.findById(requestStatusUpdateDto.getAdminId())
				.orElseThrow(() -> new CommonException("Invalid Admin Credentials"));

		try {
			ConnectionStatusEnum.valueOf(requestStatusUpdateDto.getStatus());
		} catch (Exception e) {
			throw new CommonException("Invalid Status");
		}

		return requestTrackRepository.findById(requestId).map(request -> {

			request.setAdminComments(requestStatusUpdateDto.getAdminComments());
			request.setAdminId(requestStatusUpdateDto.getAdminId());
			request.setTrackStatus(requestStatusUpdateDto.getStatus());

			requestTrackRepository.save(request);

			return Optional.ofNullable(
					ResponseDto.builder().message("Connection Approved Successfully").statusCode("200").build());
		}).orElseThrow(() -> new CommonException("Invalid Request Id"));

	}

}
