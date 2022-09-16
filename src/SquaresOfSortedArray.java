import java.util.Arrays;

public class SquaresOfSortedArray {

    public static int [] retSquareOfArray(int [] nums){
        //977. Squares of a Sorted Array
        //https://leetcode.com/problems/squares-of-a-sorted-array/
                
        // Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

        

        // Example 1:

        // Input: nums = [-4,-1,0,3,10]
        // Output: [0,1,9,16,100]
        // Explanation: After squaring, the array becomes [16,1,0,9,100].
        // After sorting, it becomes [0,1,9,16,100].
        // Example 2:

        // Input: nums = [-7,-3,2,3,11]
        // Output: [4,9,9,49,121]
        if(nums.length < 1 || nums.length > 10000){}
            //throw new IllegalArgumentException("nums is invalid");
        else{
            for(int i=0; i<nums.length; i++)
            {
                if(nums[i] < -10000 || nums[i] > 10000){}
                //throw new IllegalArgumentException("num[" + i + "] has an invalid value: "+ nums[i]);
                else
                nums[i] = nums[i] * nums [i];
            }
    }
        Arrays.sort(nums);
        /*int temp = retArray.length - 1;
        for(int i=0; i<retArray.length; i++){
            nums[i] = retArray[temp];
            temp--;
        }
        return nums;*/
        return nums;
    }
    public static void main(String[] args) {
        int nums [] = {-15, -7, 0, 4, 8, 22};
        retSquareOfArray(nums);

    }
}
