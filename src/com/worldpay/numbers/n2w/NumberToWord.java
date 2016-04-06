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
	 * Gets the number which is intended to be converted to words
	 * 
	 * @return the number set for later conversion to words
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Sets the number which is intended to be later converted to words
	 * 
	 * @param number  an non-negative integer number which is intended to be converted to words later
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
	/**
	 * Simple constructor when later assignment of the number is desired
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
	 * Converts to words any non-negative integer number within the limits of the class.
	 * 
	 * @return    the written form of the number, in English.
	 * @see #setNumber(int)
	 * @throws Exception
	 */
	public String getNumberAsWords() throws Exception {
		if (number == 0) {
			NumberToWord z = new UnitToWord(0); 
			return z.getNumberAsWordsWithoutValidation();
		}
		
		return this.getNumberAsWordsWithoutValidation();
	};
	
	/**
	 * Converts any integer number to words without limit checking
	 * 
	 * @return    the written form of the number, in English.
	 * @see #number
	 * @throws Exception
	 */
	protected abstract String getNumberAsWordsWithoutValidation() throws Exception;

}
