package com.emobileconnect.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.emobileconnect.repository.MobileNumberRepository;

@Service
public class MobileNumberActivationServiceImpl implements MobileNumberActivationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MobileNumberActivationServiceImpl.class);

	@Autowired
	MobileNumberRepository mobileNumberRepository;

	@Scheduled(fixedDelay = 60000)
	@Override
	public void activateMobileNumber() {

		LOGGER.info("Enabling the connection for all the valid requests");
		mobileNumberRepository.updateConnection();
	}

}
