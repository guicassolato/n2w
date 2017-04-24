package guicassolato.java.n2w.converters;

public class ZeroToWord extends NumberToWord {

	/* (non-Javadoc)
	 * @see NumberToWord#NumberToWord()
	 */
	public ZeroToWord() {
		super();
	}

	/* (non-Javadoc)
	 * @see NumberToWord#NumberToWord(int)
	 */
	public ZeroToWord(int number) {
		super(0);
	}
	
	/**
	 * String constant for the humanized version of the word "zero"
	 */
	private final String ZERO = "zero";
	
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
		return 0;
	};

	/**
	 * Converts an integer number equals to 0 to its corresponding
	 * English word
	 * 
	 * @return   the written form of the number, in English
	 * @see #ZERO
	 * @throws Exception 
	 */
	@Override
	public String getNumberAsWords() throws Exception {
		return ZERO;
	}	
	
}
