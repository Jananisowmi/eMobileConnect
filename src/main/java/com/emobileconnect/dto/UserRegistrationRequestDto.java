package com.emobileconnect.dto;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationRequestDto {

	private String userName;
	private String address;
	private String state;
	private Long aadharNumber;
	private Long mobileNumber;
	private Integer planId;
	@Column(unique = true)
	private String emailId;
}
