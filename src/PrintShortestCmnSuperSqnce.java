public class PrintShortestCmnSuperSqnce {
	//Problem is to print the shortest common super sequence between two string.
	//The problem is similar to printing longest common sub sequence we just need to make sure,
	//we add common chars once to the result and distinct chars as it is from both the strings.
	//https://leetcode.com/problems/shortest-common-supersequence/submissions/
// 	1092. Shortest Common Supersequence

// Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. 
// If there are multiple valid strings, return any of them.
// A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.

// Example 1:
// Input: str1 = "abac", str2 = "cab"
// Output: "cabac"
// Explanation: 
// str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
// str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
// The answer provided is the shortest such string that satisfies these properties.

// Example 2:
// Input: str1 = "aaaaaaaa", str2 = "aaaaaaaa"
// Output: "aaaaaaaa"

// Constraints:
// 1 <= str1.length, str2.length <= 1000
// str1 and str2 consist of lowercase English letters.


	public static String printShortestCmnSuperSqnce(char [] str1Arr, char [] str2Arr, int n, int m){
		int [][] tabularDpResult = new int [n+1][m+1];
		String result = "";
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
				if(str1Arr[i-1] == str2Arr[j-1])
					tabularDpResult[i][j] = 1 + tabularDpResult[i-1][j-1];
				else
					tabularDpResult[i][j] = Math.max(tabularDpResult[i][j-1], tabularDpResult[i-1][j]);
			}
		}
		//processing the shortest common super sequence result from the table:
		int i = n, j = m;
		while(i>0 && j>0){
			if(str1Arr[i-1] == str2Arr[j-1]){
				result = str1Arr[i-1] + result;
				i--;
				j--;
			}else{
				
				if(tabularDpResult[i][j-1] > tabularDpResult[i-1][j])
				{
					result = str2Arr[j-1] + result;
					j--;
				}else{
					result = str1Arr[i-1] + result;
					i--;
				}
			}
		}
		while(i>0){
			result = str1Arr[i-1] + result;
			i--;
		}
		while(j>0){
			result = str2Arr[j-1] + result;
			j--;
		}
	return result;
	}
	public static void main(String [] args){
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";

		char [] str1Arr = str1.toCharArray();
		char [] str2Arr = str2.toCharArray();

		//Callint printShortestCmnSuperSqnce function to get the shortest common super sequence string:
		System.out.println("The shortest common super sequence between + "+str1+" and "+ str2+ " is: "+
		printShortestCmnSuperSqnce(str1Arr, str2Arr, str1Arr.length, str2Arr.length));
	}
}
