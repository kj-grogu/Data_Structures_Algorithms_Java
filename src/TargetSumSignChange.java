public class TargetSumSignChange {
	
	//https://leetcode.com/problems/target-sum/
	//Problem description:
	//If given an array of numbers (nums) assign the signs to all the values of the array.
	//Such that the sum of all the elements(after sign assignment) in the array becomes equal to the provided target.
	//Count All Such Arrangements of signs possible

	//This problem is is exactly same as CountSubSetGivenDifference here the target is our diff.
	//Basically we will divide the nums in 2 subsets, one with all positive values(S1) and another with all -ve values(S2)
	//Then, S1 + S2 = target becomes same as S1 - S2 = diff(target) as S2 is sum of all -ve values
	//And the resultant count is equal to the count that we get after doing CountSubSetGivenDifference.

	public static int targetSumSignChange(int [] nums, int target, int n){
		int rangeSum = 0;
		for(int i=0; i<n; i++){
			rangeSum += nums[i];
		}
		//from mathematical equations above:
		int diffTarget = (rangeSum - target)/2; //diff replaced by target
		
		return countSubsetSum(nums, diffTarget, n);
	}
	public static int countSubsetSum(int [] nums, int target, int n){
		int [][] topDownResult = new int [n + 1][target + 1];
		//Initialization
		for(int i=0; i<n+1; i++){
			for(int j=0; j<target+1; j++){
				if(i == 0)
				topDownResult[i][j] = 0;
				if(j == 0)
				topDownResult[i][j] = 1;
			}
		}
		//topDown iterative Solution:
		for(int i=1; i<n+1; i++){
			for(int j=1; j<target+1; j++){
				if(nums[i-1] <= j){
					int remaider = j - nums[i-1];
					topDownResult[i][j] = topDownResult[i-1][remaider] + topDownResult[i-1][j];
				}else{
					topDownResult[i][j] = topDownResult[i-1][j];
				}
			}
		}
		return topDownResult[n][target];
	}
	public static void main(String [] args){
		int [] nums = {1,1,2,3};
		int target = 1;
		//Calling targetSumSignChange function to get the count of the pair of subsets in nums with difference equal to diff.
	System.out.println("targetSumSignChange gives the count as: "+ targetSumSignChange(nums, target, nums.length));
	} 
}
