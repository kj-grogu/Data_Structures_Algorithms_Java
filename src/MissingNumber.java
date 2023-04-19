import java.util.Arrays;

public class MissingNumber {
	//https://leetcode.com/problems/missing-number/
// 	268. Missing Number

// Given an array nums containing n distinct numbers in the range [0, n], 
// return the only number in the range that is missing from the array.

// Example 1:
// Input: nums = [3,0,1]
// Output: 2
// Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 
// 2 is the missing number in the range since it does not appear in nums.

// Example 2:
// Input: nums = [0,1]
// Output: 2
// Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 
// 2 is the missing number in the range since it does not appear in nums.

// Example 3:
// Input: nums = [9,6,4,2,3,5,7,0,1]
// Output: 8
// Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 
// 8 is the missing number in the range since it does not appear in nums.

	public static int missingNumber(int[] nums) {
        int res = 0;
        //Logic is to add all the numbers from the range and substract the ones in the array
        //To get the only remainnig number of the range which is not there in the array
        // for(int i=0;i<=nums.length; i++){
        //     if(i <= nums.length - 1)
        //         res += (i - nums[i]);
        //     else
        //         res += i;
        // }
        // return res;

        //Or XOR way:
        //XOR of two same nos is 0 so if continue XORing all the nos of range with the nos in array
        //it will result in only remaining no.
        for(int i=0;i<= nums.length; i++){
            if(i <= nums.length - 1){
                res ^=  i ^ nums[i];
            }
            else
                res ^= i; 
        }
        return res;
    }
	public static void main(String[] args) {
		int [] nums = {3, 0, 1};
		System.out.println("Missing Number in list "+ Arrays.toString(nums) + " is: "+ missingNumber(nums));
	}
}
