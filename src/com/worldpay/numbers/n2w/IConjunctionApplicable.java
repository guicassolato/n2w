package com.worldpay.numbers.n2w;

public interface IConjunctionApplicable {
	
	/**
	 * Decides if the a conjunction word is required between quotient and remainder
	 * 
	 * @return true if a conjunction is required; false otherwise.
	 */
	abstract boolean requiresConjunction(); 

}
