package com.NumberParser;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.NumberParser.utils.NumberUtils;
import com.NumberParser.utils.Validator;
import com.google.common.base.Strings;

/**
 * When given a dialled phone number (national or international) and the user’s
 * international phone number this class returns the dialled phone number in
 * international format
 */
public class NumberParser {
	private static final String INVALID_PREFIX = "0";
	private static final String ERROR_NULL_EMPTY_NUMBERS = "DialledNumber and UserNumber cannot be empty or null";
	private final static Logger LOGGER = Logger.getLogger(NumberParser.class.getName());
	private Map<String, Integer> countryCodes;
	private Map<String, String> prefixes;
	private NumberUtils numberUtils;

	/**
	 * The constructor accepts a mapping of country codes (e.g. “GB”, “US”) to the
	 * corresponding country calling codes (e.g. 44, 1), and a mapping of country
	 * codes to the corresponding national trunk prefixes (e.g. “0”, “1”).
	 * 
	 * <p>
	 * Note: prefixes in the test is Map<String, Integer>, but the task document
	 * specifies the constructor like below
	 * 
	 * @param callingCodes A mapping of country codes (e.g. “GB”, “US”)
	 * @param prefixes     a mapping of country codes to the corresponding national
	 *                     trunk prefixes (e.g. “0”, “1”).
	 * 
	 *
	 */
	public NumberParser(Map<String, Integer> callingCodes, Map<String, String> prefixes) {
		this.countryCodes = callingCodes;
		this.prefixes = prefixes;
		numberUtils = new NumberUtils();
	}

	/**
	 * Takes the dialled number and the dialler number and produces an international
	 * format for the dialled number.
	 * 
	 * If the dialled number starts with a '+' then it is returned as it is without
	 * any extra formatting
	 * 
	 * @param dialledNumber The number that is being dialled
	 * @param userNumber    the dialler's phone number
	 * @return international version of the dialled number
	 */
	public String parse(String dialledNumber, String userNumber) {
		if (Strings.isNullOrEmpty(dialledNumber) || Strings.isNullOrEmpty(userNumber)) {
			LOGGER.log(Level.ALL, ERROR_NULL_EMPTY_NUMBERS);
			return "";
		}
		if (dialledNumber.startsWith("+")) {
			return dialledNumber;
		}

		return getInternationNumber(dialledNumber, userNumber);

	}

	/**
	 * Private method that takes the dialled number and the dialler number and
	 * produces an international format for the dialled number.
	 * 
	 * <p>
	 * If the dialled number starts with a 0, then the 0 is removed.
	 * <p>
	 * If the dialled number does not start with the countries nation prefix, then
	 * the prefix is added e.g. "1", "66" or ""
	 * 
	 * @param dialledNumber The number that is being dialled
	 * @param userNumber    the dialler's phone number
	 * @return international version of the dialled number
	 */
	private String getInternationNumber(final String dialledNumber, final String userNumber) {
		final CallerDetails callerDetails = numberUtils.getCallerDetails(userNumber, countryCodes, prefixes);
		String tempDialledNumber = dialledNumber;
		String internationalNumber = "";

		if (callerDetails != null) {
			String localPrefix = callerDetails.getLocalPrefix();
			if (tempDialledNumber.startsWith(INVALID_PREFIX)) {
				tempDialledNumber = tempDialledNumber.replaceFirst(INVALID_PREFIX, "");
			}
			// 0 must be stripped off before converting to international
			if (!dialledNumber.startsWith(localPrefix) && !"0".equals(localPrefix)) {
				tempDialledNumber = localPrefix + tempDialledNumber;
			}

			internationalNumber = "+" + callerDetails.getCountryCode() + tempDialledNumber;

		}

		return new Validator().validate(internationalNumber, LOGGER) ? internationalNumber : "";
	}

}