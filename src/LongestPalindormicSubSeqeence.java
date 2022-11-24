public class LongestPalindormicSubSeqeence {
	//Problem is to find the length of longest palindromic sequence
	//This problem can be converted to finding the the length longest common sub sequence between string 1 and string 2.
	//https://leetcode.com/problems/longest-palindromic-subsequence/
// 	516. Longest Palindromic Subsequence

// Given a string s, find the longest palindromic subsequence's length in s.
// A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

// Example 1:
// Input: s = "bbbab"
// Output: 4
// Explanation: One possible longest palindromic subsequence is "bbbb".

// Example 2:
// Input: s = "cbbd"
// Output: 2
// Explanation: One possible longest palindromic subsequence is "bb".
 
// Constraints:
// 1 <= s.length <= 1000
// s consists only of lowercase English letters.

	public static int longestPalindormicSubSeqeence(char [] str1Arr, char [] str2Arr, int n, int m){
		int [][] tabularDpResult = new int [n+1][m+1];

		//Initialization:
		for(int i=0; i<n+1; i++){
			for(int j=0; j<m+1; j++){
				if(i == 0 || j == 0){
					tabularDpResult[i][j] = 0;
				}
			}
		}

		//bottom up iterative solution:
		for(int i=1; i<n+1; i++){
			for(int j=1; j<m+1; j++){
				if(str1Arr[i-1] == str2Arr[j-1]){
					tabularDpResult[i][j] = 1 + tabularDpResult[i-1][j-1];
				}else{
					tabularDpResult[i][j] = Math.max(tabularDpResult[i][j-1] , tabularDpResult[i-1][j]);
				}
			}
		}
		return tabularDpResult[n][m];
	}

	public static void main(String [] args){
		String palStr = "bbbab";
		
		char [] str1Arr = palStr.toCharArray();
		char [] str2Arr = new char[str1Arr.length];

		//reverse the string 'palStr'
		for(int i=0,j=str1Arr.length-1; i<str1Arr.length; i++,j--){
			str2Arr[i] = str1Arr[j];
		}
		//Calling the longestPalindormicSubSeqeence function:
		System.out.println("the length of longest palindormic string in "+ palStr+ " is: "+ 
		longestPalindormicSubSeqeence(str1Arr, str2Arr, str1Arr.length, str2Arr.length));
	}
}
