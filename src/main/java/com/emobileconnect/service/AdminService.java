package com.emobileconnect.service;

import java.util.Optional;

import com.emobileconnect.dto.RequestStatusUpdateDto;
import com.emobileconnect.dto.ResponseDto;
import com.emobileconnect.exception.CommonException;

public interface AdminService {

	Optional<ResponseDto> updateRequestStatus(final Integer requestId,
			final RequestStatusUpdateDto requestStatusUpdateDto) throws CommonException;

}