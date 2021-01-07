package com.emobileconnect.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.emobileconnect.utils.Constants;

/**
 * Handle the not valid field errors along with validation messages and get the
 * list of multiple field errors.
 * 
 * @author Janani.v
 * @since 2021-01-07
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(TrackRecordNotFoundException.class)
	public final ResponseEntity<ErrorDetails> TrackRecordNotFoundException(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), Constants.NOT_FOUND_STATUS,
				request.getDescription(false));
		HttpStatus status = HttpStatus.NOT_FOUND;
		return new ResponseEntity<>(errorDetails, status);

	}

}
