import java.util.*;
// 697. Degree of an Array
//https://leetcode.com/problems/degree-of-an-array/

// Given a non-empty array of non-negative integers nums, 
//the degree of this array is defined as the maximum frequency of any one of its elements.
// Your task is to find the smallest possible length of a (contiguous) subarray of nums, 
//that has the same degree as nums.

// Example 1:
// Input: nums = [1,2,2,3,1]
// Output: 2
// Explanation: 
// The input array has a degree of 2 because both elements 1 and 2 appear twice.
// Of the subarrays that have the same degree:
// [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
// The shortest length is 2. So return 2.

public class DegreeOfArray {
	public static int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> frequency = new HashMap<>();
        Map<Integer, int []> distance = new HashMap<>();
        List<Integer> highDegreeList = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(frequency.containsKey(nums[i])){
                frequency.put(nums[i], frequency.get(nums[i]) + 1);
                int [] dis =  distance.get(nums[i]);
                dis[1] = i;
                distance.put(nums[i], dis);
            }
            else{
                frequency.put(nums[i], 1);
                int [] dis = new int[2];
                dis[0] = i;
                distance.put(nums[i], dis);
            }
        }
            int degree = 0;
        for(int key : frequency.keySet()){
            if(frequency.get(key) > degree)
                degree = frequency.get(key);
        }
        for(int key : frequency.keySet()){
            if(frequency.get(key) == degree)
                highDegreeList.add(key);
        }
        //System.out.println("degree: " + degree + " highDegreeList: " + Arrays.toString(highDegreeList.toArray()));
        int lowDis = nums.length;
        if(degree == 1){
            lowDis = 1;
        }
        else{
            for(int i=0; i<highDegreeList.size(); i++){
                if(distance.containsKey(highDegreeList.get(i))){
                    //System.out.println("lowDis: "+ lowDis + " distance: "+ Arrays.toString(distance.get(highDegreeList.get(i))));
                    if(lowDis > (distance.get(highDegreeList.get(i))[1] - distance.get(highDegreeList.get(i))[0] + 1))
                    lowDis = (distance.get(highDegreeList.get(i))[1] - distance.get(highDegreeList.get(i))[0] + 1);
                }
            }
        }
        return lowDis;
    }
	public static void main(String [] args){
		int [] nums = {1,2,2,3,1};
		System.out.println("length of smallest subarray with max degree: " + findShortestSubArray(nums));
	}
}
