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

}