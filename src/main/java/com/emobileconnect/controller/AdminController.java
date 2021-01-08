package com.emobileconnect.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emobileconnect.dto.RequestStatusUpdateDto;
import com.emobileconnect.dto.ResponseDto;
import com.emobileconnect.exception.RequestTrackException;
import com.emobileconnect.service.AdminService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {

	@Autowired
	private AdminService adminService;

	/**
	 * This method allows a person with admin role to approve/reject/refer back the
	 * track requests.
	 * 
	 * @param requestId
	 * @param requestStatusUpdateDto which includes status, admin comments and admin
	 *                               Id
	 * @return ResponseDto which includes message and status code
	 * @throws RequestTrackException -
	 */
	@PutMapping("/requests/{requestId}")
	public ResponseEntity<Optional<ResponseDto>> updateRequestStatus(@PathVariable("requestId") Integer requestId,
			@RequestBody RequestStatusUpdateDto requestStatusUpdateDto) throws RequestTrackException {

		log.info("UpdateRequestStatus Method Entered");
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(adminService.updateRequestStatus(requestId, requestStatusUpdateDto));

	}

}
