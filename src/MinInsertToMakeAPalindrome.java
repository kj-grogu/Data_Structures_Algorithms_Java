public class MinInsertToMakeAPalindrome {
  //https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
//   1312. Minimum Insertion Steps to Make a String Palindrome
// Given a string s. In one step you can insert any character at any index of the string.
// Return the minimum number of steps to make s palindrome.
// A Palindrome String is one that reads the same backward as well as forward.

// Example 1:
// Input: s = "zzazz"
// Output: 0
// Explanation: The string "zzazz" is already palindrome we do not need any insertions.

// Example 2:
// Input: s = "mbadm"
// Output: 2
// Explanation: String can be "mbdadbm" or "mdbabdm".

// Example 3:
// Input: s = "leetcode"
// Output: 5
// Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 
// Constraints:
// 1 <= s.length <= 500
// s consists of lowercase English letters.

  public static int minInsertToMakeAPalindrome(char [] str1Arr, char [] str2Arr, int n, int m){
    int [][] tabularDpResult = new int [n+1][m+1];
    
    //Initialization
    for(int i=0; i<n+1; i++){
      for(int j=0; j<m+1; j++){
          if(i == 0 || j == 0)
              tabularDpResult[i][j] = 0;
      }
    }
    
    //iterative solution bottom up:
    for(int i=1; i<n+1; i++){
        for(int j=1; j<m+1; j++){
            if(str1Arr[i-1] == str2Arr[j-1])
                tabularDpResult[i][j] = 1 + tabularDpResult[i-1][j-1];
            else
                tabularDpResult[i][j] = Math.max(tabularDpResult[i][j-1], tabularDpResult[i-1][j]);
        }
    }
    if(tabularDpResult[n][m] == n)
        return 0;
    else
      return (n - tabularDpResult[n][m]);
  }
  public static void main(String [] args){
	String s = "zzazz";
	char [] str1Arr = s.toCharArray();
        char [] str2Arr = new char[s.length()];
        
        for(int i=0,j=s.length()-1; j>=0; i++,j--){
          str2Arr[i] = str1Arr[j];
        }
      
		//Calling minInsertToMakeAPalindrome to get the no of insertions to be made to a string to make a palindrome:
      System.out.println("No of intertion to be made to string "+ s + " to make it a palindrome is: " +
	  			minInsertToMakeAPalindrome(str1Arr, str2Arr, str1Arr.length, str2Arr.length));

  }
}
