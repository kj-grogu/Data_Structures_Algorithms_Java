public class minimumRotatedSortedArray {

// 153. Find Minimum in Rotated Sorted Array
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

// Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

// [4,5,6,7,0,1,2] if it was rotated 4 times.
// [0,1,2,4,5,6,7] if it was rotated 7 times.
// Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

// Given the sorted rotated array nums of unique elements, return the minimum element of this array.

// You must write an algorithm that runs in O(log n) time.

/* 
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
			if(low == high - 1)
                {
                    return Math.min(nums[low], nums[high]);
                }
            if(low < high){
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
*/
//Another way:
public static int findMin(int[] nums) {
    if(nums == null)
        return 0;
    if(nums.length == 1)
        return nums[0];
    int left = 0;
    int right = nums.length - 1;

    return minRes(nums, left, right);
}
public static int minRes(int [] nums, int left, int right){
    int mid = left + (right - left)/2;
    int resM = nums[mid];
    int resL = Integer.MAX_VALUE;
    int resR = Integer.MAX_VALUE;
    if(left == right - 1)
        return Math.min(nums[left], nums[right]);
    else if(left < right)
    {
        resL = minRes(nums, left, mid - 1);
        resR = minRes(nums, mid + 1, right);
    }
    return Math.min(resM, Math.min(resL, resR));
}

//Another way:
//logic: 
//1. No of times an array is rotated == index of the minimum element
//2. If element at the mid is minimum then it will have the property that: 
//  2.1. It will be smaller than both its left and right neighbours.
//3. For moving aheah, move to unsorted part of array {either on left or right of mid (including mid)}

//How to take care of array index out of bound error:
//int nextM = (mid + 1) % nums.length; //understand better
//int prevM = (mid + N - 1) % nums.length; // understand better

/*
public static int findMin(int[] nums) {
      int start = 0;
      int end = nums.length - 1;
      while(start <= end){
            int mid = start + (end - start)/2;
            int nextM = (mid + 1) % nums.length;
            int prevM = (mid + nums.length - 1) % nums.length;

            System.out.println("start: "+ start + " mid: "+ mid + " end: " + end);
            System.out.println("nextM: "+ nextM + " prevM: "+ prevM);

            if(nums[mid] < nums[nextM] && nums[mid] < nums[prevM])
                return nums[mid];
            else if(nums[start] <= nums[mid] && nums[mid] <= nums[end])
                return nums[start];
            else if(nums[mid] >= nums[start]) //meaning array to the left of mid is sorted
                start = mid + 1;
            else if(nums[mid] <= nums[end]) //meaning array to the right of mid is sorted
                end = mid - 1;          
      }
    return -1;
}
 */
	public static void main(String [] args){
		int [] nums = {4,5,6,1,2,3};
		System.out.println("minimum value is: "+ findMin(nums));
	}
}
