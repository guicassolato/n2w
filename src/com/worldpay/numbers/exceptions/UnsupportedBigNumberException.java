package com.worldpay.numbers.exceptions;

public class UnsupportedBigNumberException extends UnsupportedInputException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4586892212526146997L;

	public UnsupportedBigNumberException(int upperLimit) {
		super(String.format("Unsupported. The number should not be lower or equal to %d", upperLimit));
	}

}
