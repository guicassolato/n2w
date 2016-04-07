package com.worldpay.numbers.n2w.tdd;

import org.junit.Test;

import com.worldpay.numbers.n2w.*;
import com.worldpay.numbers.exceptions.*;

import static org.junit.Assert.*;

public class NumberToWordTest {
	
	/**
	 * Tests conversion of 0 (zero) 
	 */
	@Test
	public void shouldConvertZeroToWord() throws Exception {
		NumberToWord n = new ZeroToWord();
		String w = n.getNumberAsWords();
		
		assertEquals("zero", w);
	}
	
	/**
	 * Tests conversion of simple small positive numbers (&lt;20)
	 */
	@Test
	public void shouldConvertUnitsToWord() throws Exception {
		NumberToWord n = new UnitToWord(1);
		String w = n.getNumberAsWords();
		
		assertEquals("one", w);
	}
	
	/**
	 * Tests conversion of numbers greater or equal to 20, lower than 100
	 * and with unit portion different than zero (e.g. 21, 75, 99)
	 */
	@Test
	public void shouldConvertTensAndUnitsToWords() throws Exception {
		NumberToWord n = new HundredToWord(21);
		String w = n.getNumberAsWords();
		
		assertEquals("twenty-one", w);
	}

	/**
	 * Tests conversion of numbers greater or equal to 20, lower than 100
	 * without a unit portion - i.e. a full ten number (e.g. 20, 30, 40, ..., 90)
	 */
	@Test
	public void shouldConvertFullTensToWords() throws Exception {
		NumberToWord n = new HundredToWord(90);
		String w = n.getNumberAsWords();
		
		assertEquals("ninety", w);
	}
	
	/**
	 * Tests conversion of hundreds
	 */
	@Test
	public void shouldConvertHundredsToWords() throws Exception {
		NumberToWord n = new HundredToWord();
		String w;

		n.setNumber(105);
		w = n.getNumberAsWords();
		
		assertEquals("one hundred and five", w);
		
		n.setNumber(123);
		w = n.getNumberAsWords();
		
		assertEquals("one hundred and twenty-three", w);
		
		n.setNumber(500);
		w = n.getNumberAsWords();
		
		assertEquals("five hundred", w);
	}
	
	/**
	 * Test conversion of thousands
	 */
	@Test
	public void shouldConvertThousandsToWords() throws Exception {
		NumberToWord n = new MillionToWord();
		String w;

		n.setNumber(1005);
		w = n.getNumberAsWords();
		
		assertEquals("one thousand and five", w);
		
		n.setNumber(1042);
		w = n.getNumberAsWords();
		
		assertEquals("one thousand and forty-two", w);
		
		n.setNumber(1105);
		w = n.getNumberAsWords();
		
		assertEquals("one thousand one hundred and five", w);
		
		n.setNumber(566340);
		w = n.getNumberAsWords();
		
		assertEquals("five hundred and sixty-six thousand three hundred and forty", w);
		
		n.setNumber(900000);
		w = n.getNumberAsWords();
		
		assertEquals("nine hundred thousand", w);
		
		n.setNumber(900007);
		w = n.getNumberAsWords();
		
		assertEquals("nine hundred thousand and seven", w);
	}
	
	/**
	 * Test conversion of millions
	 */
	@Test
	public void shouldConvertMillionsToWords() throws Exception {
		NumberToWord n = new MillionToWord();
		String w;

		n.setNumber(56945781);
		w = n.getNumberAsWords();

		assertEquals("fifty-six million nine hundred and forty-five thousand seven hundred and eighty-one", w);
		
		n.setNumber(999999999);
		w = n.getNumberAsWords();
		
		assertEquals("nine hundred and ninety-nine million nine hundred and ninety-nine thousand nine hundred and ninety-nine", w);
		
		n.setNumber(3000000);
		w = n.getNumberAsWords();
		
		assertEquals("three million", w);

		n.setNumber(3000004);
		w = n.getNumberAsWords();
		
		assertEquals("three million and four", w);
		
		n.setNumber(3000017);
		w = n.getNumberAsWords();
		
		assertEquals("three million and seventeen", w);
		
		n.setNumber(3000033);
		w = n.getNumberAsWords();
		
		assertEquals("three million and thirty-three", w);
	}
	
	
	/**
	 * Tests conversion of a null number
	 */
	@Test
	public void shoudThrowExceptionWhenNull() throws Exception {
		NumberToWord n = new MillionToWord();
		String w = n.getNumberAsWords();
		
		assertEquals("zero", w);
	}
	
	/* ============================== Exceptions tests */
	
	/**
	 * Tests lack of support for negative numbers passed as input
	 */
	@Test(expected = UnsupportedSmallNumberException.class)
	public void shouldThrowExceptionIfNegative() throws Exception {
		NumberToWord n = new HundredToWord(-40);
		String w = n.getLimitedNumberAsWords();
		
		assertEquals("negative forty", w);
	}
	
	/**
	 * Tests lack of support for big numbers (greater than 999,999,999) passed as input
	 */
	@Test(expected = UnsupportedBigNumberException.class)
	public void shouldThrowExceptionIfTooBig() throws Exception {
		NumberToWord n = new MillionToWord(1200300400);
		String w = n.getLimitedNumberAsWords();
		
		assertEquals("one billion two hundred million three hundred thousand four hundred", w);
	}

}
