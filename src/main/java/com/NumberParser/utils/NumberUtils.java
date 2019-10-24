package com.NumberParser.utils;

import java.util.Map;
import java.util.Objects;

import com.NumberParser.CallerDetails;
import com.google.common.base.Strings;

/**
 * A helper class to provide helpful methods for dealing with phone numbers for
 * this project.
 *
 */
public class NumberUtils {

	/**
	 * The maximum number of digits an country code can be. e.g. GB is "+44" which
	 * becomes length 2
	 */
	private static final int MAX_COUNTRY_CODE_LENGTH = 4;

	/**
	 * Get national prefix
	 * 
	 * @param country  e.g. GB
	 * @param prefixes map containing the mapping between country and prefixes
	 * @return local prefix e.g. 1 or 0
	 */
	public String getPrefix(String country, Map<String, String> prefixes) {
		String localPrefix = prefixes.get(country);
		return Strings.isNullOrEmpty(localPrefix) ? "" : localPrefix;
	}

	/**
	 * Returns an object containing the dialler's country, international code and
	 * national prefix
	 * 
	 * @param userNumber
	 * @param countryCodes
	 * @param prefixes
	 * @return
	 */
	public CallerDetails getCallerDetails(String userNumber, Map<String, Integer> countryCodes,
			Map<String, String> prefixes) {

		userNumber = userNumber.replace("+", "");
		// starting at 1 to avoid substring(0,0) scenario
		for (int i = MAX_COUNTRY_CODE_LENGTH + 1; i > 0; i--) {
			if (i <= userNumber.length()) {
				String internationPrexif = userNumber.substring(0, i);
				String country = getKeyByValue(countryCodes, internationPrexif);
				if (!Strings.isNullOrEmpty(country)) {
					return new CallerDetails(country, internationPrexif, getPrefix(country, prefixes));
				}
			}
		}

		return null;
	}

	/**
	 * Assuming that there is a one to one relationship between country and country
	 * code.
	 * 
	 * @param map
	 * @param value
	 * @return the key based on the value
	 */
	public String getKeyByValue(Map<String, Integer> map, String value) {
		for (String key : map.keySet()) {
			int intVal = -1;
			try {
				intVal = Integer.parseInt(value);
			} catch (Exception e) {
			}
			if (Objects.equals(map.get(key), intVal)) {
				return key;
			}
		}
		return "";
	}
}
