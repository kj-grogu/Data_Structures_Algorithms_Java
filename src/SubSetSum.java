import java.util.*;
public class SubSetSum {
	//Problem Description:
	//Given an array of integers and a target element return true or false if there exist a sum of integers from the array that is
	//equal to the target.

	//problem type:
	//This is a variation on the 0-1 knapsack problem and can be solved using Dynamic Programming:

	//Recurrsive Solution:
	public static boolean subSetSumRecurr(int [] nums, int target, int n){
		//Base condition:
		if(target == 0)
			return true;
		if(n == 0 && target != 0)
			return false;
		//System.out.println("n is: "+ n + " target is: "+ target);
		if(nums[n-1] <= target)
			{
				int remainder = target - nums[n-1];
				return (subSetSumRecurr(nums, remainder,n-1) || subSetSumRecurr(nums, target, n-1));
			}
		return subSetSumRecurr(nums, target, n-1);
	}
	//Meoized recurrsive solution:
	public static boolean subSetSumRecurrMemo(int [] nums, int target, int n, boolean [][] memo){
		//Base condition:
		if(target == 0)
		{
			memo[n][target] = true;
			return memo[n][target];
		}
			
		if(n == 0 && target != 0){
			memo[n][target] = false;
			return memo[n][target];
		}
		
		// memoized recurrsive solution:
		if(memo[n][target] != false)
			return memo[n][target];

		if(nums[n-1] <= target)
			{
				int remainder = target - nums[n-1];
				memo[n-1][target] = (subSetSumRecurrMemo(nums, remainder,n-1,memo) || subSetSumRecurrMemo(nums, target, n-1, memo));
				//return (subSetSumRecurr(nums, remainder,n-1) || subSetSumRecurr(nums, target, n-1));
			}
			memo[n][target] = subSetSumRecurrMemo(nums, target, n-1, memo);
		//return subSetSumRecurr(nums, target, n-1);
		return memo[n][target];
	}
	//Tabular top-down solution:
	public static boolean subSetSumTopDown(int [] nums, int target, int n){
		boolean [][] topDownResultant = new boolean [n+1][target + 1];
		//Initialization --> converted base condition:
		for(int i=0; i<n+1; i++){
			for(int j=0; j<target+1; j++){
				if(i == 0)
				topDownResultant[i][j] = false;
				if(j == 0)
				topDownResultant[i][j] = true;
			}
		}

		//TopDown Iterative solution --> converting recurrsive solution to iterative:
		for(int i=1; i<n+1; i++){
			for(int j=1; j<target+1; j++){
				if(nums[i-1] <= j){
					int remainder = j - nums[i-1];
					topDownResultant[i][j] = (topDownResultant[i-1][remainder] || topDownResultant[i-1][j]);
				}
				else
				topDownResultant[i][j] = topDownResultant[i-1][j];
			}
		}
		return topDownResultant[n][target];
	}


	public static void main(String [] args){
		int [] nums = {2,3,7,8,10};
		int target = 11;
		boolean [][] memo = new boolean[nums.length + 1][target + 1];
		for(int i=0; i<=nums.length; i++)
			Arrays.fill(memo[i], false);

		//Print result of recurrsive solution:
		System.out.println("subSetSumRecurr finds result as: "+ subSetSumRecurr(nums, target, nums.length));

		//Print result of recurrsive + memoized solution:
		System.out.println("subSetSumRecurrMemo finds result as: "+ subSetSumRecurrMemo(nums, target, nums.length, memo));

		//Print result of topDown solution:
		System.out.println("subSetSumTopDown finds result as: "+ subSetSumTopDown(nums, target, nums.length));
	}
}
