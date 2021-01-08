package com.emobileconnect.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * * The RequestTrack class is a pojo class that has 6 fields related to request
 * tracking for users
 * 
 * @author Janani
 * @since 2021-01-07
 *
 */
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "request_track")
public class RequestTrack {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trackId;
	private String trackStatus;
	private Integer userId;
	private Integer talktimePlanId;
	private Integer adminId;
	private String adminComments;

}
