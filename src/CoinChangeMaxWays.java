public class CoinChangeMaxWays {
	//Coin change problem - variation unbounded knapsack 
	public static int coinChangeMaxWays(int [] coins, int target){
		int n = coins.length;
		int [][] topDownResult = new int [n + 1][target + 1];

		//Initialization:
		for(int i=0; i<n + 1; i++){
			for(int j=0; j<target + 1; j++){
				if(i == 0)
					topDownResult[i][j] = 0;
				if( j == 0)
					topDownResult[i][j] = 1;
			}
		}

		//TopDown unbounded dp approach:
		for(int i=1; i<n+1; i++){
			for(int j=1; j<target+1; j++){
				if(coins[i-1] <= j){
					int remaider = j - coins[i-1];
					topDownResult[i][j] = topDownResult[i][remaider] + topDownResult[i-1][j];
				}
				else
				topDownResult[i][j] = topDownResult[i-1][j];
			}
		}
		return topDownResult[n][target];
	}
	public static void main(String [] args){
		int [] coins = {1,2,3,5};
		int target = 8;
		//Output for unbouded knapsack version of coin change problem
		System.out.println("coinChangeMaxWays result is: "+ coinChangeMaxWays(coins,target));
	}
}
