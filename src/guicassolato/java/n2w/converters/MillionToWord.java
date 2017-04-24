package guicassolato.java.n2w.converters;

import java.util.ArrayList;

public class MillionToWord extends DivisibleNumberToWord {
	
	/* (non-Javadoc)
	 * @see DivisibleNumberToWord#DivisibleNumberToWord()
	 */
	public MillionToWord() {
		super();
	}

	/* (non-Javadoc)
	 * @see DivisibleNumberToWord#DivisibleNumberToWord(int)
	 */
	public MillionToWord(int number) {
		super(number);
	}

	/**
	 * String constant to the English word for thousands
	 */
	private final String MILLION = "million";
	
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
		return 999999999;
	};
	
	/**
	 * Gets the divisor that separates the two parts of the million number which is
	 * intended to be converted to words: the quotient, which represents full million
	 * part; and the remainder, whose conversion is delegated to a lower level specific
	 * instance class (ThousandToWord)
	 */
	protected int getDivisor() {
		return 1000000;
	};
	
	/**
	 * Converts to words the quotient part of a division of the full number which is
	 * intended to be converted by 1,000,000 (the specific divisor to convert a million
	 * number to words)
	 */
	protected String getQuotientAsWords() throws Exception {
		NumberToWord n = new HundredToWord(_quotient);

		ArrayList<String> parts = new ArrayList<String>();

		parts.add(n.getNumberAsWords());
		parts.add(MILLION);
		
		return String.join(SEPARATOR, parts);
	}
	
	/**
	 * Converts to words the remainder part of a division of the full number which is
	 * intended to be converted by 1,000,000 (the specific divisor to convert a million
	 * number to words)
	 */
	protected String getRemainderAsWords() throws Exception {
		NumberToWord n = new ThousandToWord(_remainder);
		return n.getNumberAsWords();
	}

	/* (non-Javadoc)
	 * @see IConjunctionApplicable#requiresConjunction()
	 */
	@Override
	public boolean requiresConjunction() {
		int thousands = _remainder / 1000;
		int hundredsPortion = _remainder % 1000;
		
		return (_quotient > 0 && thousands == 0 && hundredsPortion > 0 && hundredsPortion < 100);
	}

}
