import java.util.*;

// 73. Set Matrix Zeroes
//https://leetcode.com/problems/set-matrix-zeroes/
// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
// You must do it in place.

// Example 1:
// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]

// Example 2:
// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 
// Constraints:
// m == matrix.length
// n == matrix[0].length
// 1 <= m, n <= 200
// -231 <= matrix[i][j] <= 231 - 1
 
// Follow up:
// A straightforward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?

//Logic:
//1. Treat the first row and colums of the matrix to store the change factor for that column and row
//2. as for [0,0] the firt row and col indexes are same use another variable for the 0th row
//3. for i>=1 and j>=1 modify the cell values on iterating over the matrix
//4. for column 0: iterate over all the rows and set the value if matrix[0][0] was set previously
//5. for row 0: check the extra variable to set the values of the entire row
//6. maintain the order of steps 3, 4 and 5.

public class SetMatrixZeroes {
	public static int [][] setZeroes(int[][] matrix) {
        int row0 = 1;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    if(i==0){
                        row0 = 0;
                        matrix[0][j] = 0;
                    }
                    else{
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }      
                }
            }
        }
        // for(int i=0; i<matrix.length; i++){
        //         System.out.println(Arrays.toString(matrix[i]));
        // }
        

        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[0][j] == 0)
                       matrix[i][j] = 0;
                if(matrix[i][0] == 0)
                       matrix[i][j] = 0;
            }
        }
        if(matrix[0][0] == 0){
            for(int i=1; i<matrix.length; i++)
                matrix[i][0] = 0;
        } 
        if(row0 == 0)
            Arrays.fill(matrix[0],0);
	return matrix;
    }
	public static void main(String [] args){
		int [][] matrix = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
		System.out.println("matrix after setting zerros is: ");
		matrix = setZeroes(matrix);
		for(int i=0; i<matrix.length; i++){
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
}
