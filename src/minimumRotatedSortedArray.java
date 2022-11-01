public class minimumRotatedSortedArray {

		public int findMin(int[] nums) {
			if(nums == null)
				return 0;
			int low = 0;
			int high = nums.length - 1;
			int min = findMinSubRt(low, high, nums);
			System.out.println("min value is: "+ min);
			return min;
		}
		public int findMinSubRt(int low, int high, int[] nums){
			int mid = low + (high - low)/2;
			int res = nums[mid];
			if(mid - 1 >= 0 && mid + 1 <= nums.length-1 && res< nums[mid -1] && res< nums[mid + 1])
				return res;
			else if(mid - 1 >= 0 && mid + 1 <= nums.length-1 && 
			   findMinSubRt(low,mid - 1, nums) < findMinSubRt(mid+1,high, nums))
				res = findMinSubRt(low,mid - 1, nums);
			else 
			   res = findMinSubRt(mid+1,high, nums); 
			
			return res;  
		}
}
