import java.util.Arrays;
//https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=10
//https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/
//https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/

//Problem Description:
//Given an array of munbers (nums) find the minimum difference there can be from all the pairs of the subSets formed from nums.

public class MinimumSubSetSumDiff {
	public static int minimumSubSetDiff(int [] nums, int n){
		int rangeSum = 0;
		for(int i=0; i<nums.length; i++){
			rangeSum += nums[i];
		}
		boolean [][] topDownResult = new boolean[n+1][rangeSum+1];
		//Initialization
		for(int i=0; i<n+1; i++){
			for(int j=0; j<rangeSum+1; j++){
				if(i == 0)
				topDownResult[i][j] = false;
				if(j == 0)
				topDownResult[i][j] = true;
			}
		}
		//TopDown Iterative function:
		for(int i=1; i<n+1; i++){
			for(int j=1; j<rangeSum+1; j++){
				if(nums[i-1] <= j){
						int remainder = j - nums[i-1];
						topDownResult[i][j] = topDownResult[i-1][remainder] || topDownResult[i-1][j];
				}else{
					topDownResult[i][j] = topDownResult[i-1][j];
				}
			}
		}

		//to get the minimum difference we will write the code to get equation:
		//minimumDiff = (rangeSum - 2S1), here s1 is sum of smallest possible subset
		//comes from: minimumDiff = S2 - S1 (S2 is always greater than S1) and (S1 + S2 = rangeSum => S2 = rangeSum - S1)
		//Therefore, minimumDiff = rangeSum - S1 - S1 => minimumDiff = rangeSum - 2S1
		
		//Fetch the list of nos whose sum is possible(from last row) in the range and only till half of range,
		//as S1 should always be less then S2.
		boolean [] topDownResultTillRangeByTwo = new boolean [(rangeSum/2 + 1)];
		for(int j=0; j<(rangeSum/2 + 1); j++){
			topDownResultTillRangeByTwo[j] = topDownResult[n][j];
		}
		System.out.println("topDownResultTillRangeByTwo: "+ Arrays.toString(topDownResultTillRangeByTwo));
		//To get minimum difference:
		int minDiff = Integer.MAX_VALUE;
		for(int j=1; j<topDownResultTillRangeByTwo.length; j++)
		{	if(topDownResultTillRangeByTwo[j] == true)
				minDiff = Math.min(minDiff, rangeSum - 2*j);
		}
		return minDiff;
	}
	public static void main(String [] args){
		int [] nums  = {3,9,7,3};
		//print the output for minimum def of subSets:
		System.out.println("minimumSubSetDiff out put is:" + minimumSubSetDiff(nums, nums.length));
	}
}
