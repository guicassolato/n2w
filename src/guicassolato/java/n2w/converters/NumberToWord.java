package guicassolato.java.n2w.converters;

import guicassolato.java.n2w.exceptions.UnsupportedBigNumberException;
import guicassolato.java.n2w.exceptions.UnsupportedInputException;
import guicassolato.java.n2w.exceptions.UnsupportedSmallNumberException;

/**
 * NumberToWord is the abstract class to convert integer numbers to
 * their written form in English.
 * 
 * @author Guilherme Cassolato, guicassolato@gmail.com
 * @version 1.1 (2016-04-06)
 *
 */
public abstract class NumberToWord implements ILimitedNumberToWord {
	
	/**
	 * The number which is intended to be converted to words
	 */
	protected int _number;
	
	/**
	 * Gets the number which is intended to be converted to words
	 * 
	 * @return the number set for later conversion to words
	 */
	public int getNumber() {
		return _number;
	}

	/**
	 * Sets the number which is intended to be later converted to words
	 * 
	 * @param number  an non-negative integer number which is intended to be converted to words later
	 */
	public void setNumber(int number) {
		this._number = number;
	}
	
	/**
	 * Simple constructor when later assignment of the number is desired
	 */
	public NumberToWord() {
	}
	
	/**
	 * Constructor method with variable initialization
	 * 
	 * @param number an integer number which is intended to be converted to words
	 */
	public NumberToWord(int number) {
		setNumber(number);
	}
		
	/**
	 * String constant for the word separator sequence
	 */
	protected final String SEPARATOR = " ";
	
	/* (non-Javadoc)
	 * @see ILimitedNumberToWord#withinLowerLimit()
	 */
	@Override
	public boolean withinLowerLimit() {
		return (_number >= getLowerLimit());
	}
	
	/* (non-Javadoc)
	 * @see ILimitedNumberToWord#withinUpperLimit()
	 */
	@Override
	public boolean withinUpperLimit() {
		return (_number <= getUpperLimit());
	}
	
	/* (non-Javadoc)
	 * @see ILimitedNumberToWord#withinLimits()
	 */
	@Override
	public boolean withinLimits() {
		return (withinLowerLimit() && withinUpperLimit());
	}
	
	/* (non-Javadoc)
	 * @see ILimitedNumberToWord#checkLowerLimit()
	 */
	@Override
	public void checkLowerLimit() throws UnsupportedSmallNumberException {
		if (!withinLowerLimit()) {
			throw new UnsupportedSmallNumberException(getLowerLimit());
		}
 	}
	
	/* (non-Javadoc)
	 * @see ILimitedNumberToWord#checkUpperLimit()
	 */
	@Override
	public void checkUpperLimit() throws UnsupportedBigNumberException {
		if (!withinUpperLimit()) {
			throw new UnsupportedBigNumberException(getUpperLimit());
		}
 	}
	
	/* (non-Javadoc)
	 * @see ILimitedNumberToWord#checkLimits()
	 */
	@Override
	public void checkLimits() throws UnsupportedInputException {
		checkLowerLimit();
		checkUpperLimit();
 	}
	
	/* (non-Javadoc)
	 * @see ILimitedNumberToWord#getLimitedNumberAsWords()
	 */
	@Override
	public String getLimitedNumberAsWords() throws Exception {
		checkLimits();
		return getNumberAsWords();
	};
	
	/**
	 * Converts any integer number to words without limit checking
	 * 
	 * @return    the written form of the number, in English.
	 * @throws Exception
	 */
	public abstract String getNumberAsWords() throws Exception;
	
}
