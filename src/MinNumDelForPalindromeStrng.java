public class MinNumDelForPalindromeStrng {
	//The problem here is to find the minimum no of deletion that is needed to be done in a string to make it a palindrome
	//This problem can be converted to find the length of the longest palindrome string in a given string and
	//substracting that length from the length of the actual given string to get the minimum no of deletion.
	
	//https://www.geeksforgeeks.org/minimum-number-deletions-make-string-palindrome/

	public static int minNumDelForPalindromeStrng(char [] str1Arr, char [] str2Arr, int n, int m){
		int [][] tabularDpResult = new int [n+1][m+1];

		//Initialization:
		for(int i=0;i<n+1;i++){
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

		return n - tabularDpResult[n][m];
	}
	public static void main(String [] args){
		String str = "aebcbda";
		char [] str1Arr = str.toCharArray();
		char [] str2Arr = new char [str1Arr.length];

		for(int i=0,j=str1Arr.length-1; i<str1Arr.length; i++,j--){
			str2Arr[i] = str1Arr[j];
		}
	//Calling the minNumDelForPalindromeStrng function to get the minimum number of deletions required to get a palindrome string 
		System.out.println("minimum no. of. deletions to be done to "+ str +" to get a palindrome string are: "+
		minNumDelForPalindromeStrng(str1Arr, str2Arr, str1Arr.length, str2Arr.length));
	}
}
