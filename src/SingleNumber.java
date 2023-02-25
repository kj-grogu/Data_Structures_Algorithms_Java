public class SingleNumber {
// 	https://leetcode.com/problems/single-number/
// 	136. Single Number

// Given a non-empty array of integers nums, 
// every element appears twice except for one. Find that single one.
// You must implement a solution with a linear runtime complexity and use only constant extra space.

// Example 1:
// Input: nums = [2,2,1]
// Output: 1
// *********************************************************************************************/
// 	Logic:
// 	1. bitwise XOR (^) for 2 binary nos results in 0 for same bits and 1 for opposite bits
// 	2. here we intitialise the var with 0th index no from the array
// 	3. if nums[0] == 2 (var), nums[1] == 4 and nums[2] == 2
// 	4. when we XOR var to nums[1] we get 5 and when we XOR 6 with nums[2] (2) we get 4
// 	Example:  2 ^ 4 = 6 : 010 |   6 ^ 2 = 4 : 110
// 	                     100 |               010
// 	                     110 |               100
// 	5. The above step shows that we can do even occrances of a num will get cancelled out, 
// 	no matther where they occur in the list.
// 	Leaving no with only odd occurence in the variable var.
// 	Note: n ^ 0 = n (any no XOR 0 is always that no)
							
	public static int singleNumber(int[] nums) {
		int var = nums[0];
		for(int i=1; i<nums.length; i++){
			var = var ^ nums[i];
		}
		return var;
	}
	public static void main(String [] args){
		int [] nums = {2,1,2,4,6,4,6};
		System.out.println("Single unique no is: "+ singleNumber(nums));
	}	
}
