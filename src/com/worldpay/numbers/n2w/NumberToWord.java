package com.worldpay.numbers.n2w;

import java.util.ArrayList;

import com.worldpay.numbers.exceptions.*;

/**
 * NumberToWord is the abstract class to convert integer numbers to
 * their written form in English. It has been developed and presented
 * as the technical challenge part for the assessment process for
 * Sr. Java Developer at Worldpay UK.
 * 
 * @author Guilherme Cassolato, guilherme.cassolato@worldpay.com
 * @version 1.0 (2016-03-21)
 *
 */
public class NumberToWord {
	
	/**
	 * Constant array to store the English names of the 20 single-word
	 * named integer numbers, the one lower than twenty.
	 * 
	 * @see getSimpleNamedNumberAsWord
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
	
	/**
	 * Gets from the corresponding constant array the name of one of the
	 * 20 single-word named integer numbers in English.
	 * 
	 * @param n  an integer number from 0 to 19
	 * @return   the written form of the number n, in English
	 * @see #SIMPLE_NAMED_NUMBERS
	 */
	private static String getSimpleNamedNumberAsWord(int n) {
		return SIMPLE_NAMED_NUMBERS[n];
	};
	
	/**
	 * Constant array to store the English names of the 8 tens greater or equal to 20.
	 * 
	 * Those are the tens whose numbers that, when a smaller portion is included,
	 * imply compound hyphenized words to name numbers then - i.e. the ones between 20
	 * (inclusive) and 90 (inclusive), because 21 spells "twenty-one"
	 * 
	 * @see NumberToWord#getTensAsWord(int)
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
	
	/**
	 * Gets the English name of one of the 8 tens stored in the corresponding constant
	 * array, either to convert a full ten number (e.g. 20, 30, 60) or the ten
	 * part of a number which also includes a units portion (e.g. 21, 73, 99).
	 * 
	 * @param n  an integer number from 0 to 7
	 * @return   the written form of the (n+2)th ten, in English
	 * @see #TENS
	 */
	private static String getTensAsWord(int n) {
		return TENS[n-2];
	};
	
	/**
	 * String constant for the humanized version of the word "and" (the separator)
	 */
	private static final String AND = "and";
	
	/**
	 * String constant for the humanized version of the word "hundred"
	 */
	private static final String HUNDRED = "hundred";
	
	/**
	 * String constant to the English word for thousands
	 */
	private static final String THOUSAND = "thousand";
	
	/**
	 * String constant to the English word for thousands
	 */
	private static final String MILLION = "million";
	
	/**
	 * Converts hundreds
	 * 
	 * @param n  an integer number from 0 to 999
	 * @return   the written form of the number n, in English
	 * @throws Exception
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
				if (units > 0)
					parts.add(String.format("%s-%s", getTensAsWord(tens), getSimpleNamedNumberAsWord(units)));
				else
					parts.add(getTensAsWord(tens));
			}
		}
		
		return String.join(" ", parts);
	}
	
	/**
	 * Converts any integer non-negative number from 0 to 999,999,999
	 * to its corresponding English name.
	 * 
	 * This is the main class method of the library.
	 * 
	 * @param n  an integer number from 0 to 999,999,999
	 * @return   the written form of the number n, in English.
	 * @throws Exception
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
