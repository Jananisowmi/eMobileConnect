package com.emobileconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.emobileconnect.repository.MobileNumberRepository;

@Service
public class MobileNumberActivationImpl implements MobileNumberActivation{

	@Autowired
	MobileNumberRepository mobileNumberRepository;
	
	@Scheduled(fixedDelay = 60000)
	@Override
	public void activateMobileNumber() {
		
		mobileNumberRepository.updateConnection();
	}

}
