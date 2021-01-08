package com.emobileconnect.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.emobileconnect.dto.AdminRequestTrackDto;
import com.emobileconnect.entity.RequestTrack;
import com.emobileconnect.repository.RequestTrackRepository;

@Service
public class RequestServiceImpl implements RequestService{

	@Autowired
	RequestTrackRepository requestTrackRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public List<AdminRequestTrackDto> getAllRequest() {
		
		List<RequestTrack> requestTrackList;
		requestTrackList = requestTrackRepository.findAll();
		List<AdminRequestTrackDto> adminRequestList = new ArrayList<>();
		requestTrackList.forEach(request -> adminRequestList.add(modelMapper.map(request, AdminRequestTrackDto.class)));		
		return adminRequestList;
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
