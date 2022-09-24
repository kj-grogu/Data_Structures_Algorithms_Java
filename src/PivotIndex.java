public class PivotIndex {
    //724. Find Pivot Index
    //https://leetcode.com/problems/find-pivot-index/
        // Given an array of integers nums, calculate the pivot index of this array.

        // The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

        // If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

        // Return the leftmost pivot index. If no such index exists, return -1.

        

        // Example 1:

        // Input: nums = [1,7,3,6,5,6]
        // Output: 3
        // Explanation:
        // The pivot index is 3.
        // Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
        // Right sum = nums[4] + nums[5] = 5 + 6 = 11
        // Example 2:

        // Input: nums = [1,2,3]
        // Output: -1
        // Explanation:
        // There is no index that satisfies the conditions in the problem statement.
        // Example 3:

        // Input: nums = [2,1,-1]
        // Output: 0
        // Explanation:
        // The pivot index is 0.
        // Left sum = 0 (no elements to the left of index 0)
        // Right sum = nums[1] + nums[2] = 1 + -1 = 0
        

        // Constraints:

        // 1 <= nums.length <= 104
        // -1000 <= nums[i] <= 1000
        

    public static int pivotIndex(int[] nums) {
        if(nums.length < 1)
            return -1;
        int n = nums.length - 1;
        int [] sumLeft = new int[nums.length];
        int [] sumRight = new int[nums.length];
        
        for(int i = 0, j = nums.length - 1; i < nums.length; i++, j--){
            sumLeft[i] = i == 0 ? nums[i] : sumLeft[i-1] + nums [i];
            sumRight[j] = j == n ? nums[j] : sumRight[j+1] + nums[j];
            // sumLeft[i] = i > 0 ? nums[i] + sumLeft[i-1] : nums[i];
            // sumRight[j] = j < n ? nums[j] + sumRight[j-1] : nums[j];
         }
        
//         System.out.println(Arrays.toString(sumLeft));
//         System.out.println(Arrays.toString(sumRight));
        
        for(int i = 0; i < nums.length; i++){
            int l = i == 0 ? 0 :  sumLeft[i-1] ;
            int r = i == nums.length - 1 ? 0 : sumRight[i+1];
            
            if(l == r)
                return i;
        }
        return -1;   
    }
    public static void main(String[] args) {
        int[] nums = new int [] {1,7,3,6,5,6};
        pivotIndex(nums);
    }
}
