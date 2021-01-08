package com.emobileconnect.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.emobileconnect.dto.TrackResponsedto;
import com.emobileconnect.exception.TrackRecordNotFoundException;
import com.emobileconnect.exception.UserRegistrationException;
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

	
	private static final Logger LOGGER = LoggerFactory.getLogger(RequestTrackController.class);
	
	@Autowired
	RequestTrackService requestTrackService;
	
	/**
	 * This method will return the Tracking status of the request made by user  for mobile connection
	 * 
	 * @PathVariable trackId
	 * 
	 * @throws TrackRecordNotFoundException thrown when the record not found
	 * @return TrackResponsedto which includes track status, admin comments,success code, success/failure message.
	 */

	@GetMapping("/requests/{requestId}")
	public ResponseEntity<TrackResponsedto> getTrackstatus(@PathVariable("requestId") Integer trackId) throws TrackRecordNotFoundException {
		LOGGER.info("The user tracking ID "+trackId);
		TrackResponsedto response = requestTrackService.getTrackstatus(trackId);
		return new ResponseEntity<TrackResponsedto>(response, HttpStatus.OK);

	}

}
