package com.bpedroso.challenge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class FindVowelTest {

	private static final String INPUT_CHAR_WITH_ONE_VALID_RESULT = "aAbBABacafe";
	
	private static final String INPUT_CHAR_WITH_TWO_VALID_RESULTS = "aAbBABadicafe";
	
	private static final String INPUT_CHAR_WITHOUT_VALID_RESULT = "aAbBABacafj";

	@Test(expected=VowelNotFoundException.class)
	public void findChar_inputWithoutValidResult_throwsException() throws VowelNotFoundException {
		FindVowel.firstChar(new Stream() {
			int index = 0;
			public char next() {
				return INPUT_CHAR_WITHOUT_VALID_RESULT.charAt(index++);
			}
			public boolean hasNext() {
				return index < INPUT_CHAR_WITHOUT_VALID_RESULT.length();
			}
		});
	}
	
	@Test
	public void findChar_inputWithOneValidResult_oneValidResult() throws VowelNotFoundException {
		char actualChar = FindVowel.firstChar(new Stream() {
			int index = 0;
			public char next() {
				return INPUT_CHAR_WITH_ONE_VALID_RESULT.charAt(index++);
			}
			public boolean hasNext() {
				return index < INPUT_CHAR_WITH_ONE_VALID_RESULT.length();
			}
		});
		assertEquals('e', actualChar);
	}
	
	@Test
	public void findChar_inputWithTwoValidResults_firstValidResult() throws VowelNotFoundException {
		char actualChar = FindVowel.firstChar(new Stream() {
			int index = 0;
			public char next() {
				return INPUT_CHAR_WITH_TWO_VALID_RESULTS.charAt(index++);
			}
			public boolean hasNext() {
				return index < INPUT_CHAR_WITH_TWO_VALID_RESULTS.length();
			}
		});
		assertNotEquals('e', actualChar);
		assertEquals('i', actualChar);
	}

}
