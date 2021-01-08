package com.emobileconnect.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RequestStatusUpdateDto {
	
	private String status;
	private String adminComments;
	private Integer adminId;

}
