package com.emobileconnect.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emobileconnect.dto.TrackResponsedto;
import com.emobileconnect.entity.RequestTrack;
import com.emobileconnect.exception.TrackRecordNotFoundException;
import com.emobileconnect.repository.RequestTrackRepository;
import com.emobileconnect.utils.Constants;

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

	@Override
	public TrackResponsedto getTrackstatus(Integer trackId) {
		TrackResponsedto response = new TrackResponsedto();
		RequestTrack track = requestTrackRepository.findByTrackId(trackId);

		if (!Optional.ofNullable(track).isPresent()) {
			throw new TrackRecordNotFoundException(Constants.TRACK_NOT_FOUND);
		}

		response.setTrackStatus(track.getTrackStatus());
		response.setAdminComments(track.getAdminComments());
		response.setMessage(Constants.SUCCESS_MESSAGE);
		response.setStatusCode(Constants.OK_STATUS);
		return response;

	}

}
