package com.NumberParser.utils;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class NumberUtilsTest {

	private NumberUtils utils;
	private Map<String, String>  prefixes;
	private Map<String, Integer>  countryCodes;

	@Before
	public void setUp() throws Exception {
		utils = new NumberUtils();
		prefixes = new HashMap<>();
		prefixes.put("US", "1");
		prefixes.put("GB", "0");
	
		countryCodes = new HashMap<>();
		countryCodes.put("US", 1);
		countryCodes.put("GB", 44);
	
	}

	/**
	 * Testing the method that returns local prefix
	 */
	@Test
	public void GB_PrefixIs_0() {
		assertEquals("0", utils.getPrefix("GB", prefixes));
	}
	
	@Test
	public void US_PrefixIs_1() {
		assertEquals("1", utils.getPrefix("US", prefixes));
	}
	
	@Test
	public void Invalid_PrefixIs_empty() {
		assertEquals("", utils.getPrefix("USA", prefixes));
	}
	/**
	 * END Testing the method that returns local prefix
	 */
	
	// TODO more tests for getKeyByValue() and getCallerDetails()
	
	

}
