import java.util.Arrays;
//https://www.youtube.com/watch?v=I-l6PBeERuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=16
//https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/?ref=gcse
//Coin change unbounded knapsack variation with 2 initialization steps (Important)
public class CoinChangeMinCoins {
	public static int coinChangeMinCoins(int [] coins, int target){

		int n = coins.length;
		int [][] topDownResult = new int [n + 1][target + 1];

		//Initialization:
		for(int i=0; i<n + 1; i++){
			for(int j=0; j<target + 1; j++){
				if(i == 0)
					topDownResult[i][j] = Integer.MAX_VALUE - 1;
				if( j == 0)
					topDownResult[i][j] = 0;
			}
		}
		//requires 2nd row initialization as well:
		for(int j=1; j<target +1; j++){
			if(j % coins[0] == 0)
				topDownResult[1][j] = j / coins[0];
			else
				topDownResult[1][j] = Integer.MAX_VALUE - 1;
		}

		//topDown iterative dp logic:
		for(int i=2; i<n + 1; i++){
			for(int j=1; j<target + 1; j++){
				if(coins[i-1]<= j){
					int remainder = j - coins[i-1];
					topDownResult[i][j] = Math.min(topDownResult[i][remainder] + 1, topDownResult[i-1][j]);
				}else
				topDownResult[i][j] = topDownResult[i-1][j];
			}
			System.out.println(Arrays.toString(topDownResult[i]));
		}

		return topDownResult[n][target];
	}
	public static void main(String [] args){
		int [] coins = {1,2,3,5};
		int target = 8;
		//Output for unbouded knapsack version of coin change problem
		System.out.println("coinChangeMinCoins result is: "+ coinChangeMinCoins(coins,target));
	}
}
