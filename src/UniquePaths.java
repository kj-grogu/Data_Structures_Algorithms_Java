import java.util.*;
public class UniquePaths {
// 	62. Unique Paths
// https://leetcode.com/problems/unique-paths/
// There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

// Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

// The test cases are generated so that the answer will be less than or equal to 2 * 109.

// Example 1:
// Input: m = 3, n = 7
// Output: 28

// Example 2:
// Input: m = 3, n = 2
// Output: 3

// Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
// 1. Right -> Down -> Down
// 2. Down -> Down -> Right
// 3. Down -> Right -> Down
 
// Constraints:
// 1 <= m, n <= 100

		public static int uniquePaths(int m, int n) {
		  //Solution using recurrsion:  
		  // if(m == 1 && n == 1)
		  //     return 1;
		  //   if(m == 0 || n == 0)
		  //     return 0;
		  //   return uniquePaths(m-1,n) + uniquePaths(m, n-1);
		  
		  
		  //Solution using dynamic programming:
		  Map<String,Integer> memo = new HashMap<>();
		  return uniquePathsDP(m, n, memo);
		}
	  public static int uniquePathsDP(int m, int n, Map<String,Integer> memo){
		String key = m + "," + n;
		String keyRev = n + "," + m;
		if(memo.containsKey(key))
			return memo.get(key);
		if(memo.containsKey(keyRev))
			return memo.get(keyRev);
		if(m == 1 && n == 1)
			memo.put(key,1);
		else if(m == 0 || n == 0)
			memo.put(key, 0);
		else
			memo.put(key, uniquePathsDP(m-1,n, memo) + uniquePathsDP(m,n-1, memo));
		return memo.get(key);
	  }
	public static void main(String [] args){
		int m = 10, n = 12;
		System.out.println("Total no. of. unique paths is: "+ uniquePaths(m,n));
	}
}
