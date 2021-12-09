package com.mobdev.rickandmortyapiclient.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mobdev.rickandmortyapiclient.exception.ResponseException;
import com.mobdev.rickandmortyapiclient.exception.StatusResponseEnum;


public class ValidateUtil {

	public static void validateData(String field, String value, int length, String expression, boolean validateLength) throws ResponseException {
		
		if (value == null) {
			throw new ResponseException(Constants.NULL_DATA + field,
					StatusResponseEnum.PRECONDITION_FAILED, true);
		} else if (value.equals("")) {
			throw new ResponseException(Constants.EMPTY_DATA + field,
					StatusResponseEnum.PRECONDITION_FAILED, true);
		} else if ((validateLength) && (value.length() > length)) {
			throw new ResponseException(Constants.EXCEEDS_MAXIMUM + field,
					StatusResponseEnum.PRECONDITION_FAILED, true);
		} else if ( (!expression.equals("")) && !specialCharacter(value, expression)) {
			throw new ResponseException(
					Constants.INVALID_DATA + field,
					StatusResponseEnum.PRECONDITION_FAILED, true);
		}
	}
	
	public static boolean specialCharacter(String value, String expresion) {
		Pattern pattern = Pattern.compile(expresion);
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}

	private ValidateUtil() {

	}
}
