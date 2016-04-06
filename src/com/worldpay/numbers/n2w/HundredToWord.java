package com.worldpay.numbers.n2w;

import java.util.ArrayList;

public class HundredToWord extends ValidNumberToWord {

	/**
	 * Simple constructor for later assignment of the number
	 */
	public HundredToWord() {
		super();
	}
	
	/**
	 * Constructor method with variable initialization
	 */
	public HundredToWord(int number) {
		super(number);
	}

	/**
	 * String constant for the humanized version of the word "hundred"
	 */
	private final String HUNDRED = "hundred";
	
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
		return 999;
	};
	
	/**
	 * Converts an integer number from 0 to 999 (hundreds) to words
	 * 
	 * @return the written form of the number, in English
	 * @throws Exception
	 * @see NumberToWord#number
	 */
	@Override
	protected String getNumberAsWordsWithoutValidation() throws Exception {
		
		int hundreds = number / 100;
		int tensPortion = number % 100;
		
		ArrayList<String> parts = new ArrayList<String>();
		
		// Quotient
		if (hundreds > 0) {
			NumberToWord h = new UnitToWord(hundreds); 
			parts.add(h.getNumberAsWords());
			parts.add(HUNDRED);
			if (tensPortion > 0) {
				parts.add(AND);
			}
		}
		
		// Remainder
		if (tensPortion > 0) {
			NumberToWord t = new TenToWord(tensPortion);
			parts.add(t.getNumberAsWords());
		}
		
		return String.join(SEPARATOR, parts);
	}

}
