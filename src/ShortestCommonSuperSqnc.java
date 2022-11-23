public class ShortestCommonSuperSqnc {
	//https://www.geeksforgeeks.org/shortest-common-supersequence/
	public static int shortestCommonSuperSqnc(char [] str1Arr, char [] str2Arr, int n, int m){
		int [][] tabularDpResult = new int [n+1][m+1];

		//initialization
		for(int i=0; i<n+1; i++){
			for(int j=0; j<m+1; j++){
				if(i == 0 || j == 0)
				tabularDpResult[i][j] = 0;
			}
		}

		//tabular bottom up logic - iterative
		for(int i=1; i<n+1; i++){
			for(int j=1; j<m+1; j++){
				if(str1Arr[i-1] == str2Arr[j-1]){
					tabularDpResult[i][j] = 1 + tabularDpResult[i-1][j-1];
				}else{
					tabularDpResult[i][j] = Math.max(tabularDpResult[i][j-1], tabularDpResult[i-1][j]);
				}
			}
		}
		//logic to get super sequence out of the sub sequence 
		return (n+m - tabularDpResult[n][m]);
	}
	public static void main (String [] args){
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";

		char [] str1Arr = str1.toCharArray();
		char [] str2Arr = str2.toCharArray();

		//Printing the length of SCSS among str1 and str2:
		System.out.println("The shortest common super sequence in "+ str1 + " and " + str2 + " is: "+ 
		shortestCommonSuperSqnc(str1Arr, str2Arr, str1Arr.length, str2Arr.length));
	}
}
