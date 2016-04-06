package com.worldpay.numbers.n2w;

public class UnitToWord extends ValidNumberToWord {
	
	/**
	 * Simple constructor for later assignment of the number
	 */
	public UnitToWord() {
		super();
	}

	/**
	 * Constructor method with variable initialization
	 */
	public UnitToWord(int number) {
		super(number);
	}
	
	/**
	 * Constant array to store the English names of the 20 single-word
	 * named integer numbers, the one lower than twenty.
	 * 
	 * @see getNumberAsWords
	 */
	private final String[] SIMPLE_NAMED_NUMBERS = {
		"zero",
		"one",
		"two",
		"three",
		"four",
		"five",
		"six",
		"seven",
		"eight",
		"nine",
		"ten",
		"eleven",
		"twelve",
		"thirteen",
		"fourteen",
		"fifteen",
		"sixteen",
		"seventeen",
		"eighteen",
		"nineteen"
	};
	
	/**
	 * Gets the lower limit within which the class accepts a number to be converted
	 * @return the lower limit within which the class accepts a number to be converted
	 */
	protected int getLowerLimit() {
		return 0;
	};
	
	/**
	 * Gets the upper limit within which the class accepts a number to be converted
	 * @return the upper limit within which the class accepts a number to be converted
	 */
	protected int getUpperLimit() {
		return 19;
	};
	
	/**
	 * Converts an integer number from 0 to 19 (single-word named integer
	 * numbers in English) to words
	 * 
	 * @return   the written form of the number, in English
	 * @see NumberToWord#number
	 * @see #SIMPLE_NAMED_NUMBERS
	 * @throws Exception 
	 */
	@Override
	protected String getNumberAsWordsWithoutValidation() throws Exception {
		return SIMPLE_NAMED_NUMBERS[number];
	}

}
