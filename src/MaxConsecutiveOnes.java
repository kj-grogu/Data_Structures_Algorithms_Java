public class MaxConsecutiveOnes{

// 485. Max Consecutive Ones
// Given a binary array nums, return the maximum number of consecutive 1's in the array. 

// Example 1:

// Input: nums = [1,1,0,1,1,1]
// Output: 3
// Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
// Example 2:

// Input: nums = [1,0,1,1,0,1]
// Output: 2
 

// Constraints:

// 1 <= nums.length <= 105
// nums[i] is either 0 or 1.

public int findMaxConsecutiveOnes(int[] nums) {
    int max1Cons = 0;
    int max1ConsTemp = 0;
    
    if(nums == null || nums.length == 0)
        return 0;
    //int t;
    
    //for(int i = 0; i <= nums.length; i++)
    for(int i = 0; i < nums.length; i++)
    {
        //t = i < nums.length ? nums[i] : 0;
        
        //if(t == 1)
          if(nums[i] == 1)  
        {
            ++max1ConsTemp;
        }
        else
        {
            if(max1ConsTemp > max1Cons)
                max1Cons = max1ConsTemp;
            max1ConsTemp = 0;
        }
    }
    if(max1ConsTemp > max1Cons)
        max1Cons = max1ConsTemp;
    
    return max1Cons; 
}

    public static void main(String[] args) {
        System.out.println("I am main @>@");
    }
}