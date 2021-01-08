package com.emobileconnect.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	private static final String EMAIL_VALIDATION = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
	private static final String MOBILE_VALIDATION = "^[0-9]{10}$";
	private static final String ADHAR_VALIDATION = "^[0-9]{12}$";
	private static final String NAME_VALIDATION = "^[a-zA-Z]*$";

	Pattern pattern;
	Matcher matcher;

	/**
	 * This method validates the input email address
	 * 
	 * @param email
	 * @return boolean
	 */
	public boolean validateEmail(String email) {
		pattern = Pattern.compile(EMAIL_VALIDATION, Pattern.CASE_INSENSITIVE);
		matcher = pattern.matcher(email);
		return (matcher.find() && matcher.group().equals(email));
	}

	/**
	 * This method validates the input mobile number
	 * 
	 * @param number
	 * @return boolean
	 */
	public boolean validateMobileNumber(Long number) {
		String num = number.toString();
		pattern = Pattern.compile(MOBILE_VALIDATION);
		matcher = pattern.matcher(num);
		return (matcher.find() && matcher.group().equals(num));
	}

	/**
	 * This method validates the input aadhar number
	 * 
	 * @param aadharNumber
	 * @return boolean
	 */
	public boolean validateAadharNumber(Long aadharNumber) {
		String num = aadharNumber.toString();
		pattern = Pattern.compile(ADHAR_VALIDATION);
		matcher = pattern.matcher(num);
		return (matcher.find() && matcher.group().equals(num));
	}

	/**
	 * This method validates the input user name
	 * 
	 * @param userName
	 * @return boolean
	 */
	public boolean validateUserName(String userName) {
		String name = (NAME_VALIDATION);
		return userName.matches(name);
	}

	/**
	 * This method validates the input state name
	 * 
	 * @param state
	 * @return boolean
	 */
	public boolean validateStateName(String state) {
		String name = (NAME_VALIDATION);
		return state.matches(name);
	}

}