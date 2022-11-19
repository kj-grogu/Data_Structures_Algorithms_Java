import java.util.Arrays;
//Unbounded knapSack - DP Example:
//https://www.youtube.com/watch?v=SZqAQLjDsag&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=17
public class RodCuttingDP {
	//Given a rod of length 'n' and an array denoting the profits for each length. 
	//Please find the locations at which the cuts are to be made for maximum profit.

	//“Given a rod of length n inches and a table of prices pi for i = 1, 2, …, n, 
	//determine the maximum revenue rn obtainable by cutting up the rod and selling the pieces. 
	//If the price pn for a rod of length n is large enough, an optimal solution might require no cutting at all.”


	//For example, if length[ ] = {2, 1} and value[ ] = {1, 1} and n = 3, 
	//maximum profit = 3 is when we include 3 rods of length 1.

	public static int rodCutting(int [] lengths, int[] prices, int n){
		
		int [][] topDownResult = new int [n + 1][n + 1];
		
		//Initialization
		for(int i=0;i<n+1; i++){
			for(int j=0; j<n + 1; j++){
				{
					if(i == 0 || j == 0)
					topDownResult[i][j] = 0;
				}
			}
		}

		//Topdown approach to solve rodcutting problem
		for(int i=1; i<n + 1; i++){
			for(int j=1; j<n + 1; j++){
				if(lengths[i-1] <= j)
				{
					int remainder = j - lengths[i-1];
					topDownResult[i][j] = Math.max(prices[i-1]+ topDownResult[i][remainder], topDownResult[i-1][j]);
				}else
				topDownResult[i][j] = topDownResult[i-1][j];
			}
		}
		for(int i=0; i<n; i++){
			System.out.println(Arrays.toString(topDownResult[i]));
		}
		return topDownResult[n][n];
	}
	public static void main(String [] args){
		int [] lengths = {1,2,3,4,5,6,7,8,9,10};
		int [] prices = {1,5,8,9,10,17,17,20,24,30};
		int n = 4;
		System.out.println("maximum profit that can be attained after cutting rod of length "+ n + " is:"+ rodCutting(lengths, prices, n));
	}
}
