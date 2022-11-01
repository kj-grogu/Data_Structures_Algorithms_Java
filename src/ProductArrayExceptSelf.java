import java.util.Arrays;

class ProductArrayExceptSelf {
// 	238. Product of Array Except Self
//https://leetcode.com/problems/product-of-array-except-self/
// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// You must write an algorithm that runs in O(n) time and without using the division operation.

 

// Example 1:

// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]
// Example 2:

// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]
 

// Constraints:

// 2 <= nums.length <= 105
// -30 <= nums[i] <= 30
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 

// Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

public static int[]  productExceptSelf(int[] nums) {
	//         if(nums == null)
	//             return nums;
	//         int ArrMulL = 1;
	//         int ArrMulR = 1;
	//         int [] answerL = new int [nums.length];
	//         int [] answerR = new int [nums.length];
	//         int [] answer = new int [nums.length];
	//         for(int i=0; i<nums.length; i++){
	//             ArrMulL = ArrMulL * nums[i];
	//             answerL[i] = ArrMulL;
	//         }
	//         for(int j=nums.length - 1; j>=0; j--){
	//             ArrMulR = ArrMulR * nums[j];
	//             answerR[j] = ArrMulR;
	//         }
	//         //System.out.println("ArrMulL: " + Arrays.toString(answerL));
	//         //System.out.println("ArrMulR: " + Arrays.toString(answerR));
	//         for(int i=0; i<nums.length; i++){
	//             if(i > 0 && i < nums.length - 1)
	//             answer[i] = answerL[i-1] * answerR[i+1];
	//             else if( i == 0)
	//             answer[i] = answerR[i+1];
	//             else
	//             answer[i] = answerL[i-1];
	//         }
			
	//         //System.out.println("answer: "+ Arrays.toString(answer));
	//         return answer;
	
	// solving O(1) space complexity output array excluded:
			
			if(nums == null)
				return nums;
			int ArrMulL = 1;
			int ArrMulR = 1;
			
			int [] answer = new int [nums.length];
			for(int j=nums.length - 1; j>=0; j--){
				ArrMulR = ArrMulR * nums[j];
				answer[j] = ArrMulR;
			}
			for(int i=0; i<nums.length; i++){
				ArrMulL = ArrMulL * nums[i];
				nums[i] = ArrMulL;
			}
			//System.out.println("answer: " + Arrays.toString(answer));
			//System.out.println("nums: " + Arrays.toString(nums));
			for(int i=0; i<nums.length; i++){
				if(i > 0 && i < nums.length - 1)
				answer[i] = nums[i-1] * answer[i+1];
				else if( i == 0)
				answer[i] = answer[i+1];
				else
				answer[i] = nums[i-1];
			}
			
			//System.out.println("answer: "+ Arrays.toString(answer));
			return answer;
			
		}
public static void main(String [] args){
	int [] nums = {-1,1,0,-3,3};
	System.out.println("Answer: "+ Arrays.toString(productExceptSelf(nums)));
}
}