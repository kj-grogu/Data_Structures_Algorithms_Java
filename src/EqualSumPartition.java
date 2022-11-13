import java.util.*;
public class EqualSumPartition {
// Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
// https://leetcode.com/problems/partition-equal-subset-sum/
 
// Example 1:
// Input: nums = [1,5,11,5]
// Output: true
// Explanation: The array can be partitioned as [1, 5, 5] and [11].

// Example 2:
// Input: nums = [1,2,3,5]
// Output: false
// Explanation: The array cannot be partitioned into equal sum subsets.
 
// Constraints:
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100

	//Problem Statement:
	//Given an array of integers return true if there exists two different set of integers from this array whose sums are equal,
	//else return false

	//Recurrsive Solution:
	public static boolean equalSumPartitionRecurr(int [] nums, int n){
		//two partitions with eaqual sum are only possible if the sum of all elements of the array is even
		int sum = 0;
		for(int i=0; i<n; i++)
			sum += nums[i];
		if(sum % 2 != 0)
			return false;
				
		return SubSetSum.subSetSumRecurr(nums, sum/2, n);
	}
	//Recurrsive solution with memoization:
	public static boolean equalSumPartitionRecurrMemo(int [] nums, int n){
		//two partitions with eaqual sum are only possible if the sum of all elements of the array is even
		int sum = 0;
		for(int i=0; i<n; i++)
			sum += nums[i];
		
		if(sum % 2 != 0)
			return false;
		
		boolean [][] memo = new boolean[nums.length + 1][(sum/2) + 1];
		for(int i=0; i<=nums.length; i++)
			Arrays.fill(memo[i], false);
				
		return SubSetSum.subSetSumRecurrMemo(nums, sum/2, n, memo);
	}
	//abular top-down solution:
	
	public static boolean equalSumPartitionTopDown(int [] nums, int n){
		//two partitions with eaqual sum are only possible if the sum of all elements of the array is even
		//TopDown Iterative solution --> Converting recurrsive solution to iterative:
		int sum = 0;
		for(int i=0; i<n; i++)
			sum += nums[i];

		if(sum % 2 != 0)
			return false;
				
		return SubSetSum.subSetSumTopDown(nums, sum/2, n);
	}

	public static boolean subSetSum(int [] nums, int target, int n){
		boolean [][] topDownResult = new boolean [n+1][target + 1];
		
		//Initialization:
		for(int i=0; i<n+1; i++){
		  for(int j=0; j<target+1; j++){
			  if(i == 0)
				  topDownResult[i][j] = false;
			  if(j == 0)
				  topDownResult[i][j] = true;
		  }
		}
		//Iteretive solution:
		for(int i=1; i<n+1; i++){
		  for(int j=1; j<target+1; j++){
			  if(nums[i-1] <= j)
			  {
				int remainder = j - nums[i-1];
				  topDownResult[i][j] = (topDownResult[i-1][remainder] || topDownResult[i-1][j]);
			  }else
				topDownResult[i][j] = topDownResult[i-1][j];
		  }
		}
		return topDownResult[n][target];
	  }
	  public static boolean canPartition(int[] nums) {
		  int sum = 0;
		for(int i=0; i< nums.length; i++){
			sum += nums[i];
		}
		if(sum % 2 != 0)
		  return false;
		
		return subSetSum(nums, sum/2, nums.length);
	  }

	public static void main(String [] args){
		int [] nums = {2,3,7,8,10};
		//leetcode solution output:
		System.out.println("canPartition finds result as: "+ canPartition(nums));
		//Print result of recurrsive solution:
		System.out.println("equalSumPartitionRecurr finds result as: "+ equalSumPartitionRecurr(nums, nums.length));

		//Print result of recurrsive + memoized solution:
		System.out.println("equalSumPartitionRecurrMemo finds result as: "+ equalSumPartitionRecurrMemo(nums, nums.length));

		//Print result of topDown solution:
		System.out.println("equalSumPartitionTopDown finds result as: "+ equalSumPartitionTopDown(nums, nums.length));
	}
}
