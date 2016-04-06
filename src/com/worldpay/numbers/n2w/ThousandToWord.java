package com.worldpay.numbers.n2w;

import java.util.ArrayList;

import com.worldpay.numbers.exceptions.UnsupportedBigNumberException;
import com.worldpay.numbers.exceptions.UnsupportedNegativeNumberException;

public class ThousandToWord extends NumberToWord {

	/**
	 * Simple constructor for later assignment of the number
	 */
	public ThousandToWord() {
		super();
	}

	/**
	 * Constructor method with variable initialization
	 */
	public ThousandToWord(int number) {
		super(number);
	}

	/**
	 * String constant to the English word for thousands
	 */
	private final String THOUSAND = "thousand";
	
	/**
	 * Converts an integer number from 0 to 999,999 (thousands) to words
	 * 
	 * @return   the written form of the number, in English
	 * @see NumberToWord#number
	 * @throws Exception
	 */
	@Override
	public String getNumberAsWords() throws Exception {
		if (number < 0) {
			throw new UnsupportedNegativeNumberException();
		}
		
		if (number > 999999) {
			throw new UnsupportedBigNumberException();
		}
		
		if (number == 0) {
			NumberToWord z = new UnitToWord(0); 
			return z.getNumberAsWords();
		}
		
		int thousands = number / 1000;
		int hundredsPortion = number % 1000;
		
		ArrayList<String> parts = new ArrayList<String>();
		
		// Quotient
		if (thousands > 0) {
			NumberToWord t = new HundredToWord(thousands);
			parts.add(t.getNumberAsWords());
			parts.add(THOUSAND);
			if (hundredsPortion > 0 && hundredsPortion < 100) {
				parts.add(AND);
			}
		}
		
		// Remainder
		if (hundredsPortion > 0) {
			NumberToWord h = new HundredToWord(hundredsPortion);
			parts.add(h.getNumberAsWords());
		}
		
		return String.join(SEPARATOR, parts);
	}

}
