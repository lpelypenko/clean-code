package com.b.simple.design.business.text;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.b.simple.design.business.text.TextHelper;

public class TextHelperTest {

	TextHelper helper = new TextHelper();
	
	@Test
	public void testSwapLastTwoCharacters() {
		assertEquals("",helper.swapLastTwoCharacters(""));
		assertEquals("A",helper.swapLastTwoCharacters("A"));
		assertEquals("BA",helper.swapLastTwoCharacters("AB"));
		assertEquals("RANI",helper.swapLastTwoCharacters("RAIN"));
	}

	@Test
	public void testTruncateAInFirst2Positions() {
		assertEquals("",helper.truncateAInFirst2Positions(""));
		assertEquals("BCD",helper.truncateAInFirst2Positions("ABCD"));
		assertEquals("CD",helper.truncateAInFirst2Positions("AACD"));
		assertEquals("BCD",helper.truncateAInFirst2Positions("BACD"));
		assertEquals("BBAA",helper.truncateAInFirst2Positions("BBAA"));
		assertEquals("",helper.truncateAInFirst2Positions("A"));
		assertEquals("",helper.truncateAInFirst2Positions("AA"));
	}

	@Test
	public void testTruncateAInFirst2PositionsAttempt1() {
		assertEquals("",helper.truncateAInFirst2PositionsAttempt1(""));
		assertEquals("BCD",helper.truncateAInFirst2PositionsAttempt1("ABCD"));
		assertEquals("CD",helper.truncateAInFirst2PositionsAttempt1("AACD"));
		assertEquals("BCD",helper.truncateAInFirst2PositionsAttempt1("BACD"));
		assertEquals("BBAA",helper.truncateAInFirst2PositionsAttempt1("BBAA"));
		assertEquals("",helper.truncateAInFirst2PositionsAttempt1("A"));
		assertEquals("",helper.truncateAInFirst2PositionsAttempt1("AA"));
	}

	@Test
	public void testTruncateAInFirst2PositionsAttempt2() {
		assertEquals("",helper.truncateAInFirst2PositionsAttempt2(""));
		assertEquals("BCD",helper.truncateAInFirst2PositionsAttempt2("ABCD"));
		assertEquals("CD",helper.truncateAInFirst2PositionsAttempt2("AACD"));
		assertEquals("BCD",helper.truncateAInFirst2PositionsAttempt2("BACD"));
		assertEquals("BBAA",helper.truncateAInFirst2PositionsAttempt2("BBAA"));
		assertEquals("",helper.truncateAInFirst2PositionsAttempt2("A"));
		assertEquals("",helper.truncateAInFirst2PositionsAttempt2("AA"));
	}
}
