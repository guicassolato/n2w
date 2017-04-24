package guicassolato.java.n2w.converters;

import guicassolato.java.n2w.exceptions.UnsupportedBigNumberException;
import guicassolato.java.n2w.exceptions.UnsupportedInputException;
import guicassolato.java.n2w.exceptions.UnsupportedSmallNumberException;

/**
 * ILimitedNumberToWord an interface intended to add some limits checking feature to a
 * NumberToWord class.
 * 
 * A n number which is intended to be converted to words is considered within limits if
 * n is greater or equal to a given floor (the lower limit) and lower or equal to a given
 * ceiling (the upper limit).
 * 
 * @author Guilherme Cassolato, guicassolato@gmail.com
 *
 */
public interface ILimitedNumberToWord {
	
	/**
	 * Gets the lower limit within which the class accepts a number to be converted
	 * @return the lower limit within which the class accepts a number to be converted
	 */
	abstract int getLowerLimit();
	
	/**
	 * Gets the upper limit within which the class accepts a number to be converted
	 * @return the upper limit within which the class accepts a number to be converted
	 */
	abstract int getUpperLimit();

	/**
	 * Checks whether the number is within the lower limit
	 * 
	 * @return true if the number is greater or equal to the lower limit specified by the instance class; false otherwise.
	 */
	abstract boolean withinLowerLimit();

	/**
	 * Checks whether the number is within the upper limit
	 * 
	 * @return true if the number is lower or equal to the upper limit specified by the instance class; false otherwise.
	 */
	abstract boolean withinUpperLimit();

	/**
	 * Checks whether the number is within the both limits (lower and upper)
	 * 
	 * @return true if the number is within both limits (lower inclusive and upper inclusive) specified by the instance class; false otherwise.
	 */
	abstract boolean withinLimits();

	/**
	 * Checks number against the lower limit of the class
	 * 
	 * @throws UnsupportedSmallNumberException
	 */
	abstract void checkLowerLimit() throws UnsupportedSmallNumberException;

	/**
	 * Checks number against the upper limit of the class
	 * 
	 * @throws UnsupportedBigNumberException
	 */
	abstract void checkUpperLimit() throws UnsupportedBigNumberException;

	/**
	 * Checks number against both limits of the class (lower and upper)
	 * 
	 * @throws UnsupportedInputException
	 */
	abstract void checkLimits() throws UnsupportedInputException;

	/**
	 * Converts to words any non-negative integer number within the limits of the class.
	 * 
	 * @return the written form of the number, in English.
	 * @throws Exception
	 */
	abstract String getLimitedNumberAsWords() throws Exception;

}