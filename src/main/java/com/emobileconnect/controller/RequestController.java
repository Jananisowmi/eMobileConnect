package com.emobileconnect.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emobileconnect.dto.AdminRequestTrackDto;
import com.emobileconnect.exception.RequestTrackException;
import com.emobileconnect.service.RequestService;

@RestController
public class RequestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RequestController.class);

	@Autowired
	RequestService requestService;

	@GetMapping("/requests")
	public ResponseEntity<List<AdminRequestTrackDto>> getAllRequests() throws RequestTrackException {

		LOGGER.info("Inside controller for getting all user requests for admin");
		List<AdminRequestTrackDto> requestTrackList;
		requestTrackList = requestService.getAllRequest();
		return new ResponseEntity<List<AdminRequestTrackDto>>(requestTrackList, HttpStatus.OK);
	}
}
