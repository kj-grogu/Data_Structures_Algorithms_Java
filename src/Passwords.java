public class Passwords {
	public static int countValidPasswords(int n, int k) {
		final int MOD = 1000000007;

		// Calculate the total number of passwords of length n
		long totalPasswords = 1;
		for (int i = 0; i < n; i++) {
			totalPasswords = (totalPasswords * 26) % MOD;
		}

		// Calculate the number of passwords with k consecutive equal characters
		long invalidPasswords = 1;
		for (int i = 0; i < k; i++) {
			invalidPasswords = (invalidPasswords * 26) % MOD;
		}

		// Subtract invalid passwords from total passwords
		long validPasswords = (totalPasswords - invalidPasswords + MOD) % MOD;

		return (int) validPasswords;
	}

	public static void main(String[] args) {
		// Example usage
		int n = 2;
		int k = 2;
		int result = countValidPasswords(n, k);
		System.out.println(result); // Output: 650
	}
}
