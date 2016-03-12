package com.worldpay.numbers.n2w.tdd;

import org.junit.Test;

import com.worldpay.numbers.n2w.NumberToWord;
import com.worldpay.numbers.exceptions.*;

import static org.junit.Assert.*;

public class NumberToWordTest {
	
	/*
	 * Tests conversion of 0 (zero) 
	 */
	@Test
	public void shouldConvertZeroToWord() throws Exception {
		int n = 0;
		String w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("zero", w);
	}
	
	/*
	 * Tests conversion of simple small positive numbers (<20)
	 */
	@Test
	public void shouldConvertUnitsToWord() throws Exception {
		int n = 1;
		String w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("one", w);
	}
	
	/*
	 * Tests conversion of numbers greater or equal to 20, lower than 100
	 * and with unit portion different than zero (e.g. 21, 75, 99)
	 */
	@Test
	public void shouldConvertTensAndUnitsToWords() throws Exception {
		int n = 21;
		String w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("twenty one", w);
	}

	/*
	 * Tests conversion of numbers greater or equal to 20, lower than 100
	 * without a unit portion - i.e. a full ten number (e.g. 20, 30, 40, ..., 90)
	 */
	@Test
	public void shouldConvertFullTensToWords() throws Exception {
		int n = 90;
		String w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("ninety", w);
	}
	
	/*
	 * Tests lack of support for hundreds and above for now
	 * Although, it should still convert the tens and units portion
	 */
	@Test
	public void shouldIgnoreFullHundredsAndAboveForNow() throws Exception {
		int n = 105;
		String w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("five", w);
	}
	
	// ============================== Exceptions tests
	
	/*
	 * Tests lack of support for negative numbers passed as input
	 */
	@Test(expected = UnsupportedNegativeNumberException.class)
	public void shouldThrowExceptionIfNegative() throws Exception {
		int n = -40;
		String w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("negative forty", w);
	}
	
	/*
	 * Tests lack of support for big numbers (greater than 999,999,999) passed as input
	 */
	@Test(expected = UnsupportedBigNumberException.class)
	public void shouldThrowExceptionIfTooBig() throws Exception {
		int n = 1200300400;
		String w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("one billion two hundred million three hundred thousand four hundred", w);
	}

}
