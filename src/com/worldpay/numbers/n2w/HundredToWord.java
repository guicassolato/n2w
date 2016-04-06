package com.worldpay.numbers.n2w;

import java.util.ArrayList;

import com.worldpay.numbers.exceptions.UnsupportedBigNumberException;
import com.worldpay.numbers.exceptions.UnsupportedNegativeNumberException;

public class HundredToWord extends NumberToWord {

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
	 * Converts an integer number from 0 to 999 (hundreds) to words
	 * 
	 * @return the written form of the number, in English
	 * @throws Exception
	 * @see NumberToWord#number
	 */
	@Override
	public String getNumberAsWords() throws Exception {
		if (number < 0) {
			throw new UnsupportedNegativeNumberException();
		}
		
		if (number > 999) {
			throw new UnsupportedBigNumberException();
		}
		
		if (number == 0) {
			NumberToWord z = new UnitToWord(0); 
			return z.getNumberAsWords();
		}

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
