package com.worldpay.numbers.n2w.tdd;

import org.junit.Test;

import com.worldpay.numbers.n2w.NumberToWord;
import com.worldpay.numbers.exceptions.*;

import static org.junit.Assert.*;

public class NumberToWordTest {
	
	@Test
	public void shouldConvertSmallNumberToWord() throws Exception {
		int n = 8;
		String w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("eight", w);
	}
	
	@Test
	public void shouldConvertTensAndUnitsToWords() throws Exception {
		int n = 72;
		String w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("seventy two", w);
	}

	@Test
	public void shouldConvertFullTensToWords() throws Exception {
		int n = 90;
		String w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("ninety", w);
	}
	
	@Test
	public void shouldConvertZeroToWord() throws Exception {
		int n = 0;
		String w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("zero", w);
	}
	
	@Test
	public void shouldIgnoreFullHundredsAndAboveForNow() throws Exception {
		int n = 1399;
		String w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("ninety nine", w);
	}
	
	@Test(expected = UnsupportedNegativeNumberException.class)
	public void shouldThrowExceptionIfNegative() throws Exception {
		int n = -40;
		String w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("forty", w);
	}
	
	@Test(expected = UnsupportedBigNumberException.class)
	public void shouldThrowExceptionIfTooBig() throws Exception {
		int n = 1200300400;
		String w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("one billion two hundred million three hundred thousand four hundred", w);
	}

}
