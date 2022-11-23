public class MinNumInsertionDeletion {
	//https://www.geeksforgeeks.org/minimum-number-deletions-insertions-transform-one-string-another/
	public static void minNumInsertionDeletion(char [] str1Arr, char [] str2Arr, int n, int m){
		int [][] tabularDpResult = new int [n+1][m+1];
		int numInsertion = 0;
		int numDeletion = 0;

		//initialization:
		for(int i=0; i<n+1; i++){
			for(int j=0; j<m+1; j++){
				if(i == 0 || j == 0)
					tabularDpResult[i][j] = 0;
			}
		}

		//Bottom up iterative solution:
		for(int i=1; i<n+1; i++){
			for (int j=1; j<m+1; j++){
				if(str1Arr[i-1] == str2Arr[j-1]){
					tabularDpResult[i][j] = 1 + tabularDpResult[i-1][j-1];
				}else{
					tabularDpResult[i][j] = Math.max(tabularDpResult[i][j-1], tabularDpResult[i-1][j]);
				}
			}
		}
		numDeletion = n - tabularDpResult[n][m];
		numInsertion = m - tabularDpResult[n][m];

		//Printing the number of insertion or deletion required to convert str1 to str2
		System.out.println("minimum no. of deletion reqired: "+ numDeletion);
		System.out.println("minimum no. of insertion required: "+ numInsertion);
	}
	public static void main(String [] args){
		String str1 = "geeksforgeeks";
		String str2 = "geeks";

		char [] str1Arr = str1.toCharArray();
		char [] str2Arr = str2.toCharArray();

		minNumInsertionDeletion(str1Arr, str2Arr, str1Arr.length, str2Arr.length);
	}
}
