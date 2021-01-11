package com.emobileconnect.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emobileconnect.dto.TrackResponsedto;
import com.emobileconnect.entity.RequestTrack;
import com.emobileconnect.exception.TrackRecordNotFoundException;
import com.emobileconnect.repository.RequestTrackRepository;
import com.emobileconnect.utils.MobileConnectionConstants;

/**
 * Get the Request track status - business logic
 * 
 * @author Janani.V
 * @since 2021-01-07
 * @version V1.1
 *
 */
@Service
public class RequestTrackServiceImpl implements RequestTrackService {

	@Autowired
	RequestTrackRepository requestTrackRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(RequestTrackServiceImpl.class);

	@Override
	public TrackResponsedto getTrackstatus(Integer trackId) throws TrackRecordNotFoundException {
		LOGGER.info("Getting the track status for trackID ");
		TrackResponsedto response = new TrackResponsedto();
		RequestTrack track = requestTrackRepository.findByTrackId(trackId);

		if (!Optional.ofNullable(track).isPresent()) {
			throw new TrackRecordNotFoundException(MobileConnectionConstants.TRACK_NOT_FOUND);
		}

		response.setTrackStatus(track.getTrackStatus());
		response.setAdminComments(track.getAdminComments());
		response.setMessage(MobileConnectionConstants.SUCCESS_MESSAGE);
		response.setStatusCode(MobileConnectionConstants.OK_STATUS);
		return response;

	}

}
