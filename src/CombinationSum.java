import java.util.*;
// 39. Combination Sum
// https://leetcode.com/problems/combination-sum/
// Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

// The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

// The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

// Example 1:
// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation:
// 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7.
// These are the only two combinations.

// Example 2:
// Input: candidates = [2,3,5], target = 8
// Output: [[2,2,2,2],[2,3,3],[3,5]]

// Example 3:
// Input: candidates = [2], target = 1
// Output: []
 
// Constraints:
// 1 <= candidates.length <= 30
// 2 <= candidates[i] <= 40
// All elements of candidates are distinct.

public class CombinationSum {
	public static List<List<Integer>> combinations = new ArrayList<>();
			
			  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
				  if(candidates == null)
					return null;
				List<Integer> choices = new ArrayList<>();
				int start = 0;
				allSums(target, candidates, start, choices);
				return combinations;
			  }
			  public static void allSums(int target, int[] candidates, int start ,List<Integer> choices)
			  {
				if(target < 0)
				  return;
				
				if(target == 0)
				{
				  combinations.add(new ArrayList<>(choices));
				  return;
				}
				for(int i=start; i<candidates.length; i++){
				  choices.add(candidates[i]);
				  int remainder = target - candidates[i];
				  allSums(remainder, candidates, i, choices);
				  choices.remove(choices.size() - 1);
				}
			  }
	
	public static void main(String [] args){
		int [] nums = {2,3,4,7};
		List <List <Integer>> res  = combinationSum(nums, 10);
		for(List<Integer> l : res)
			System.out.println("HowSum result is: "+ l);
	}
}
