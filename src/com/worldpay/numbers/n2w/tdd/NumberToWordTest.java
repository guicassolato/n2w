package com.worldpay.numbers.n2w.tdd;

import org.junit.Test;
import static org.junit.Assert.*;

public class NumberToWordTest {
	
	@Test
	public void shouldConvertSmallNumberToWord() throws Exception {
		long n = 8;
		String w = "";
		
		assertEquals("eight", w);
	}

}
