import java.util.*;
// 217. Contains Duplicate
//https://leetcode.com/problems/contains-duplicate/
// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 

// Example 1:

// Input: nums = [1,2,3,1]
// Output: true
// Example 2:

// Input: nums = [1,2,3,4]
// Output: false
// Example 3:

// Input: nums = [1,1,1,3,3,4,3,2,4,2]
// Output: true
 

// Constraints:

// 1 <= nums.length <= 105
// -109 <= nums[i] <= 109

public class ContainsDuplicate {
	public static boolean containsDuplicate(int[] nums) {
        if(nums == null)
            return false;
        Set <Integer> numsSet = new HashSet<>();
        for(int i=0; i<nums.length; i++)
            numsSet.add(nums[i]);
        if(numsSet.size() < nums.length)
            return true;
        return false;
    }
	public static void main(String [] args){
		int [] nums = {1,1,1,3,3,4,3,2,4,2};
		System.out.println("Contains duplicate: "+ containsDuplicate(nums));
	}
}
