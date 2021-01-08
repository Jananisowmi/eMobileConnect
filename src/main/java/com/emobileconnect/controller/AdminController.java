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
import com.emobileconnect.exception.CommonException;
import com.emobileconnect.service.AdminService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	@PutMapping("/requests/{requestId}")
	public ResponseEntity<Optional<ResponseDto>> updateConnectionStatus(@PathVariable("requestId") Integer requestId,
			@RequestBody RequestStatusUpdateDto requestStatusUpdateDto) throws CommonException{

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(adminService.updateRequestStatus(requestId, requestStatusUpdateDto));

	}

}
