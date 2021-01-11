package com.emobileconnect.service;

import com.emobileconnect.dto.TrackResponsedto;
import com.emobileconnect.exception.TrackRecordNotFoundException;

public interface RequestTrackService {

	public TrackResponsedto getTrackstatus(Integer trackId) throws TrackRecordNotFoundException;
	
	

}
