package com.emobileconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emobileconnect.entity.RequestTrack;

@Repository
public interface RequestTrackRepository extends JpaRepository<RequestTrack, Integer>{

	//@Query(value = "SELECT user_id,track_status,admin_comments FROM emobileconnect.request_track", nativeQuery = true)
	List<RequestTrack> findAll();
}
