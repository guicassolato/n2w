package guicassolato.java.n2w.converters;

public class UnitToWord extends NumberToWord {
	
	/* (non-Javadoc)
	 * @see NumberToWord#NumberToWord()
	 */
	public UnitToWord() {
		super();
	}

	/* (non-Javadoc)
	 * @see NumberToWord#NumberToWord(int)
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
	private final String[] SMALL_NUMBERS = {
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
	 * Gets the English name of one of the 8 tens stored in the corresponding constant
	 * array, either to convert a full ten number (e.g. 20, 30, 60) or the ten
	 * part of a number which also includes a units portion (e.g. 21, 73, 99).
	 * 
	 * @param n  an integer number from 0 to 7
	 * @return   the written form of the (n+2)th ten, in English
	 * @see #TENS
	 */
	private String getUnitAsWord(int n) {
		return SMALL_NUMBERS[n];
	};
	
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
		return 19;
	};
	
	/**
	 * Converts an integer number from 0 to 19 (single-word named integer
	 * numbers in English) to words
	 * 
	 * @return   the written form of the number, in English
	 * @see #SMALL_NUMBERS
	 * @throws Exception 
	 */
	@Override
	public String getNumberAsWords() throws Exception {
		return getUnitAsWord(_number);
	}

}
