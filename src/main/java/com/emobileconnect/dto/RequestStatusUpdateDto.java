package com.emobileconnect.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestStatusUpdateDto {
	
	private String status;
	private String adminComments;
	private Integer adminId;

}
