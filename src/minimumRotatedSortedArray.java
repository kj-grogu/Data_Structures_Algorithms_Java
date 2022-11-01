public class minimumRotatedSortedArray {

// 153. Find Minimum in Rotated Sorted Array
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

// Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

// [4,5,6,7,0,1,2] if it was rotated 4 times.
// [0,1,2,4,5,6,7] if it was rotated 7 times.
// Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

// Given the sorted rotated array nums of unique elements, return the minimum element of this array.

// You must write an algorithm that runs in O(log n) time.

	public static int findMin(int[] nums) {
        if(nums == null)
            return 0;
        int low = 0;
        int high = nums.length - 1;
        int min = findMinSubRt(low, high, nums);
        //System.out.println("min value is: "+ min);
        return min;
      }
        public static int findMinSubRt(int low, int high, int[] nums){
            int mid = low + (high - low)/2;
            int res = nums[mid];
            if(low < high){
                if(low == high - 1)
                {
                    return Math.min(nums[low], nums[high]);
                }
                if(mid - 1 >= 0 && mid + 1 < nums.length) {
                      int resL = findMinSubRt(low,mid - 1, nums);
                      int resR = findMinSubRt(mid + 1,high, nums);
                      if(res < resL && res < resR)
                        return res;
                      else if(resL < resR)
                          return resL;
                      return resR;     
                    }
                }           
            return res;  
        }
	public static void main(String [] args){
		int [] nums = {4,5,6,1,2,3};
		System.out.println("minimum value is: "+ findMin(nums));
	}
}
