import java.util.*;
public class LngstCmnSubSqnce {
// 	Given two sequences, find the length of longest subsequence present in both of them.
// 	A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. 
// 	For example, “abc”,  “abg”, “bdf”, “aeg”,  ‘”acefg”, .. etc are subsequences of “abcdefg”.	
// 	PROBLEM STATEMENT LINK: https://leetcode.com/problems/longest-common-subsequence/

//LeetCode Description:
// 1143. Longest Common Subsequence

// Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
// A subsequence of a string is a new string generated from the original string with some characters (can be none),
// deleted without changing the relative order of the remaining characters.
// For example, "ace" is a subsequence of "abcde".
// A common subsequence of two strings is a subsequence that is common to both strings.

// Example 1:
// Input: text1 = "abcde", text2 = "ace" 
// Output: 3  
// Explanation: The longest common subsequence is "ace" and its length is 3.

// Example 2:
// Input: text1 = "abc", text2 = "abc"
// Output: 3
// Explanation: The longest common subsequence is "abc" and its length is 3.

// Example 3:
// Input: text1 = "abc", text2 = "def"
// Output: 0
// Explanation: There is no such common subsequence, so the result is 0.
 
// Constraints:
// 1 <= text1.length, text2.length <= 1000
// text1 and text2 consist of only lowercase English characters.

/*********************************************************Solution*************************************************************************/
// How to change the input into smaller input using recurrsion: 
	//Things to condiser in recurrsive solution:
	//1. Base condition (exit creteria) --> Think of the smallest valid input
		// n = 0, m = 0 : as string can at least be empty.
	//2. Choice Diagram:
	//				text1: [0,1,2,....n] text2: [0,1,2,.....m]
	//					/									\
	//		if(text1[n] == text2[m])					(	Else	)
	//					|								/			\
	//		LCS(text1[n-1],text2[m-1])		LCS(text[n],text[m-1])	LCS(text[n-1],text[m])


public static int longestCommonSubSequence(String text1 , String text2){
	int n = text1.length();
	int m = text2.length();
	
	int [][] memo = new int [n+1][m+1];
	for(int i=0;i<n+1;i++){
		Arrays.fill(memo[i],-1);
		//System.out.println(Arrays.toString(memo[i]));
	}
	char [] setSeqArr = text1.toCharArray();
	char [] setSubSeqArr = text2.toCharArray();
	
	//Calling recurrsive solution for longest common subsequence:
	//return lngstCmnSubSqnceRecurr(setSeqArr, setSubSeqArr, n, m);

	//Calling recurrsive memoized solution for longest common subsequence:
	//return lngstCmnSubSqnceRecurrMemo(setSeqArr, setSubSeqArr, n, m, memo);

	//Calling  the longestCommonSubStringRetStr function:
	System.out.println("longestCommonSubStringRetStr returns the longest common sub string as: "+
	longestCommonSubStringRetStr(setSeqArr,setSubSeqArr, setSeqArr.length, setSubSeqArr.length));
	
	//Calling tabular bottom up Solution
	return lngstCmnSubSqnceTabular(setSeqArr, setSubSeqArr, n, m);

	
}

//Recurrsive solution
public static int lngstCmnSubSqnceRecurr(char [] setSeqArr, char [] setSubSeqArr, int n, int m){
	//base condition:
	if(n == 0 || m == 0){
		return 0;
	}

	//Choide diagram code:
	if(setSeqArr[n-1] == setSubSeqArr[m-1]){
		return (1 + lngstCmnSubSqnceRecurr(setSeqArr, setSubSeqArr, n-1, m-1));
	}
	return Math.max(lngstCmnSubSqnceRecurr(setSeqArr,setSubSeqArr,n,m-1), 
		lngstCmnSubSqnceRecurr(setSeqArr, setSubSeqArr, n-1, m));
}
//Recurrsive solution with memoization: --> this is a topDownApproach 
//{memo table depends on the variables that change in the recurrsive call}
public static int lngstCmnSubSqnceRecurrMemo(char [] setSeqArr, char [] setSubSeqArr, int n, int m, int[][] memo){
	//base condition:
	if(n == 0 || m == 0){
		return 0;
	}
	//check if memo has the solution for this subproblem
	if(memo[n][m] != -1)
		return memo[n][m];

	//Choide diagram code:
	if(setSeqArr[n-1] == setSubSeqArr[m-1]){
		memo[n][m] = (1 + lngstCmnSubSqnceRecurrMemo(setSeqArr, setSubSeqArr, n-1, m-1,memo));
	}else{
		memo[n][m] =  Math.max(lngstCmnSubSqnceRecurrMemo(setSeqArr,setSubSeqArr,n,m-1,memo), 
		lngstCmnSubSqnceRecurrMemo(setSeqArr, setSubSeqArr, n-1, m, memo));
	}
	return memo[n][m];
}
//Tabular (BottomUp DP Solution for Longest common subsequence)
public static int lngstCmnSubSqnceTabular(char [] setSeqArr, char [] setSubSeqArr, int n, int m){
	int [][] bottomUpResult = new int [n+1][m+1];
	
	//Initialization (Bottom up):
	for(int i=0; i<n+1; i++){
		for(int j=0; j<m+1; j++){
			if(i == 0 || j == 0){
				bottomUpResult[i][j] = 0;
			}
		}
	}

	//Bottom up tabular solution:
	for(int i=1; i<n+1; i++){
		for(int j=1; j<m+1; j++){
			if(setSeqArr[i-1] == setSubSeqArr[j-1]){
				bottomUpResult[i][j] = 1 + bottomUpResult[i-1][j-1];
			}else{
				bottomUpResult[i][j] = Math.max(bottomUpResult[i][j-1], bottomUpResult[i-1][j]);
			}
		}
	}
	return bottomUpResult[n][m];
}

public static String longestCommonSubStringRetStr(char [] str1Arr, char [] str2Arr, int n, int m){
	int [][] tabularResult = new int[n+1][m+1];
	String result = ""; 

	//initialization:
	for (int i=0; i<n+1; i++){
		for(int j=0; j<m+1; j++){
			if(i==0 || j==0){
				tabularResult[i][j] = 0;
			}
		}
	}
	//Bottom Up tabular - iterative solution
	for(int i=1; i<n+1; i++){
		for(int j=1	; j<m+1; j++){
			if(str1Arr[i-1] == str2Arr[j-1]){
				tabularResult[i][j] = 1 + tabularResult[i-1][j-1];
			}else{
				tabularResult[i][j] = Math.max(tabularResult[i][j-1], tabularResult[i-1][j]);
			}
			
		}
	}
	//getting the string result from the table:
	int i = n, j = m;
	while(i>0 && j>0){
		if(str1Arr[i-1] == str2Arr[j-1]){
			result = str1Arr[i-1] + result;
			i--;
			j--;
		}else{
				if(tabularResult[i][j-1] > tabularResult[i-1][j])
					j--;
				else
					i--;

		}
	}
	return result;
}
public static void main(String [] args){
	String text1 = "abcde";
	String text2 = "ace";

	//Calling the function to get longestCommonSubSequence length count.
	System.out.println("longestCommonSubSequence gives the result as: "+ longestCommonSubSequence(text1, text2));
}

}
