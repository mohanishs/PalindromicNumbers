package com.challenge.palindromic_numbers.PalindromicNumbers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

public class PalindromicNumbersTests {

	@Test
	public void testIsPalindrome() throws Exception {
		assertTrue(PalindromicNumbers.isPalindrome("5"));
		assertTrue(PalindromicNumbers.isPalindrome("10101"));
		assertTrue(PalindromicNumbers.isPalindrome("213312"));
	}

	@Test
	public void testIsNotAPallindrome() {
		assertFalse(PalindromicNumbers.isPalindrome("122"));
		assertFalse(PalindromicNumbers.isPalindrome("0001110000"));
	}

	@Test(expected = Exception.class)
	public void testcalculatePalindromicNumbers_forWrongInput() throws Exception {
		PalindromicNumbers.calculatePalindromicNumbers(-1000);
		PalindromicNumbers.calculatePalindromicNumbers(2147483647 + 10);
	}

	@Test
	public void testCalculatePalindromicNumbers_againstKnownValues_input1() throws Exception {
		Map<Integer, Integer> map = PalindromicNumbers.calculatePalindromicNumbers(5);
		assertThat(map.get(0), is(2));
		assertThat(map.get(1), is(2));
		assertThat(map.get(2), is(3));
		assertThat(map.get(3), is(2));
		assertThat(map.get(4), is(3));
		assertThat(map.get(5), is(2));
	}

	@Test
	public void testCalculatePalindromicNumbers_againstKnownValues_input2() throws Exception {
		Map<Integer, Integer> map = PalindromicNumbers.calculatePalindromicNumbers(1000);
		assertThat(map.get(100), is(3));
		assertThat(map.get(200), is(7));
		assertThat(map.get(300), is(7));
		assertThat(map.get(400), is(3));
		assertThat(map.get(500), is(24));
		assertThat(map.get(600), is(29));
		assertThat(map.get(700), is(12));
		assertThat(map.get(800), is(7));
		assertThat(map.get(900), is(14));
		assertThat(map.get(1000), is(9));
	}

	@Test(expected = Exception.class)
	public void testConvertBase_forWrongInput() throws Exception {
		PalindromicNumbers.convertBase(25, 37);
		PalindromicNumbers.convertBase(25, 1);
	}

	@Test
	public void testConvertBase_againstKnownValues() throws Exception {
		assertThat(PalindromicNumbers.convertBase(25, 2), is("11001"));
		assertThat(PalindromicNumbers.convertBase(500, 6), is("2152"));
		assertThat(PalindromicNumbers.convertBase(777, 24), is("189"));
		assertThat(PalindromicNumbers.convertBase(1000, 30), is("13a"));
	}
}
