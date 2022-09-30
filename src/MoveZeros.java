public class MoveZeros {
// 283. Move Zeroes
// https://leetcode.com/problems/move-zeroes/
// Easy

// 11192

// 276

// Add to List

// Share
// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Note that you must do this in-place without making a copy of the array.

 

// Example 1:

// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Example 2:

// Input: nums = [0]
// Output: [0]
 

// Constraints:

// 1 <= nums.length <= 104
// -231 <= nums[i] <= 231 - 1

	public static void moveZeroes(int[] nums) {
        int zStrart = -1;
        for(int i = 0; i<nums.length;i++)
        {
            if(nums[i]==0){
               zStrart = i;
                break;
            }         
        }
        if(zStrart > -1){
            for(int i=zStrart+1;i<nums.length;i++){
                if(nums[i]!=0){
                    nums[zStrart] = nums[i];
                    nums[i] = 0;
                    zStrart++;
                }     
            } 
        }
public static void main(String[] args) {
	int [] nums = {0,1,0,3,2,0,12};
	moveZeroes(nums);
}
}
