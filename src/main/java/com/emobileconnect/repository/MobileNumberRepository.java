package com.emobileconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emobileconnect.entity.RequestTrack;

@Repository
public interface MobileNumberRepository extends JpaRepository<RequestTrack, Integer>{

	@Transactional
	@Modifying
	@Query(value = "UPDATE emobileconnect.mobile_number set mobile_status = 'connection enabled' WHERE mobile_id in\r\n"
			+ "(SELECT mobile_id FROM(SELECT mobile_id,track_status,a.user_id from emobileconnect.user a inner join \r\n"
			+ "	 emobileconnect.request_track b\r\n"
			+ "on(a.user_id = b.user_id)  where track_status = 'approved') as innerTable) ", nativeQuery = true)
	void updateConnection();
}
