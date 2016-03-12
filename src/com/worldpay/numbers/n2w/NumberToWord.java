package com.worldpay.numbers.n2w;

import com.worldpay.numbers.exceptions.*;

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
	
	public static String getNumberAsWords(int n) throws Exception {
		if (n < 0) throw new UnsupportedNegativeNumberException();
		if (n > 999999999) throw new UnsupportedBigNumberException();
		
		return getSimpleNamedNumberAsWord(n);
	}

}
