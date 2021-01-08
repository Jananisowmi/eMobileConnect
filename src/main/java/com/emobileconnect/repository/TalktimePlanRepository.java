package com.emobileconnect.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emobileconnect.entity.TalktimePlan;

@Repository
public interface TalktimePlanRepository extends JpaRepository<TalktimePlan, Integer> {

	public Optional<TalktimePlan> findByTalktimePlanId(Integer planId);

}
