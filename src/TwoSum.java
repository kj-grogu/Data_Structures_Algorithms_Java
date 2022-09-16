import java.util.HashMap;
import java.util.Map;

public class TwoSum {
//1. Two Sum
//https://leetcode.com/problems/two-sum/
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.

 

// Example 1:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
// Example 2:

// Input: nums = [3,2,4], target = 6
// Output: [1,2]
// Example 3:

// Input: nums = [3,3], target = 6
// Output: [0,1]

//     public int[] twoSum(int[] nums, int target) {
//         if(nums == null)
//             return null;
        
//         int retArInt [] = null; 
//         //System.out.println(Arrays.toString(retArInt));

//         int baseInd = 0;
        
//         while(baseInd < nums.length - 1){
//             for(int i=baseInd + 1; i<nums.length; i++){  
//             if(target == nums[baseInd] + nums[i]){
//                 retArInt = new int[2];
//                 retArInt[0] = baseInd;
//                 retArInt[1] = i;
//                 break;
//             }
//             else
//             {
//                 continue;
//             }
//          }
//             if(retArInt == null)
//                 baseInd++;
//             else
//                 break;
//         }
        
//         return retArInt;
//     }
    
public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> valueToIndex = new HashMap<>();
    
    // for(int i=0; i<nums.length; i++){
    //    valueToIndex.put(nums[i], i);
    // }
    
    for(int i=0; i<nums.length; i++){
        if(valueToIndex.containsKey(target - nums[i])){
            return new int[]{valueToIndex.get(target - nums[i]), i};
        }
         valueToIndex.put(nums[i], i);
            
    }
    return null;    
}
public static void main(String[] args) {
    int nums [] = {2,7,11,15};
    int target = 9;
    twoSum(nums,target);

}
}

