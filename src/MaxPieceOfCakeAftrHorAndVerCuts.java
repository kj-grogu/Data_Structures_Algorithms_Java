import java.util.*;
// 1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
//https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/

// Medium
// 2.5K
// 341
// Toptal
// company
// Expedia
// company
// Goldman Sachs
// You are given a rectangular cake of size h x w and two arrays of integers horizontalCuts and verticalCuts where:

// horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly, 
// and verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.
// Return the maximum area of a piece of cake after you cut at each horizontal 
// and vertical position provided in the arrays horizontalCuts and verticalCuts. 
// Since the answer can be a large number, return this modulo 109 + 7.

//Logic:
// 1. First sort both the horizontalCuts and VerticalCuts Array
// 2. Get the max horizontal height (maxH) and max vertical width (maxW) by looping over the arrays and
// substracting previos value from current one
// 3. Get max area by multiplying maxH and maxW
// here is the catch that both maxH and maxW values can overflow so take them as long and return the result by modulo
// long mod = (long) 1e9+7 (10^9 + 7)

public class MaxPieceOfCakeAftrHorAndVerCuts {
	public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);


        long maxH = horizontalCuts[0];
        long maxW = verticalCuts[0];
        long mod = (long)1e9+7;

        for(int i=1; i<=horizontalCuts.length; i++){
            if(i==horizontalCuts.length)
                maxH = Math.max(maxH,h - horizontalCuts[i - 1]);
            else
                maxH = Math.max(maxH,horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        for(int i=1; i<=verticalCuts.length; i++){
            if(i==verticalCuts.length)
                maxW = Math.max(maxW,w - verticalCuts[i - 1]);
            else
                maxW = Math.max(maxW,verticalCuts[i] - verticalCuts[i - 1]);
        }

        //System.out.println("maxH: "+ maxH + " maxW: " + maxW);
        return (int)((maxH * maxW) % mod);
    }
	public static void main(String [] args){
		int [] horizontalCuts = {1,2,4};
		int [] verticalCuts = {1,3};
		System.out.println("max are of cake is: "+ maxArea(5,4, horizontalCuts, verticalCuts));
	}
}
