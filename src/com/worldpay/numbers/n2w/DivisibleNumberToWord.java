package com.worldpay.numbers.n2w;

import java.util.ArrayList;

/**
 * DivisibleNumberToWord extends the NumberToWord class to better fit cases where the number
 * which is intended to be converted to words could be divided into a full integer part (the
 * quotient) compatible with the specific instance class level of abstraction, and a smaller
 * part (the remainder) whose conversion can be delegated to a lower level specific instance
 * class.
 *  
 * @author Guilherme Cassolato, guilherme.cassolato@worldpay.com
 *
 */
public abstract class DivisibleNumberToWord extends NumberToWord implements IConjunctionApplicable {

	/* (non-Javadoc)
	 * @see NumberToWord#NumberToWord()
	 */
	public DivisibleNumberToWord() {
		super();
	}

	/* (non-Javadoc)
	 * @see NumberToWord#NumberToWord(int)
	 */
	public DivisibleNumberToWord(int number) {
		super(number);
	}
	
	/**
	 * Gets the divisor, given by each specific class, that separates the two parts
	 * of the number which is intended to be converted to words: the quotient, which
	 * represents full part corresponding to the specific instance class; and the
	 * remainder, which represents the part of the number whose conversion could
	 * be delegated to a lower level specific instance class
	 */
	protected abstract int getDivisor();

	/**
	 * The the quotient part of the division of the full number which is
	 * intended to be converted by the divisor given by each specific class
	 */
	protected int _quotient;
	
	/**
	 * The the remainder part of the division of the full number which is
	 * intended to be converted by the divisor given by each specific class
	 */
	protected int _remainder;
	
	/**
	 * Converts to words the quotient part of a division of the full number which is
	 * intended to be converted by a given divisor according to each specific class
	 */
	protected abstract String getQuotientAsWords() throws Exception;
	
	/**
	 * Converts to words the remainder part of a division of the full number which is
	 * intended to be converted by a given divisor according to each specific class
	 */
	protected abstract String getRemainderAsWords() throws Exception;
	
	/**
	 * Converts any integer number to words without limit checking
	 * 
	 * @return    the written form of the number, in English.
	 * @see #_number
	 * @throws Exception
	 */
	public String getNumberAsWords() throws Exception {
		if (_number == 0) {
			NumberToWord z = new ZeroToWord(0); 
			return z.getNumberAsWords();
		}

		_quotient = _number / getDivisor();
		_remainder = _number % getDivisor();
		
		ArrayList<String> parts = new ArrayList<String>();
		
		// Quotient
		if (_quotient > 0) {
			parts.add(getQuotientAsWords());
		}
		
		// Conjunction
		if (requiresConjunction()) {
			parts.add(AND);
		}
		
		// Remainder
		if (_remainder > 0) {
			parts.add(getRemainderAsWords());
		}
		
		return String.join(SEPARATOR, parts);
	}
	
	/**
	 * String constant for the humanized version of the word "and" (the separator)
	 */
	protected final String AND = "and";

	/**
	 * States the default requirement for conjunction word between the quotient part
	 * and the remainder part as false. To be overwritten in case of specific behavior. 
	 * 
	 * @return false
	 * @see ILimitedNumberToWord#getLimitedNumberAsWords()
	 */
	@Override
	public boolean requiresConjunction() {
		return false;
	}

}
