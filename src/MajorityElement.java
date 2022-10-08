public class MajorityElement {

// 	169. Majority Element
//https://leetcode.com/problems/majority-element/
// Easy

// 12124

// 390

// Add to List

// Share
// Given an array nums of size n, return the majority element.

// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

// Example 1:

// Input: nums = [3,2,3]
// Output: 3
// Example 2:

// Input: nums = [2,2,1,1,1,2,2]
// Output: 2
 

// Constraints:

// n == nums.length
// 1 <= n <= 5 * 104
// -109 <= nums[i] <= 109
 

// Follow-up: Could you solve the problem in linear time and in O(1) space?

	public static int majorityElement(int[] nums) {
		//In nlogn
		//     Arrays.sort(nums);
		//     if(nums.length % 2 == 0)
		//         return nums[(nums.length/2) - 1];
		//     else
		//         return nums[(nums.length/2)];
		
		//In O(n) -->O(1)
		// if(nums == null)
		//     exit 0;
		int mE = nums[0];
		int count = 1;
		for(int i=1;i<nums.length;i++){
			if(nums[i]==mE)
				count++;
			else if(count == 0 && nums[i] != mE)
			{
				mE = nums[i];
				count++;
			}
			else{
				count--;
			}
		}    
		return mE;
		}
	public static void main(String [] args){
		int [] nums = new int []{2,2,1,1,1,2,2};
		System.out.println(majorityElement(nums));
	}
}
