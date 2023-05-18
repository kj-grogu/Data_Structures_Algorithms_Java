import java.util.Arrays;

public class MultiplyStrings {
	// 43. Multiply Strings
	// https://leetcode.com/problems/multiply-strings/

	// Given two non-negative integers num1 and num2 represented as strings,
	// return the product of num1 and num2, also represented as a string.
	// Note: You must not use any built-in BigInteger library or convert the inputs
	// to integer directly.

	// Example 1:
	// Input: num1 = "2", num2 = "3"
	// Output: "6"

	// Example 2:
	// Input: num1 = "123", num2 = "456"
	// Output: "56088"

	// Constraints:
	// 1 <= num1.length, num2.length <= 200
	// num1 and num2 consist of digits only.
	// Both num1 and num2 do not contain any leading zero, except the number 0
	// itself.

	public static String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0"))
			return "0";

		num1 = new StringBuilder(num1).reverse().toString();
		num2 = new StringBuilder(num2).reverse().toString();

		// System.out.println("num1: "+ num1 + " num2: "+ num2);

		char[] num1Arr = num1.toCharArray();
		char[] num2Arr = num2.toCharArray();

		int[] res = new int[num1.length() + num2.length()];
		Arrays.fill(res, 0);

		for (int i1 = 0; i1 < num1.length(); i1++) {
			for (int i2 = 0; i2 < num2.length(); i2++) {
				int digit = (Integer.parseInt(String.valueOf(num1Arr[i1]))
						* Integer.parseInt(String.valueOf(num2Arr[i2])));
				res[i1 + i2] += digit;
				res[i1 + i2 + 1] += (res[i1 + i2] / 10);
				res[i1 + i2] = (res[i1 + i2] % 10);
			}
		}
		String result = "";
		int j = res.length - 1;
		while (j >= 0) {
			if (res[j] != 0)
				break;
			j--;
		}
		while (j >= 0) {
			result = result + res[j];
			j--;
		}
		return result;
	}

	public static void main(String[] args) {
		String num1 = "123";
		String num2 = "456";

		System.out
				.println("the multipication of " + num1 + " and " + num2 + " is: "
						+ MultiplyStrings.multiply(num1, num2));
	}

}