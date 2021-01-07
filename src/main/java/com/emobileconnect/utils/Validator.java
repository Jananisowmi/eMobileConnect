package com.emobileconnect.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	
	private static final String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

	Pattern pattern;
	Matcher matcher;

	/**
	 * This method validates the input email address
	 * 
	 * @param email
	 * @return boolean
	 */
	public boolean validateEmail(String email) {
		pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
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
		pattern = Pattern.compile("^[0-9]{10}$");
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
		pattern = Pattern.compile("^[0-9]{12}$");
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
		String name = ("^[a-zA-Z]*$");
		return userName.matches(name);
	}

}