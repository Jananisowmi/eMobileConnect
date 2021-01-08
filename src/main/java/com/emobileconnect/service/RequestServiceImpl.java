package com.emobileconnect.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.emobileconnect.dto.AdminRequestTrackDto;
import com.emobileconnect.entity.RequestTrack;
import com.emobileconnect.exception.RequestsNotFoundException;
import com.emobileconnect.repository.RequestTrackRepository;
import com.emobileconnect.util.MobileConnectionConstants;

@Service
public class RequestServiceImpl implements RequestService{

	@Autowired
	RequestTrackRepository requestTrackRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RequestServiceImpl.class);
	
	/**
	 * Method to get all the user registration requests by admin
	 *
	 * @throws RequestsNotFoundException thrown when there are no user requests
	 * @return adminRequestList which has list of all the user requests
	 */
	@Override
	public List<AdminRequestTrackDto> getAllRequest() throws RequestsNotFoundException {
		
		LOGGER.info("Getting all requests for Admin");
		
		List<RequestTrack> requestTrackList;
		requestTrackList = requestTrackRepository.findAll();
		
		if(requestTrackList.isEmpty())
			throw new RequestsNotFoundException(MobileConnectionConstants.REQUESTS_NOT_FOUND);
		
		List<AdminRequestTrackDto> adminRequestList = new ArrayList<>();
		requestTrackList.forEach(request -> adminRequestList.add(modelMapper.map(request, AdminRequestTrackDto.class)));		
		return adminRequestList;
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
