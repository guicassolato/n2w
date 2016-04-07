package com.worldpay.numbers.n2w;

import java.util.ArrayList;

public class TenToWord extends DivisibleNumberToWord {

	/* (non-Javadoc)
	 * @see DivisibleNumberToWord#DivisibleNumberToWord()
	 */
	public TenToWord() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see DivisibleNumberToWord#DivisibleNumberToWord(int)
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
	 * String constant for the word separator sequence
	 */
	protected final String SEPARATOR = "-";
	
	/* (non-Javadoc)
	 * @see ILimitedNumberToWord#getLowerLimit()
	 */
	public int getLowerLimit() {
		return 0;
	};
	
	/* (non-Javadoc)
	 * @see ILimitedNumberToWord#getUpperLimit()
	 */
	public int getUpperLimit() {
		return 99;
	};
	
	/**
	 * Gets the divisor that separates the two parts of the ten number which is
	 * intended to be converted to words: the quotient, which represents full ten
	 * part; and the remainder, whose conversion is delegated to a lower level specific
	 * instance class (UnitToWord)
	 */
	protected int getDivisor() {
		return 10;
	};
	
	/**
	 * Converts to words the quotient part of a division of the full number which is
	 * intended to be converted by 10 (the specific divisor to convert a ten number
	 * to words)
	 */
	protected String getQuotientAsWords() throws Exception {
		return getTenAsWord(_quotient);
	}
	
	/**
	 * Converts to words the remainder part of a division of the full number which is
	 * intended to be converted by 10 (the specific divisor to convert a ten number
	 * to words)
	 */
	protected String getRemainderAsWords() throws Exception {
		NumberToWord n = new UnitToWord(_remainder);
		return n.getNumberAsWords();
	}
	
	/**
	 * Converts an integer number from 0 to 99 (tens) to words
	 * 
	 * @return the written form of the number, in English
	 * @see #TENS
	 * @throws Exception
	 */
	@Override
	public String getNumberAsWords() throws Exception {

		_quotient = _number / getDivisor();
		_remainder = _number % getDivisor();

		ArrayList<String> parts = new ArrayList<String>();
		
		// Quotient
		if (_quotient >= 2) {
			parts.add(getQuotientAsWords());
		} else {
			_remainder = _number;
		}
		
		// Remainder
		if (_remainder > 0) {
			parts.add(getRemainderAsWords());
		}
		
		return String.join(SEPARATOR, parts);
	}

}
