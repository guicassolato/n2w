package com.worldpay.numbers.n2w;

import com.worldpay.numbers.exceptions.UnsupportedBigNumberException;
import com.worldpay.numbers.exceptions.UnsupportedNegativeNumberException;

public class UnitToWord extends NumberToWord {
	
	/**
	 * Simple constructor for later assignment of the number
	 */
	public UnitToWord() {
		super();
	}

	/**
	 * Constructor method with variable initialization
	 */
	public UnitToWord(int number) {
		super(number);
	}
	
	/**
	 * Constant array to store the English names of the 20 single-word
	 * named integer numbers, the one lower than twenty.
	 * 
	 * @see getNumberAsWords
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
	 * Converts an integer number from 0 to 20 (single-word named integer
	 * numbers in English) to words
	 * 
	 * @return   the written form of the number, in English
	 * @see NumberToWord#number
	 * @see #SIMPLE_NAMED_NUMBERS
	 * @throws Exception 
	 */
	@Override
	public String getNumberAsWords() throws Exception {
		if (number < 0) {
			throw new UnsupportedNegativeNumberException();
		}
		
		if (number > 19) {
			throw new UnsupportedBigNumberException();
		}
		
		return SIMPLE_NAMED_NUMBERS[number];
	}

}
