package com.emobileconnect.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDetails {

	private String message;
	private Long statusCode;
	@JsonIgnore
	private String details;

}