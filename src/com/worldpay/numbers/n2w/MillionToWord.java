package com.worldpay.numbers.n2w;

import java.util.ArrayList;

public class MillionToWord extends ValidNumberToWord {
	
	/**
	 * Simple constructor for later assignment of the number
	 */
	public MillionToWord() {
		super();
	}

	/**
	 * Constructor method with variable initialization
	 */
	public MillionToWord(int number) {
		super(number);
	}

	/**
	 * String constant to the English word for thousands
	 */
	private final String MILLION = "million";
	
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
		return 999999999;
	};

	/**
	 * Converts an integer number from 0 to 999,999,999 (millions) to words
	 * 
	 * @return   the written form of the number, in English
	 * @see NumberToWord#number
	 * @throws Exception
	 */
	@Override
	protected String getNumberAsWordsWithoutValidation() throws Exception {

		int millions = number / 1000000;
		int thousandsPortion = number % 1000000;
		
		int thousands = thousandsPortion / 1000;
		int hundredsPortion = thousandsPortion % 1000;
		
		ArrayList<String> parts = new ArrayList<String>();
		
		// Quotient
		if (millions > 0) {
			NumberToWord m = new HundredToWord(millions);
			parts.add(m.getNumberAsWords());
			parts.add(MILLION);
			if (thousands == 0 && hundredsPortion > 0 && hundredsPortion < 100) {
				parts.add(AND);
			}
		}
		
		// Remainder
		if (thousandsPortion > 0) {
			NumberToWord t = new ThousandToWord(thousandsPortion);
			parts.add(t.getNumberAsWords());
		}
		
		return String.join(SEPARATOR, parts);
	}

}
