import java.util.*;
/*
//https://leetcode.com/problems/maximum-product-subarray/
152. Maximum Product Subarray
Given an integer array nums, find a subarray that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.

Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 
Constraints:
1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

 */

public class MaximumProductSubarray {
	public static int maxProduct(int[] nums) {
        int res = nums[0];
        int [] maxProd = new int [nums.length];
        int [] minProd = new int [nums.length]; 
        maxProd[0] = nums[0];
        minProd[0] = nums[0];
        for(int i=1; i<nums.length; i++){
			//trick is to compare all the 3 cases:
            maxProd[i] = Math.max(Math.max(nums[i], maxProd[i-1] * nums[i]),minProd[i-1] * nums[i]);
            minProd[i] = Math.min(Math.min(nums[i], minProd[i-1]*nums[i]), maxProd[i-1] * nums[i]);

            if(maxProd[i] > res)
                res = maxProd[i];
        }
        System.out.println(Arrays.toString(maxProd));
        System.out.println(Arrays.toString(minProd));
        return res;
    }
	public static void main(String [] args){
		int [] nums = {2,3,-2,4};

		System.out.println("Product of maximumProductSubArray is: "+ maxProduct(nums));
	}
}
