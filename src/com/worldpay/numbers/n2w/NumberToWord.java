package com.worldpay.numbers.n2w;

public class NumberToWord {
	
	private static final String[] SIMPLE_NAMED_NUMBERS = {
		"zero",
		"one",
		"two",
		"three",
		"four",
		"five",
		"six",
		"seven",
		"eight",
		"nine",
		"ten",
		"eleven",
		"twelve",
		"thirteen",
		"fourteen",
		"fifteen",
		"sixteen",
		"seventeen",
		"eighteen",
		"nineteen"
	};
	
	private static String getSimpleNamedNumberAsWord(int n) {
		return SIMPLE_NAMED_NUMBERS[n];
	};
	
	public static String getNumberAsWords(int n) {
		return getSimpleNamedNumberAsWord(n);
	}

}
