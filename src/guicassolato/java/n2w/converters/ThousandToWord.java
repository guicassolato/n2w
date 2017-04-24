package guicassolato.java.n2w.converters;

import java.util.ArrayList;

public class ThousandToWord extends DivisibleNumberToWord {

	/* (non-Javadoc)
	 * @see DivisibleNumberToWord#DivisibleNumberToWord()
	 */
	public ThousandToWord() {
		super();
	}

	/* (non-Javadoc)
	 * @see DivisibleNumberToWord#DivisibleNumberToWord(int)
	 */
	public ThousandToWord(int number) {
		super(number);
	}

	/**
	 * String constant to the English word for thousands
	 */
	private final String THOUSAND = "thousand";
	
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
		return 999999;
	};
	
	/**
	 * Gets the divisor that separates the two parts of the thousand number which is
	 * intended to be converted to words: the quotient, which represents full thousand
	 * part; and the remainder, whose conversion is delegated to a lower level specific
	 * instance class (HundredToWord)
	 */
	protected int getDivisor() {
		return 1000;
	};
	
	/**
	 * Converts to words the quotient part of a division of the full number which is
	 * intended to be converted by 1,000 (the specific divisor to convert a thousand
	 * number to words)
	 */
	protected String getQuotientAsWords() throws Exception {
		NumberToWord n = new HundredToWord(_quotient);

		ArrayList<String> parts = new ArrayList<String>();

		parts.add(n.getNumberAsWords());
		parts.add(THOUSAND);
		
		return String.join(SEPARATOR, parts);
	}
	
	/**
	 * Converts to words the remainder part of a division of the full number which is
	 * intended to be converted by 1,000 (the specific divisor to convert a thousand
	 * number to words)
	 */
	protected String getRemainderAsWords() throws Exception {
		NumberToWord n = new HundredToWord(_remainder);
		return n.getNumberAsWords();
	}

	/* (non-Javadoc)
	 * @see IConjunctionApplicable#requiresConjunction()
	 */
	@Override
	public boolean requiresConjunction() {
		return (_quotient > 0 && _remainder > 0 && _remainder < 100);
	}

}
