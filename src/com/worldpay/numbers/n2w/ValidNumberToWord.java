package com.worldpay.numbers.n2w;

import com.worldpay.numbers.exceptions.*;

/**
 * ValidNumberToWord extends the NumberToWord class with some validation features.
 * 
 * A n number which is intended to be converted to words is considered valid if n
 * if greater or equal to a given lower limit and lower or equal to a given upper
 * limit.
 * 
 * The lower and upper limits of the class are supposed to be defined by the instance
 * classes based on ValidNumberToWord.
 * 
 * @author Guilherme Cassolato, guilherme.cassolato@worldpay.com
 *
 */
public abstract class ValidNumberToWord extends NumberToWord {
	
	/**
	 * Simple constructor for later assignment of the number
	 */
	public ValidNumberToWord() {
		super();
	}
	
	/**
	 * Constructor method with variable initialization
	 */
	public ValidNumberToWord(int number) {
		super(number);
	}
	
	/**
	 * Gets the lower limit within which the class accepts a number to be converted
	 * @return the lower limit within which the class accepts a number to be converted
	 */
	protected abstract int getLowerLimit();
	
	/**
	 * Gets the upper limit within which the class accepts a number to be converted
	 * @return the upper limit within which the class accepts a number to be converted
	 */
	protected abstract int getUpperLimit();

	/**
	 * Checks whether the number is within the lower limit
	 */
	public boolean withinLowerLimit() {
		return (number >= getLowerLimit());
	}
	
	/**
	 * Checks whether the number is within the upper limit
	 */
	public boolean withinUpperLimit() {
		return (number <= getUpperLimit());
	}
	
	/**
	 * Checks whether the number is within the both limits (lower and upper)
	 */
	public boolean isValid() {
		return (withinLowerLimit() && withinUpperLimit());
	}
	
	/**
	 * Validates number against lower limit of the class
	 */
	public void validateLowerLimit() throws UnsupportedInputException {
		if (!withinLowerLimit()) {
			throw new UnsupportedSmallNumberException(getLowerLimit());
		}
 	}
	
	/**
	 * Validates number against upper limit of the class
	 */
	public void validateUpperLimit() throws UnsupportedInputException {
		if (!withinUpperLimit()) {
			throw new UnsupportedBigNumberException(getUpperLimit());
		}
 	}
	
	/**
	 * Validates number against both limits of the class (lower and upper)
	 */
	public void validate() throws UnsupportedInputException {
		validateLowerLimit();
		validateUpperLimit();
 	}
	
	/**
	 * Converts to words any non-negative integer number within the limits of the class.
	 * 
	 * @return    the written form of the number, in English.
	 * @see #setNumber(int)
	 * @throws Exception
	 */
	@Override
	public String getNumberAsWords() throws Exception {
		validate();
		return super.getNumberAsWords();
	};

}
