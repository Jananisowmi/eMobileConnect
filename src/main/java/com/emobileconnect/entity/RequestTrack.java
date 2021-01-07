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

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="request_track")
public class RequestTrack {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer trackId;
	private String trackStatus;
	private Integer userId;
	private Integer talktimePlanId;
	private Integer adminId;
	private String  adminComments;

}
