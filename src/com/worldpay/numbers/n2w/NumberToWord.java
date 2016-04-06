package com.worldpay.numbers.n2w;

/**
 * NumberToWord is the abstract class to convert integer numbers to
 * their written form in English. It has been developed and presented
 * as the technical challenge part for the assessment process for
 * Sr. Java Developer at Worldpay UK.
 * 
 * @author Guilherme Cassolato, guilherme.cassolato@worldpay.com
 * @version 1.1 (2016-04-06)
 *
 */
public abstract class NumberToWord {
	
	/**
	 * The number which is intended to be converted to words
	 */
	protected int number;
	
	/**
	 * Getter method for the number
	 * 
	 * @return the number set for later conversion to words
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Setter method to the n number
	 * 
	 * @param number  an non-negative integer number which is intended to be converted to words later
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
	/**
	 * Simple constructor for later assignment of the number
	 */
	public NumberToWord() {
	}
	
	/**
	 * Constructor method with variable initialization
	 */
	public NumberToWord(int number) {
		setNumber(number);
	}
	
	/**
	 * String constant for the humanized version of the word "and" (the separator)
	 */
	protected final String AND = "and";
	
	/**
	 * String constant for the word separator sequence
	 */
	protected final String SEPARATOR = " ";
	
	/**
	 * Converts any integer non-negative number to words.
	 * 
	 * @return    the written form of the number, in English.
	 * @see #number
	 * @throws Exception
	 */
	public abstract String getNumberAsWords() throws Exception;

}
