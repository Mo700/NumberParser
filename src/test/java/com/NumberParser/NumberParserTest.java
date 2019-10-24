package com.NumberParser;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class NumberParserTest {
	NumberParser parser;

	@Before
	public void setup() {
		Map<String, String> prefixes = new HashMap<>();
		prefixes.put("US", "1");
		prefixes.put("GB", "0");
		prefixes.put("MA", "0");
		prefixes.put("FA", "1");
		prefixes.put("DD", "66");
		
		Map<String, Integer> countryCodes = new HashMap<>();
		countryCodes.put("US", 1);
		countryCodes.put("GB", 44);
		countryCodes.put("MA", 212);
		countryCodes.put("FA", 1234);
		countryCodes.put("DD", 11);

		parser = new NumberParser(countryCodes, prefixes);
	}

	@Test
	public void test1() {

		assertEquals("+442079460056", parser.parse("02079460056", "+441614960148"));
		
	}
	@Test
	public void test2() {
		assertEquals("+442079460056", parser.parse("+442079460056", "+441614960148"));
	}
	
	@Test
	public void test3() {
		assertEquals("+442079460056", parser.parse("02079460056", "+441614960148")); // +44
	}
	@Test
	public void test4() {
		assertEquals("+2126774746363", parser.parse("06774746363", "+2126848475656")); // +212
	}
	@Test
	public void test5() {
		assertEquals("+123419838374747", parser.parse("19838374747", "+123487457434")); // +1234
	}
	@Test
	public void test6() {
		assertEquals("+117364545474", parser.parse("7364545474", "+1614960148")); // +1
	}
	@Test
	public void test7() {
		assertEquals("+123415556433", parser.parse("05556433", "+12345678910")); // +1
	}
	@Test
	public void test8() {
		assertEquals("+11911", parser.parse("911", "+123")); // +1
	}
	@Test
	public void test9() {
		assertEquals("", parser.parse("1", ""));// invalid
	}
	@Test
	public void test10() {
		assertEquals("", parser.parse("", ""));// invalid
	}
	@Test
	public void test11() {
		assertEquals("", parser.parse("12345invalid6", "+4465588377376"));// invalid
	}
	@Test
	public void test12() {
		assertEquals("+116688888888", parser.parse("88888888", "+1165588377376"));// +11
	}
	@Test
	public void test13() {
		assertEquals("+1166188888888", parser.parse("188888888", "+116558837737"));// +11
	}
	@Test
	public void test14() {
		assertEquals("+116688888888", parser.parse("088888888", "+1123456787"));// +11
	}
	@Test
	public void test15() {
		assertEquals("+1111", parser.parse("111", "+1"));// +1
	}
	@Test
	public void test16() {
		assertEquals("+116611", parser.parse("11", "+11"));// +11
	}
	@Test
	public void test17() {
		assertEquals("+447865433", parser.parse("7865433", "+447965546464"));// +44
	}
}
