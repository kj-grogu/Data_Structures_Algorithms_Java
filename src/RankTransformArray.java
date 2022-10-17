import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 1331. Rank Transform of an Array
//https://leetcode.com/problems/rank-transform-of-an-array/

// Given an array of integers arr, replace each element with its rank.

// The rank represents how large the element is. The rank has the following rules:

// Rank is an integer starting from 1.
// The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
// Rank should be as small as possible.
 

// Example 1:

// Input: arr = [40,10,20,30]
// Output: [4,1,2,3]
// Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.
// Example 2:

// Input: arr = [100,100,100]
// Output: [1,1,1]
// Explanation: Same elements share the same rank.
// Example 3:

// Input: arr = [37,12,28,9,100,56,80,5,12]
// Output: [5,3,4,2,8,6,7,1,3]
 

// Constraints:

// 0 <= arr.length <= 105
// -109 <= arr[i] <= 109

public class RankTransformArray {
	public static int[] arrayRankTransform(int[] arr) {
        if(arr == null)
            return arr;
        
        int [] tempArr = Arrays.copyOf(arr,arr.length); 
        Arrays.sort(tempArr);
        
        Map<Integer,Integer> valToRank = new HashMap<>();
        
        int rank = 1;
        
        for(int i=0;i<tempArr.length;i++){
            if(i+1 < tempArr.length && tempArr[i] != tempArr[i+1])
            {
                valToRank.put(tempArr[i], rank);
                rank++;
            }
            if(i == arr.length - 1)
                valToRank.put(tempArr[i], rank);      
        }
        
        for(int j=0; j<arr.length; j++)
        {
            if(valToRank.containsKey(arr[j]))
                arr[j] = valToRank.get(arr[j]);
        }
        return arr;
    }
	public static void main(String [] args){
		int [] arr = {37,12,28,9,100,56,80,5,12};
		System.out.println(Arrays.toString(arrayRankTransform(arr)));
	}
}
