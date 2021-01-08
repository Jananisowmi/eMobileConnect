package com.emobileconnect.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emobileconnect.dto.RequestStatusUpdateDto;
import com.emobileconnect.dto.ResponseDto;
import com.emobileconnect.exception.RequestTrackException;
import com.emobileconnect.repository.AdminRepository;
import com.emobileconnect.repository.RequestTrackRepository;
import com.emobileconnect.utils.ConnectionStatusEnum;

/**
 * 
 * @author Afrin
 * @version V1.1
 *
 */
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	RequestTrackRepository requestTrackRepository;

	@Override
	public Optional<ResponseDto> updateRequestStatus(Integer requestId, RequestStatusUpdateDto requestStatusUpdateDto)
			throws RequestTrackException {

		adminRepository.findById(requestStatusUpdateDto.getAdminId())
				.orElseThrow(() -> new RequestTrackException("Invalid Admin Credentials"));

		try {
			ConnectionStatusEnum.valueOf(requestStatusUpdateDto.getStatus());
		} catch (Exception e) {
			throw new RequestTrackException("Invalid Status");
		}

		return requestTrackRepository.findById(requestId).map(request -> {

			request.setAdminComments(requestStatusUpdateDto.getAdminComments());
			request.setAdminId(requestStatusUpdateDto.getAdminId());
			request.setTrackStatus(requestStatusUpdateDto.getStatus());

			requestTrackRepository.save(request);

			return Optional.ofNullable(
					ResponseDto.builder().message("Connection Approved Successfully").statusCode("200").build());
		}).orElseThrow(() -> new RequestTrackException("Invalid Request Id"));

	}

}
