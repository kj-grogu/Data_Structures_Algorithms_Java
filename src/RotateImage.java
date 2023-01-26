import java.util.*;
// 48. Rotate Image
// https://leetcode.com/problems/rotate-image/
// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
// DO NOT allocate another 2D matrix and do the rotation.

// Example 1:
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]

// Example 2:
// Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
// Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 
// Constraints:
// n == matrix.length == matrix[i].length
// 1 <= n <= 20
// -1000 <= matrix[i][j] <= 1000

public class RotateImage {
	//Logic:
	//1.first see the rotation carefully what has happen,
	//here in this case the matrix is rotated by 90 degree clockwise
	//2. This means that the columns became rows and rows became colums
	//3. then the resultan columns are reversed
	//steps:
	//1. first transpose the matrix by replacing the cols with rows and rows with cols
	//2. on the transepose matrix apply the reversing of arrays algorithm to reverse the colunms.

    public static int [][]  rotate(int[][] matrix) {
		//tranpose the given matrix
        for(int i=0; i<matrix.length; i++){
            for(int j=i; j<matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // for(int i=0; i<matrix.length; i++)
        //     System.out.println(Arrays.toString(matrix[i]));
        
		//reverse the columns of the resultant transpose matrix
        int left = 0;
        int right = matrix.length - 1;
        for(int i=0; i<matrix.length; i++){
            while(left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
            left = 0;
            right = matrix.length - 1;
        }
        // for(int i=0; i<matrix.length; i++)
        //     System.out.println(Arrays.toString(matrix[i]));
		return matrix;
    }
	public static void main(String [] args){
		int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("matrix after rotation is: ");
		matrix = rotate(matrix);
		for(int i=0; i<matrix.length; i++)
			System.out.println(Arrays.toString(matrix[i]));
	}
}
