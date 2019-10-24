package com.NumberParser;

import java.util.HashMap;
import java.util.Map;

public class Main {
	
	public static void main(String[] args) {
		
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

		NumberParser parser = new NumberParser(countryCodes, prefixes);
		System.out.println(parser.parse("665333399", "+447965546464"));
	}
}
