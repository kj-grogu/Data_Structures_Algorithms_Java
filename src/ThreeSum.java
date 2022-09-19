import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        //https://leetcode.com/problems/3sum/
        //15. 3Sum
        // Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
        
        // Notice that the solution set must not contain duplicate triplets.
        
         
        
        // Example 1:
        
        // Input: nums = [-1,0,1,2,-1,-4]
        // Output: [[-1,-1,2],[-1,0,1]]
        // Explanation: 
        // nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
        // nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
        // nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
        // The distinct triplets are [-1,0,1] and [-1,-1,2].
        // Notice that the order of the output and the order of the triplets does not matter.
        // Example 2:
        
        // Input: nums = [0,1,1]
        // Output: []
        // Explanation: The only possible triplet does not sum up to 0.
        // Example 3:
        
        // Input: nums = [0,0,0]
        // Output: [[0,0,0]]
        // Explanation: The only possible triplet sums up to 0.
         
        
        // Constraints:
        
        //3 <= nums.length <= 3000
        //-105 <= nums[i] <= 105
               // Solution in n^2 log n
        //         List<List<Integer>> result = new ArrayList<>();
        //         Arrays.sort(nums);
        //         int left;
        //         int right;
        //         int mid;
        //         int target;
        //         for(int i=0; i<nums.length; i++){
        //             if(i>0 && nums[i] == nums[i-1])
        //                 continue;
        
        //                 for(int j=i+1; j<nums.length; j++){
        //                      if(j > i + 1 && nums[j] == nums[j - 1])
        //                         continue;
                            
        //                     //do binary search for -(nums[i]+nums[j]) here
        //                     target = -(nums[i]+nums[j]);
        //                     left = j+1;
        //                     right = nums.length - 1;
                            
        //                     while (left <= right) {
        //                         mid = left + (right - left)/2;
        //                         if(nums[mid] > target)
        //                            right = mid - 1;   
        //                         else if(nums[mid] < target)
        //                            left = mid + 1;
        //                         else
        //                         {
        //                             List<Integer> subres = new ArrayList<>();
        //                             subres.add(nums[i]);
        //                             subres.add(nums[j]);
        //                             subres.add(nums[mid]);
        //                             System.out.println(" i : "+ i +" j:" + j + "k:" + mid);
        //                             result.add(subres);
        //                             break;
        //                         }
        //                             // result.add(Arrays.asList<List<Integer>>(new int [] {nums[i], nums[j], nums[k]}));
        //                 }
        //             }
        //         }
                
        //Solution in n^2
                List<List<Integer>> result = new ArrayList<>();
                Arrays.sort(nums);
                int left;
                int right;
                System.out.println(Arrays.toString(nums));
                
                for(int i = 0; i<nums.length; i++){
                    
                    if(i>0 && nums[i] == nums[i-1])
                        continue;
                    
                    left = i+1;
                    right = nums.length - 1;
                    
                    while(left < right){
                        if(nums[i] + nums[left] + nums[right] < 0)
                           left++; 
                        else if(nums[i] + nums[left] + nums[right] > 0)
                            right--;
                        else
                        {
                            List<Integer> subres = new ArrayList<>();
                                             subres.add(nums[i]);
                                             subres.add(nums[left]);
                                             subres.add(nums[right]);
                            result.add(subres);
                            // ÷String temp = subres.toString();
                            // resultmap.put(temp,subres);
                            // //break;
                            left++;
                            right--;
                            
                            while(left < right && nums[left - 1] == nums[left])
                                left++;
                            
                            while(left < right && nums[right] == nums[right+1])
                                right--;
                        }     
                    }
                }
            // ArrayList<List<Integer>> result = new ArrayList<List<Integer>>(resultmap.values());
            //List<List<Integer>> result = new ArrayList<>();  
            //result.addList(resultmap.values);
            return result;
            }
public static void main(String[] args) {
    int nums [] = {0,0,0};
    threeSum(nums);
}
}
