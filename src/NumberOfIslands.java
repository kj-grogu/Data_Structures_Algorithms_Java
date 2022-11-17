import java.util.*;
//https://leetcode.com/problems/number-of-islands/
// 200. Number of Islands
// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

// Example 1:
// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1
// Example 2:
// Input: grid = [
//   ["1","1","0","0","0"],
//   ["1","1","0","0","0"],
//   ["0","0","1","0","0"],
//   ["0","0","0","1","1"]
// ]
// Output: 3

// Constraints:
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] is '0' or '1'.

public class NumberOfIslands {
	public static int numIslands(char[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		boolean [][] visited = new boolean [row][col];
  
		//defining direstions data structure:
		int [][] directions = new int [][]{
		  {-1,0},{+1,0},{0,-1},{0,+1}
		};
		int countIslands = 0;
		
		for(int i=0; i<row; i++){
		  for(int j=0; j<col; j++){
			if(grid[i][j] == '1' && !visited[i][j]){
			  countIslands++;
			  //System.out.println("Entering BFS "+ countIslands);
			  bFS(grid,i,j,directions,visited);
			}
		  }
		} 
		
		return countIslands;
	  }
	
	public static void bFS(char [][] grid, int rowStart, int colStart, int [][] directions ,boolean [][] visited){
	  Queue<int[]> que = new LinkedList<>();
	  
	  que.offer(new int[]{rowStart,colStart});
	  
	  while(!que.isEmpty()){
		int [] trav = que.poll();
  
		for(int i=0; i<4; i++){
		  int newRow = trav[0] + directions[i][0];
		  int newCol = trav[1] + directions[i][1];
		  if(!valid(grid, newRow, newCol))
			continue;
		  if(grid[newRow][newCol] == '1' && !visited[newRow][newCol]){
			  visited[newRow][newCol] = true;
			  que.offer(new int [] {newRow,newCol});
		  }
		}
	  }
	}
	
	public static boolean valid(char [][] grid, int newRow, int newCol){
	  int rowLen = grid.length;
	  int colLen = grid[0].length;
	  
	  if(newRow < 0)
		return false;
	  if(newRow >= rowLen)
		return false;
	  if(newCol < 0)
		return false;
	  if(newCol >= colLen)
		return false;
	  
	  return true;
	}
	public static void main(String [] args){
		char [][] grid = new char [][]{
		{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}
		};
		//Calling the BFS code to find the islands in a grid
		System.out.println("numIslands result is: "+ numIslands(grid));
	}
}
