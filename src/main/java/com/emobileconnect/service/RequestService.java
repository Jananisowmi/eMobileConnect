package com.emobileconnect.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emobileconnect.dto.AdminRequestTrackDto;

@Service
public interface RequestService {

	public List<AdminRequestTrackDto> getAllRequest();
}