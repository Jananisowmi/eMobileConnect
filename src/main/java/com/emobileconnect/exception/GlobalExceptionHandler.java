package com.emobileconnect.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.emobileconnect.utils.MobileConnectionConstants;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CommonException.class)
	public final ResponseEntity<ErrorResponse> commonException(Exception ex,WebRequest request) {

		ErrorResponse errorDetails = new ErrorResponse(ex.getMessage(), MobileConnectionConstants.NOT_FOUND_STATUS,
				request.getDescription(false));
		HttpStatus status = HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(errorDetails, status);

	}

}