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
	 * The number which is intended to be converted to words
	 */
	private int number;
	
	/**
	 * Getter method for the number
	 * 
	 * @return the number set for later conversion to words
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Setter method to the n number
	 * 
	 * @param number  an non-negative integer number which is intended to be converted to words later
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
	/**
	 * Simple constructor method
	 */
	public NumberToWord() {
	}
	
	/**
	 * Constructor method with variable initialization
	 */
	public NumberToWord(int number) {
		setNumber(number);
	}

	/**
	 * Constant array to store the English names of the 20 single-word
	 * named integer numbers, the one lower than twenty.
	 * 
	 * @see getSimpleNamedNumberAsWord
	 */
	private final String[] SIMPLE_NAMED_NUMBERS = {
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
	private String getSimpleNamedNumberAsWord(int n) {
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
	private final String[] TENS = {
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
	private String getTensAsWord(int n) {
		return TENS[n-2];
	};
	
	/**
	 * String constant for the humanized version of the word "and" (the separator)
	 */
	private final String AND = "and";
	
	/**
	 * String constant for the humanized version of the word "hundred"
	 */
	private final String HUNDRED = "hundred";
	
	/**
	 * String constant to the English word for thousands
	 */
	private final String THOUSAND = "thousand";
	
	/**
	 * String constant to the English word for thousands
	 */
	private final String MILLION = "million";
	
	/**
	 * Converts hundreds
	 * 
	 * @param n  an integer number from 0 to 999
	 * @return   the written form of the number n, in English
	 * @throws Exception
	 */
	private String getHundredsAsWords(int n) throws Exception {
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
	public String getNumberAsWords() throws Exception {
		if (number < 0) throw new UnsupportedNegativeNumberException();
		if (number > 999999999) throw new UnsupportedBigNumberException();
		
		if (number == 0) return getSimpleNamedNumberAsWord(number);
		
		int millions = number / 1000000;
		int thousandsPortion = number % 1000000;
		
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
