package com.emobileconnect.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emobileconnect.dto.AdminRequestTrackDto;
import com.emobileconnect.service.RequestService;

@RestController
public class RequestController {
	
	@Autowired
	RequestService requestService;
	
	@GetMapping("/requests")
	public ResponseEntity<List<AdminRequestTrackDto>> getAllRequests(){
		
		List<AdminRequestTrackDto> requestTrackList = new ArrayList<>();
		requestTrackList = requestService.getAllRequest();
		return new ResponseEntity<List<AdminRequestTrackDto>>(requestTrackList,HttpStatus.OK);
	}
}
