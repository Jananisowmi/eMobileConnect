package com.emobileconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.emobileconnect.dto.TrackResponsedto;
import com.emobileconnect.service.RequestTrackService;

/**
 * Get the Request track status
 * 
 * @author Janani.V
 * @since 2021-01-07
 * @version V1.1
 *
 */
@RestController
public class RequestTrackController {

	@Autowired
	RequestTrackService requestTrackService;

	@GetMapping("/requests/{requestId}")
	public ResponseEntity<TrackResponsedto> getTrackstatus(@PathVariable("requestId") Integer trackId) {
		TrackResponsedto response = requestTrackService.getTrackstatus(trackId);
		return new ResponseEntity<TrackResponsedto>(response, HttpStatus.OK);

	}

}
