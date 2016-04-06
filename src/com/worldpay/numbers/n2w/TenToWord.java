package com.worldpay.numbers.n2w;

import java.util.ArrayList;

public class TenToWord extends ValidNumberToWord {

	/**
	 * Simple constructor for later assignment of the number
	 */
	public TenToWord() {
		super();
	}
	
	/**
	 * Constructor method with variable initialization
	 */
	public TenToWord(int number) {
		super(number);
	}
	
	/**
	 * Constant array to store the English names of the 8 tens greater or equal to 20.
	 * 
	 * Those are the tens whose numbers that, when a smaller portion is included,
	 * imply compound hyphenized words to name numbers then - i.e. the ones between 20
	 * (inclusive) and 90 (inclusive), because 21 spells "twenty-one"
	 * 
	 * @see NumberToWord#getTenAsWord(int)
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
	private String getTenAsWord(int n) {
		return TENS[n-2];
	};
	
	/**
	 * Gets the lower limit within which the class accepts a number to be converted
	 * @return the lower limit within which the class accepts a number to be converted
	 */
	protected int getLowerLimit() {
		return 0;
	};
	
	/**
	 * Gets the upper limit within which the class accepts a number to be converted
	 * @return the upper limit within which the class accepts a number to be converted
	 */
	protected int getUpperLimit() {
		return 99;
	};
	
	/**
	 * String constant for the word separator sequence
	 */
	protected final String SEPARATOR = "-";
	
	/**
	 * Converts an integer number from 0 to 99 (tens) to words
	 * 
	 * @return the written form of the number, in English
	 * @throws Exception
	 * @see NumberToWord#number
	 */
	@Override
	protected String getNumberAsWordsWithoutValidation() throws Exception {

		int tens = number / 10;
		int unitsPortion;

		ArrayList<String> parts = new ArrayList<String>();
		
		// Quotient
		if (tens >= 2) {
			parts.add(getTenAsWord(tens));
			unitsPortion = number % 10;
		} else {
			unitsPortion = number;
		}
		
		// Remainder
		if (unitsPortion > 0) {
			NumberToWord u = new UnitToWord(unitsPortion);
			parts.add(u.getNumberAsWords());
		}
		
		return String.join(SEPARATOR, parts);
	}

}
