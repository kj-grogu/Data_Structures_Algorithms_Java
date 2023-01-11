public class SearchRotatedSortedArray {
	// 33. Search in Rotated Sorted Array
	// https://leetcode.com/problems/search-in-rotated-sorted-array/
	// There is an integer array nums sorted in ascending order (with distinct values).
	
	// Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
	
	// Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
	
	// You must write an algorithm with O(log n) runtime complexity. 
	// Example 1:
	
	// Input: nums = [4,5,6,7,0,1,2], target = 0
	// Output: 4
	// Example 2:
	
	// Input: nums = [4,5,6,7,0,1,2], target = 3
	// Output: -1
	// Example 3:
	
	// Input: nums = [1], target = 0
	// Output: -1
	 
	// Constraints:
	// 1 <= nums.length <= 5000
	// -104 <= nums[i] <= 104
	// All values of nums are unique.
	// nums is an ascending array that is possibly rotated.
	// -104 <= target <= 104

		static int pivot;
		static int targetInd;
		  public static int search(int[] nums, int target) {
			if(nums == null)
			  return -1;
			pivot = -1;
			int left = 0;
			int right = nums.length - 1;
			pivot = findPivot(left,right,nums);
			//System.out.println("pivot: "+ pivot);
			
			if(target == nums[pivot])
			  return pivot;
			//System.out.println("pivot: "+ pivot);
			targetInd = -1;
			
			if(pivot - 1 >= 0 && target <= nums[pivot - 1] && target >= nums[left]){
			  targetInd = findTarget(left, pivot - 1, nums,target);
			  //System.out.println("targetInd: "+ targetInd); 
			} 
			
			if(pivot + 1 < nums.length && target >= nums[pivot + 1] && target <= nums[right]){
			  targetInd = findTarget(pivot + 1, right, nums,target);
			  //System.out.println("targetInd: "+ targetInd); 
			}
			
			//System.out.println("targetInd: "+ targetInd); 
			return targetInd;
		}
		
		public static int findPivot(int left, int right, int [] nums){
		 int mid = left + (right - left)/2;
		  if(left == right)
			return mid;
		  
		  if(left == right - 1){
			if(nums[left]<nums[right])
			  return right;
			else
			  return left;
		  }
		  
		  if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])
			return mid;
		  
		  if(left<right){
			  if(nums[mid] > nums[left])
				return findPivot(mid+1,right,nums);
			  return findPivot(left,mid-1,nums);    
		  }
				
		  return pivot;
		}
		
		public static int findTarget(int left, int right, int[] nums, int target){
		  int mid = left + (right - left)/2;
		  if(target == nums[mid])
			  return mid;
		  if(left == right - 1){
			  if(target == nums[left])
				return left;
			  else if(target == nums[right])
				return right;
			  return -1;
		  }
		  if(left < right)
		  {
			if(mid-1 >= 0 && nums[mid] > target)
			  return findTarget(left, mid-1, nums, target);
			if(mid+1 < nums.length && nums[mid] < target)
			  return findTarget(mid+1, right, nums, target);
		  }
		   return targetInd;
		 }
	//Another Way:
	//Logic:
	//1. Use binary search to find the rotated or minimum val index
	//2. Again use binary search to find the target index from either of the sub arrays to the left and right of rotated index.
	//Code:
	/*
	public static int search(int[] nums, int target){
        int minInd = findMinInd(nums);
        //System.out.println("minInd: " + minInd);
        int left = 0; 
        int right = nums.length - 1;
        if(target == nums[minInd])
        return minInd;
        else if(minInd > left && target >= nums[left])
           return findTarget(nums, target, left, minInd - 1);
        else 
           return findTarget(nums, target, minInd + 1, right);
  }
  public static int findMinInd(int [] nums){
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            int nextM = (mid + 1) % nums.length;
            int prevM = (mid + nums.length - 1) % nums.length;

            if(nums[mid] < nums[nextM] && nums[mid] < nums[prevM])
                return mid;
            else if(nums[start] <= nums[mid] && nums[mid] <= nums[end])
                return start;
            else if(nums[mid] <= nums[end])
                end = mid - 1;
            else if(nums[mid] >= nums[start])
                start = mid + 1;
        }
        return -1;
  }
  public static int findTarget(int [] nums, int target, int left, int right){
      int mid = left + (right - left) / 2;
      //System.out.println("left: " + left + " right: "+ right + " mid: "+ mid);
      while(left <= right)
      {
            if(target == nums[mid])
                return mid;
            else if(target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        mid = left + (right - left) / 2;
      }
      return -1;
  }
	*/   
	public static void main(String [] args){
		int [] nums = {4,5,5,6,7,7,7,0,0,1,2};
		System.out.println("index of target is: "+ search(nums, 0));
	}  
}
