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
		
		assertEquals("twenty-one", w);
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
	 * Tests conversion of hundreds
	 */
	@Test
	public void shouldConvertHundredsToWords() throws Exception {
		int n = 105;
		String w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("one hundred and five", w);
		
		n = 123;
		w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("one hundred and twenty-three", w);
		
		n = 500;
		w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("five hundred", w);
	}
	
	/*
	 * Test conversion of thousands
	 */
	@Test
	public void shouldConvertThousandsToWords() throws Exception {
		int n = 1005;
		String w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("one thousand and five", w);
		
		n = 1042;
		w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("one thousand and forty-two", w);
		
		n = 1105;
		w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("one thousand one hundred and five", w);
		
		n = 566340;
		w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("five hundred and sixty-six thousand three hundred and forty", w);
		
		n = 900000;
		w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("nine hundred thousand", w);
		
		n = 900007;
		w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("nine hundred thousand and seven", w);
	}
	
	/*
	 * Test conversion of millions
	 */
	@Test
	public void shouldConvertMillionsToWords() throws Exception {
		int n = 56945781;
		String w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("fifty-six million nine hundred and forty-five thousand seven hundred and eighty-one", w);
		
		n = 999999999;
		w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("nine hundred and ninety-nine million nine hundred and ninety-nine thousand nine hundred and ninety-nine", w);
		
		n = 3000000;
		w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("three million", w);

		n = 3000004;
		w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("three million and four", w);
		
		n = 3000017;
		w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("three million and seventeen", w);
		
		n = 3000033;
		w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("three million and thirty-three", w);
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
