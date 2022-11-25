public class SequencePatternMatching {
//Problem definition:
// https://www.youtube.com/watch?v=QVntmksK2es&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=30
// 	Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

// A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

// Example 1:
// Input: s = "abc", t = "ahbgdc"
// Output: true

// Example 2:
// Input: s = "axc", t = "ahbgdc"
// Output: false
	public static boolean sequencePatternMatching(char [] str1Arr, char [] str2Arr, int n, int m){
		int [][] tabularDpResult = new int [n+1][m+1];

		//initialization
		for(int i=0; i<n+1; i++){
			for(int j=0; j<m+1; j++){
				if(i == 0 || j == 0)
					tabularDpResult[i][j] = 0;
			}
		}
		
		//Bottom up iterative logic:
		for(int i=1; i<n+1; i++){
			for(int j=1; j<m+1; j++){
				if(str1Arr[i-1] == str2Arr[j-1])
					tabularDpResult[i][j] = 1 + tabularDpResult[i-1][j-1];
				else
					tabularDpResult[i][j] = Math.max(tabularDpResult[i][j-1], tabularDpResult[i-1][j]);
			}
		}
		if(tabularDpResult[n][m] == m)
			return true;
		return false;
	}
	public static void main(String [] args){
		String str1 = "ahbgdc";
		String str2 = "abc";

		char [] str1Arr = str1.toCharArray();
		char [] str2Arr = str2.toCharArray();

		//Calling sequencePatternMatching to check if str2 is present in str1 or not:
		System.out.println("if "+ str2 + " is present in "+ str1 + " is found as: "+ 
		sequencePatternMatching(str1Arr, str2Arr, str1Arr.length, str2Arr.length));
	}
}
