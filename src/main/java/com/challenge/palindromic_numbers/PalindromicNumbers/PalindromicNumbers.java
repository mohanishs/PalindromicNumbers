package com.challenge.palindromic_numbers.PalindromicNumbers;

import java.util.HashMap;
import java.util.Map;

public class PalindromicNumbers {

	private static final int BASE_RANGE_LOW = 2;
	private static final int BASE_RANGE_HIGH = 36;

	protected static Map<Integer, Integer> calculatePalindromicNumbers(int n) throws Exception {

		if (n < 0 || n > Integer.MAX_VALUE)
			throw new Exception("Input Error : value of n should be a non-negative int");

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int number = 0; number <= n; number++) {
			for (int base = BASE_RANGE_LOW; base <= BASE_RANGE_HIGH; base++) {
				if (isPalindrome(convertBase(number, base))) {
					map.put(number, base);
					break;
				}
			}
		}

		return map;
	}

	protected static String convertBase(int number, int base) throws Exception {
		if (base < 2 || base > 36)
			throw new Exception("Input Error : base value needs to be between 2 <= base <= 36");

		return Integer.toString(number, base);
	}

	protected static boolean isPalindrome(String str) {
		return str.equals(new StringBuilder(str).reverse().toString());
	}

	public static void main(String[] args) {
		try {
			Map<Integer, Integer> palindromicNumbersMap = calculatePalindromicNumbers(1000);

			for (Map.Entry<Integer, Integer> entry : palindromicNumbersMap.entrySet()) {
				System.out.println(entry.getKey() + " " + entry.getValue());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
