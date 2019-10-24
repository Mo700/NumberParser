package com.NumberParser;

public class CallerDetails {
	private String country = "";
	private String countryCode = "";
	private String localPrefix = "";

	/**
	 * Create an object that contains the dailler's country, country's international phone code and localPrefix.
	 * @param country e.g. "GB"
	 * @param countryCode international phone code e.g. 44 (without +)
	 * @param localPrefix e.g. 0 
	 */
	public CallerDetails(String country, String countryCode, String localPrefix) {
		super();
		this.country = country;
		this.countryCode = countryCode;
		this.localPrefix = localPrefix;
	}

	public CallerDetails() {

	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getLocalPrefix() {
		return localPrefix;
	}

	public void setLocalPrefix(String localPrefix) {
		this.localPrefix = localPrefix;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CallerDetails [country=");
		builder.append(country);
		builder.append(", countryCode=");
		builder.append(countryCode);
		builder.append(", localPrefix=");
		builder.append(localPrefix);
		builder.append("]");
		return builder.toString();
	}
}
