
// https://leetcode.com/problems/pacific-atlantic-water-flow/
// 417. Pacific Atlantic Water Flow

// There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. 
// The Pacific Ocean touches the island's left and top edges, 
// and the Atlantic Ocean touches the island's right and bottom edges.
// The island is partitioned into a grid of square cells. 
// You are given an m x n integer matrix heights 
// where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
// The island receives a lot of rain, and the rain water can flow 
// to neighboring cells directly north, south, east, and west if the neighboring cell's height is 
// less than or equal to the current cell's height. 
// Water can flow from any cell adjacent to an ocean into the ocean.
// Return a 2D list of grid coordinates result where result[i] = [ri, ci] 
// denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.

// Example 1:
// Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
// Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
// Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
// [0,4]: [0,4] -> Pacific Ocean 
//        [0,4] -> Atlantic Ocean
// [1,3]: [1,3] -> [0,3] -> Pacific Ocean 
//        [1,3] -> [1,4] -> Atlantic Ocean
// [1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean 
//        [1,4] -> Atlantic Ocean
// [2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean 
//        [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
// [3,0]: [3,0] -> Pacific Ocean 
//        [3,0] -> [4,0] -> Atlantic Ocean
// [3,1]: [3,1] -> [3,0] -> Pacific Ocean 
//        [3,1] -> [4,1] -> Atlantic Ocean
// [4,0]: [4,0] -> Pacific Ocean 
//        [4,0] -> Atlantic Ocean
// Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.

// Example 2:
// Input: heights = [[1]]
// Output: [[0,0]]
// Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.

// Constraints:
// m == heights.length
// n == heights[r].length
// 1 <= m, n <= 200
// 0 <= heights[r][c] <= 105

import java.util.*;

class PacificAtlanticWaterFlow {
	public static List<List<Integer>> pacificAtlantic(int[][] heights) {
		List<List<Integer>> result = new ArrayList<>();
		if (heights == null || heights.length == 0)
			return result;

		int rLen = heights.length;
		int cLen = heights[0].length;
		boolean[][] pacific = new boolean[rLen][cLen];
		boolean[][] atlantic = new boolean[rLen][cLen];

		for (int c = 0; c < cLen; c++) {
			dfs(0, c, pacific, heights, Integer.MIN_VALUE);
			dfs(rLen - 1, c, atlantic, heights, Integer.MIN_VALUE);
		}
		for (int r = 0; r < rLen; r++) {
			dfs(r, 0, pacific, heights, Integer.MIN_VALUE);
			dfs(r, cLen - 1, atlantic, heights, Integer.MIN_VALUE);
		}
		for (int i = 0; i < rLen; i++) {
			for (int j = 0; j < cLen; j++) {
				if (pacific[i][j] && atlantic[i][j]) {
					List<Integer> list = new ArrayList<>();
					list.add(i);
					list.add(j);
					result.add(list);
				}
			}
		}
		return result;
	}

	private static void dfs(int r, int c, boolean[][] canReach, int[][] heights, int prevHeight) {
		if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length || canReach[r][c]
				|| prevHeight > heights[r][c])
			return;

		canReach[r][c] = true;
		dfs(r + 1, c, canReach, heights, heights[r][c]);
		dfs(r - 1, c, canReach, heights, heights[r][c]);
		dfs(r, c + 1, canReach, heights, heights[r][c]);
		dfs(r, c - 1, canReach, heights, heights[r][c]);
	}

	public static void main(String[] args) {
		int[][] heights = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
				{ 5, 1, 1, 2, 4 } };
		List<List<Integer>> res = PacificAtlanticWaterFlow.pacificAtlantic(heights);

		for (int i = 0; i < res.size(); i++)
			System.out.println(res.get(i).toString());
	}
}