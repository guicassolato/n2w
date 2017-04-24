package guicassolato.java.n2w.converters;

import java.util.ArrayList;

public class HundredToWord extends DivisibleNumberToWord {

	/* (non-Javadoc)
	 * @see DivisibleNumberToWord#DivisibleNumberToWord()
	 */
	public HundredToWord() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see DivisibleNumberToWord#DivisibleNumberToWord(int)
	 */
	public HundredToWord(int number) {
		super(number);
	}

	/**
	 * String constant for the humanized version of the word "hundred"
	 */
	private final String HUNDRED = "hundred";
	
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
		return 999;
	};
	
	/**
	 * Gets the divisor that separates the two parts of the hundred number which is
	 * intended to be converted to words: the quotient, which represents full hundred
	 * part; and the remainder, whose conversion is delegated to a lower level specific
	 * instance class (TenToWord)
	 */
	protected int getDivisor() {
		return 100;
	};
	
	/**
	 * Converts to words the quotient part of a division of the full number which is
	 * intended to be converted by 100 (the specific divisor to convert a hundred
	 * number to words)
	 */
	protected String getQuotientAsWords() throws Exception {
		NumberToWord n = new UnitToWord(_quotient);

		ArrayList<String> parts = new ArrayList<String>();

		parts.add(n.getNumberAsWords());
		parts.add(HUNDRED);
		
		return String.join(SEPARATOR, parts);
	}
	
	/**
	 * Converts to words the remainder part of a division of the full number which is
	 * intended to be converted by 100 (the specific divisor to convert a hundred
	 * number to words)
	 */
	protected String getRemainderAsWords() throws Exception {
		NumberToWord n = new TenToWord(_remainder);
		return n.getNumberAsWords();
	}

	/* (non-Javadoc)
	 * @see IConjunctionApplicable#requiresConjunction()
	 */
	@Override
	public boolean requiresConjunction() {
		return (_quotient > 0 && _remainder > 0);
	}

}
