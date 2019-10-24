package com.NumberParser.utils;

import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is to be used for phone number validation such as the digit range
 * of a phone number
 *
 */
public class Validator {

	/**
	 * Validate that a phone number contains numeric characters only.
	 * @param internationalNumber
	 * @param logger
	 * @return
	 */
	public boolean validate(String internationalNumber, Logger logger) {
		try {
			new BigInteger(internationalNumber);
		} catch (NumberFormatException e) {
			logger.log(Level.ALL, e.getMessage(), e);
			return false;
		}
		return true;
	}

}
