package com.emobileconnect.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emobileconnect.entity.MobileNumber;

@Repository
public interface MobileNumberRepository extends JpaRepository<MobileNumber, Integer> {

	@Query("SELECT m.mobileNumber from MobileNumber m WHERE m.mobileStatus='available' and m.mobileNumber = :mobileNumber")
	public Optional<MobileNumber> findByMobileNumber(Long mobileNumber);

	@Transactional
	@Modifying
	@Query("UPDATE MobileNumber m SET m.mobileStatus='registered' WHERE  m.mobileNumber = :mobileNumber")
	void updateMobileNumberStatus(Long mobileNumber);

	@Transactional
	@Modifying
	@Query(value = "UPDATE emobileconnect.mobile_number set mobile_status = 'connection enabled' WHERE mobile_number in\r\n"
			+ "(SELECT mobile_number FROM(SELECT mobile_number,track_status,a.user_id from emobileconnect.user a inner join \r\n"
			+ " emobileconnect.request_track b\r\n"
			+ "on(a.user_id = b.user_id)  where track_status = 'APPROVED') as innerTable) ", nativeQuery = true)
	void updateConnection();

}
