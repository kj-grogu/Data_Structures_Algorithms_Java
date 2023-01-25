
// 54. Spiral Matrix
// https://leetcode.com/problems/spiral-matrix/

// Given an m x n matrix, return all elements of the matrix in spiral order.

// Example 1:
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]

// Example 2:
// Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 
// Constraints:
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100

import java.util.*;
public class SpiralMatrix {

	//Logic:
	//1. take a variable dir to determine the direction of the move
	//2. take variables to determine the left, top, right and down values of the the matrix 
	//3. run a while loop till left<=right && top<=bottom
	//4. inside the while loop run a switch case over the the dir variable
	//5. for each direction run the for loop to traverse the matrix.
	
    public static List<Integer> spiralOrder(int[][] matrix) {
        //direction: 0 -> right, 1 -> down, 2 -> left, 3 -> top
        int dir = 0;
        int left = 0;
        int right = matrix[0].length - 1; //length of cols - 1
        int top = 0;
        int down = matrix.length - 1; //length of rows - 1
        List<Integer> result = new ArrayList<>();
        //System.out.println("left: " + left + " right: "+ right + " top: " + top + " down: " + down);
        while(left <= right && top <= down){
            switch(dir){
                //Move towards right
                case 0:
                    for(int i=left; i<=right; i++)
                        result.add(matrix[top][i]);
                    top++;
                break;
                //Move towards bottom
                case 1:
                    for(int i=top; i<=down; i++)
                        result.add(matrix[i][right]);
                    right--;
                break;
                //Move towards left
                case 2:
                    for(int i=right; i>=left; i--)
                        result.add(matrix[down][i]);
                    down--;
                break;
                //Move towards top
                case 3:
                    for(int i=down; i>=top; i--)
                        result.add(matrix[i][left]);
                    left++;
                break;
            }
            //System.out.println("dir: "+ dir);
            dir = (dir + 1) % 4;
            //System.out.println("dir 2: "+ dir);
        }
        //System.out.println("result: "+ result.toString());
        return result;
    }
	public static void main(String [] args){
		int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

		System.out.println("Spiral order is: " + spiralOrder(matrix));
	}
}
