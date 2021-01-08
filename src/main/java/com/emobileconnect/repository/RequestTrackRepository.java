package com.emobileconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emobileconnect.entity.RequestTrack;

@Repository
public interface RequestTrackRepository extends JpaRepository<RequestTrack, Integer> {

	public RequestTrack findByTrackId(Integer trackId);

}
