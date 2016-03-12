package com.worldpay.numbers.n2w;

import java.util.ArrayList;

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
	
	private static final String[] TENS = {
		"twenty",
		"thirty",
		"forty",
		"fifty",
		"sixty",
		"seventy",
		"eighty",
		"ninety"
	};
	
	private static String getTensAsWord(int n) {
		return TENS[n-2];
	};
	
	public static String getNumberAsWords(int n) throws Exception {
		if (n < 0) throw new UnsupportedNegativeNumberException();
		if (n > 999999999) throw new UnsupportedBigNumberException();
		
		if (n < 20) {
			return getSimpleNamedNumberAsWord(n);
		} else {
			int tensPortion = n % 100;
			int tens = tensPortion / 10;
			int units = tensPortion % 10;
			
			ArrayList<String> parts = new ArrayList<String>();
			if (tens >= 2) parts.add(getTensAsWord(tens));
			if (units > 0) parts.add(getSimpleNamedNumberAsWord(units));
			
			return String.join(" ", parts);
			
			// TODO: Improve to support hundreds, thousands and millions
		}		
	}

}
