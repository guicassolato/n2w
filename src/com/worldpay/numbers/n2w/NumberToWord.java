package com.worldpay.numbers.n2w;

import java.util.ArrayList;

import com.worldpay.numbers.exceptions.*;

public class NumberToWord {
	
	/*
	 * Constant array to store the simple named numbers - i.e. the
	 * units and other ones named by a single word under than twenty.
	 */
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
	
	/*
	 * Getter method to obtain a "simple named number" as a word
	 * from within the corresponding constant array.
	 */
	private static String getSimpleNamedNumberAsWord(int n) {
		return SIMPLE_NAMED_NUMBERS[n];
	};
	
	/*
	 * Constant array to store the names of the 8 tens greater or equal to 20.
	 * Those are the tens whose numbers including a smaller portion within them
	 * imply the compound words used to name numbers lower than 100, such as "twenty one"
	 */
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
	
	/*
	 * Getter method to obtain the name of one of the 8 tens stored in the
	 * corresponding constant array, either to convert a full ten number
	 * (e.g. 20, 30, 60) or the ten part of a number which also includes a
	 * units portion (e.g. 21, 73, 99).
	 */
	private static String getTensAsWord(int n) {
		return TENS[n-2];
	};
	
	/*
	 * The main static method to convert any integer non-negative number from
	 * 0 to 999,999,999 to its corresponding English name. 
	 */
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
