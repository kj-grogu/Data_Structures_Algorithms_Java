public class LongestRepeatingSubSequence {
	//Longest Repeating Subsequence
//https://www.geeksforgeeks.org/longest-repeating-subsequence/
// Given a string, print the longest repeating subsequence  
// such that the two subsequence don’t have same string character at same position, 
// i.e., any i’th character in the two subsequences shouldn’t have the same index in the original string.
// Example:
// Input: str = "aab"
// Output: "a"
	public static int longestRepeatingSubSequence(char [] str1Arr, char [] str2Arr, int n, int m){
		int [][] tabularDpResult = new int [n+1][m+1];

		//initialization:
		for(int i=0; i<n+1; i++){
			for(int j=0; j<m+1; j++){
				if(i == 0 || j == 0)
					tabularDpResult[i][j] = 0;
			}
		}

		//bottom up iterative solution:
		for(int i=1; i<n+1; i++){
			for(int j=1; j<m+1; j++){
				if(str1Arr[i-1] == str2Arr[j-1] && i != j) // only change from the LCS logic: (i!=j)
					tabularDpResult[i][j] = 1 + tabularDpResult[i-1][j-1];
				else
					tabularDpResult[i][j] = Math.max(tabularDpResult[i][j-1], tabularDpResult[i-1][j]);
			}
		}
		return tabularDpResult[n][m];
	}
	public static void main(String [] args){
		String str = "abacbc";

		char [] strArr = str.toCharArray();

		//Calling LongestRepeatingSubSequence function to get the length of longest repeating subsequence
		System.out.println("the length of longest repeating subsequence in "+ str + " is: "+
		longestRepeatingSubSequence(strArr, strArr, strArr.length, strArr.length));
	}
}
