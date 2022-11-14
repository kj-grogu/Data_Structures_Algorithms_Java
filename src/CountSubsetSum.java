public class CountSubsetSum {
	
	//Recurrsive Solution:
	//https://www.youtube.com/watch?v=F7wqWbqYn9g&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=9
	//https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/

	public static int countSubSetSumRecurr(int [] nums, int target, int n){
		//base Condition:
		if(target == 0)
			return 1;
		if(n == 0)
			return 0;
		
		//Recurrsive code
		if(nums[n-1] <= target){
			int remainder = target - nums[n-1];
			return countSubSetSumRecurr(nums, remainder, n-1) + countSubSetSumRecurr(nums, target, n-1);
		}
		return countSubSetSumRecurr(nums, target, n-1);
	}
	//TopDown iterative Solution:
	public static int countSubSetSumTopDown(int [] nums, int target, int n){
		int [][] topDownResult = new int[n + 1][target + 1];
		
		//Initialization:
		for(int i=0; i<n+1; i++){
			for(int j=0; j<target+1; j++){
				if(i == 0)
					topDownResult[i][j] = 0;
				if(j == 0)
					topDownResult[i][j] = 1;
			}
		}
		//Iterative code:
		for(int i=1; i<n+1; i++){
			for(int j=1; j<target+1; j++){
				if(nums[i-1] <= j){
					int remainder = j - nums[i-1];
					topDownResult[i][j] = topDownResult[i-1][remainder] + topDownResult[i-1][j];
				}else
				topDownResult[i][j] = topDownResult[i-1][j];
			}
		}
		return topDownResult[n][target];
	}
public static void main(String [] args){
	int [] nums = {2,3,7,8,10};
	int target = 10;
	//Recurrsive solution call:
	System.out.println("countSubSetSumRecurr for "+ target + " in nums is: "+ countSubSetSumRecurr(nums, target, nums.length));
	//TopDown Iterative solution call:
	System.out.println("countSubSetSumTopDown for "+ target + " in nums is: "+ countSubSetSumTopDown(nums, target, nums.length));

}	
}
