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
	 * from the corresponding constant array.
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
	 * String constant for the humanized version of the word "and" (the separator)
	 */
	private static final String AND = "and";
	
	/*
	 * String constant for the humanized version of the word "hundred"
	 */
	private static final String HUNDRED = "hundred";
	
	/*
	 * String constant to the English word for thousands
	 */
	private static final String THOUSAND = "thousand";
	
	/*
	 * String constant to the English word for thousands
	 */
	private static final String MILLION = "million";
	
	/*
	 * Converts hundreds
	 */
	private static String getHundredsAsWords(int n) throws Exception {
		int hundreds = n / 100;
		int tensPortion = n % 100;
		
		int tens = tensPortion / 10;
		int units = tensPortion % 10;
		
		ArrayList<String> parts = new ArrayList<String>();
		
		if (hundreds > 0) {
			parts.add(getSimpleNamedNumberAsWord(hundreds));
			parts.add(HUNDRED);
			if (tensPortion > 0) parts.add(AND);
		}
		
		if (tensPortion > 0) {
			if (tensPortion < 20) {
				parts.add(getSimpleNamedNumberAsWord(tensPortion));
			} else {
				parts.add(getTensAsWord(tens));
				if (units > 0)
					parts.add(getSimpleNamedNumberAsWord(units));
			}
		}
		
		return String.join(" ", parts);
	}
	
	/*
	 * The main static method to convert any integer non-negative number from
	 * 0 to 999,999,999 to its corresponding English name. 
	 */
	public static String getNumberAsWords(int n) throws Exception {
		if (n < 0) throw new UnsupportedNegativeNumberException();
		if (n > 999999999) throw new UnsupportedBigNumberException();
		
		if (n == 0) return getSimpleNamedNumberAsWord(n);
		
		int millions = n / 1000000;
		int thousandsPortion = n % 1000000;
		
		int thousands = thousandsPortion / 1000;
		int hundredsPortion = thousandsPortion % 1000;
		
		ArrayList<String> parts = new ArrayList<String>();
		
		if (millions > 0) {
			parts.add(getHundredsAsWords(millions));
			parts.add(MILLION);
			if (thousands == 0 && hundredsPortion > 0 && hundredsPortion < 100)
				parts.add(AND);
		}
		
		if (thousands > 0) {
			parts.add(getHundredsAsWords(thousands));
			parts.add(THOUSAND);
			if (hundredsPortion > 0 && hundredsPortion < 100)
				parts.add(AND);
		}
		
		if (hundredsPortion > 0)
			parts.add(getHundredsAsWords(hundredsPortion));
		
		return String.join(" ", parts);
	}

}
