
public class LongestCommonSubString {
	public static int longestCommonSubString(char [] str1Arr, char [] str2Arr, int n, int m){
		int [][] tabularResult = new int[n+1][m+1];
		int result = 0; 

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
					result = Math.max(result, tabularResult[i][j]);
				}else{
					tabularResult[i][j] = 0;
				}
				
			}
		}
		return result;
	}
	
	public static void main(String [] args){
		String str1 = "GeeksforGeeks";
		String str2 = "GeeksQuiz";

		char [] str1Arr = str1.toCharArray();
		char [] str2Arr = str2.toCharArray();

		//Calling  the longestCommonSubString function:
		System.out.println("longestCommonSubString returns the length of longest common sub string as: "+
		longestCommonSubString(str1Arr,str2Arr, str1Arr.length, str2Arr.length));

	}
}
