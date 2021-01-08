package com.emobileconnect.exception;

/**
 * TrackRecordNotFoundException - handle the requestTrack not found exception in
 * this custom exception class
 * 
 * @author Janani.V
 * @version V1.1
 * @since 2021-01-07
 *
 */
public class TrackRecordNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TrackRecordNotFoundException(String message) {
		super(message);

	}

}