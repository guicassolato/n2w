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
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void shouldThrowExceptionIfTwentyOrGrater() throws Exception {
		int n = 23;
		String w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("twenty three", w);
	}
	
	@Test(expected = UnsupportedNegativeNumberException.class)
	public void shouldThrowExceptionIfNegative() throws Exception {
		int n = -40;
		String w = NumberToWord.getNumberAsWords(n);
		
		assertEquals("forty", w);
	}

}
