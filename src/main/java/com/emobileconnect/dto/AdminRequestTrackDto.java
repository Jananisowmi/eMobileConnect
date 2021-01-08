package com.emobileconnect.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminRequestTrackDto {

	private String trackStatus;
	private Integer userId;
	private String  adminComments;
}
