package com.worldpay.numbers.exceptions;

public class UnsupportedBigNumberException extends UnsupportedInputException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4586892212526146997L;

	public UnsupportedBigNumberException() {
		super("Numbers grater than 999,999,999 are not supported");
	}

}