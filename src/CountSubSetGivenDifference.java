public class CountSubSetGivenDifference {
	//https://leetcode.com/discuss/interview-question/1271034/count-no-of-subsets-with-given-difference-dp
	//https://www.geeksforgeeks.org/count-of-subsets-with-given-difference/
	
	//Problem Description:
	//Given an array of numbers (nums) and a value diff find the count of all the pairs of subSets from nums.
	//Such that for eacgh of these pairs, the difference between the sum of their subsets is equal to the provided diff.

	//Mathematical logic:
		//rangeSum = sum of all the elements in nums
		//S1,S2 ==> subSets from nums between which the difference is equal to diff.
		//Equation 1:
		//S1 + S2 = rangeSum => S1 = rangeSum - S2
		//Equation 2:
		//S1 - S2 = diff => rangeSum - S2 - S2 = diff => rangeSum - 2*S2 = diff
		//So, 2*S2 = rangeSum - diff => S2 = (rangeSum - diff)/2
		//therefore, the target to find here is the count of subSets with sum equal to S2 (target)

	public static int countSubSetGivenDifference(int [] nums, int diff, int n){
		int rangeSum = 0;
		for(int i=0; i<n; i++){
			rangeSum += nums[i];
		}
		//from mathematical equations above:
		int target = (rangeSum - diff)/2;
		
		return countSubsetSum(nums, target, n);
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
		int diff = 1;
		//Calling countSubSetGivenDifference function to get the count of the pair of subsets in nums with difference equal to diff.
	System.out.println("countSubSetGivenDifference gives the count as: "+ countSubSetGivenDifference(nums, diff, nums.length));
	}
}
