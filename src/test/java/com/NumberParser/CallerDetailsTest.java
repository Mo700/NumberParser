package com.NumberParser;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CallerDetailsTest {

	private CallerDetails calledDetails;

	@Before
	public void setUp() throws Exception {
		calledDetails =  new CallerDetails("US", "+1", "1");
	}

	@Test
	public void countryIs_US() {
		assertEquals("US", calledDetails.getCountry());
	}
	
	@Test
	public void countryCodeIs_1() {
		assertEquals("+1", calledDetails.getCountryCode());
	}
	
	@Test
	public void localPrefixIs_1() {
		assertEquals("1", calledDetails.getLocalPrefix());
	}
	
	// more tests

}
