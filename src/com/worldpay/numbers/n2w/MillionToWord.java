package com.worldpay.numbers.n2w;

import java.util.ArrayList;

import com.worldpay.numbers.exceptions.UnsupportedBigNumberException;
import com.worldpay.numbers.exceptions.UnsupportedNegativeNumberException;

public class MillionToWord extends NumberToWord {
	
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
	 * Converts an integer number from 0 to 999,999,999 (millions) to words
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
		
		if (number > 999999999) {
			throw new UnsupportedBigNumberException();
		}
		
		if (number == 0) {
			NumberToWord z = new UnitToWord(0); 
			return z.getNumberAsWords();
		}
		
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
