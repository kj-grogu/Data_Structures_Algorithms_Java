import java.util.*;
public class SelfDescriptiveNumber {
// Java code to implement the approach

static boolean isSelfDescriptiveNumber(int num)
{
	String str = String.valueOf(num);
	int i;
	int[] freq = new int[10];
	for (i = 0; i < 10; i++)
	freq[i] = 0;

	while (num > 0) {
	freq[num % 10]++;
	num /= 10;
	}

	for (i = 0; i < str.length(); i++)
	if (freq[i] != str.charAt(i) - '0')
		return false;

	return true;
}

public static void main(String[] args)
{
	//int N = 2020;
	//int N = 1210;
	int N = 2022;
	// for (int i = 1; i <= N; i++)
	// if (isSelfDescriptiveNumber(i))
	// 	System.out.println(i);
	if (isSelfDescriptiveNumber(N))
	 	System.out.println(N + " is self Sescriptive: "+ " 1");
	else
		System.out.println(N + " is not self Sescriptive: "+ " 0");
}

}

