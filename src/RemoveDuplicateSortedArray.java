import java.util.Arrays;
// 26. Remove Duplicates from Sorted Array
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// Easy

// 8361

// 12039

// Add to List

// Share
// Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

// Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

// Return k after placing the final result in the first k slots of nums.

// Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

// Custom Judge:

// The judge will test your solution with the following code:

// int[] nums = [...]; // Input array
// int[] expectedNums = [...]; // The expected answer with correct length

// int k = removeDuplicates(nums); // Calls your implementation

// assert k == expectedNums.length;
// for (int i = 0; i < k; i++) {
//     assert nums[i] == expectedNums[i];
// }
// If all assertions pass, then your solution will be accepted.

 

// Example 1:

// Input: nums = [1,1,2]
// Output: 2, nums = [1,2,_]
// Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
// It does not matter what you leave beyond the returned k (hence they are underscores).
// Example 2:

// Input: nums = [0,0,1,1,1,2,2,3,3,4]
// Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
// Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
// It does not matter what you leave beyond the returned k (hence they are underscores).
 

// Constraints:

// 1 <= nums.length <= 3 * 104
// -100 <= nums[i] <= 100
// nums is sorted in non-decreasing order.


public class RemoveDuplicateSortedArray {
		public static int removeDuplicates(int[] nums) {
			int pos = 0;
			for(int i = 1; i < nums.length; i++){
				if(nums[i-1] != nums[i]){
					nums[++pos] = nums[i];
				}
			}
			
			return pos+1;
			
			
			// if(nums == null)
			//     return 0;
			// if(nums.length == 1)
			//     return 1;
			// int countDup = 0;
			// int dup=0;
			// for(int i=1;i<nums.length;i++){
			//     if(nums[i]==nums[i-1])
			//     {
			//         dup = i;
			//         countDup++;
			//         break;
			//     }  
			// }
			// for(int j=dup+1;j<nums.length && dup>0;j++){
			//     if(nums[j] == nums[j-1]){
			//         countDup++;
			//     }
			//     if(nums[j] != nums[j-1] )
			//     {
			//         nums[dup] = nums[j];
			//         dup = dup + 1;
			//     }
			// }
			// System.out.println("nums: "+ Arrays.toString(nums));
			// return (nums.length - countDup);
		}

	public static void main(String[] args) {
		int [] nums = {0,0,1,1,1,2,2,3,3,4};
		//System.out.println("index till wich no duplicates: " + removeDuplicates(nums));
		System.out.println("Sorted Array is till index "+ removeDuplicates(nums) +" : "+ Arrays.toString(nums));
	}
}
