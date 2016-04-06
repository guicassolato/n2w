package com.worldpay.numbers.exceptions;

public class UnsupportedNegativeNumberException extends UnsupportedInputException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1636691150195658090L;

	public UnsupportedNegativeNumberException() {
		super("Negative numbers are not supported.");
	}

}
