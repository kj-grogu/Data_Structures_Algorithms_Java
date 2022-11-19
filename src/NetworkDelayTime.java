import java.util.*;
public class NetworkDelayTime {
	//https://leetcode.com/problems/network-delay-time/ 
	//BellmanFord Example:
	//743. Network Delay Time
// You are given a network of n nodes, labeled from 1 to n. You are also given times, 
//a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, 
//vi is the target node, and wi is the time it takes for a signal to travel from source to target.
// We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. 
//If it is impossible for all the n nodes to receive the signal, return -1.

// Example 1:
// Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
// Output: 2

// Example 2:
// Input: times = [[1,2,1]], n = 2, k = 1
// Output: 1

// Example 3:
// Input: times = [[1,2,1]], n = 2, k = 2
// Output: -1
 
// Constraints:
// 1 <= k <= n <= 100
// 1 <= times.length <= 6000
// times[i].length == 3
// 1 <= ui, vi <= n
// ui != vi
// 0 <= wi <= 100
// All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
public static int networkDelayTime(int[][] times, int n, int k) {
	int []delays = new int [n+1];
	
	Arrays.fill(delays, Integer.MAX_VALUE);
	
	delays[0] = delays[k] = 0;
	
	for(int i=1; i<=n; i++){
	  int [] tempdelays = Arrays.copyOf(delays, delays.length);
	  for(int j=0; j<times.length; j++){
		int from = times[j][0];
		int to = times[j][1];
		int delay = times[j][2];
		if(delays[from] == Integer.MAX_VALUE)
			continue;
		if(tempdelays[to] > delay + delays[from])
		{
		  tempdelays[to] = delay + delays[from];
		}
	  }
	  delays = tempdelays;
	}
	System.out.println(Arrays.toString(delays));
	
	int max = Integer.MIN_VALUE;
	
	for(int d : delays){
	  if(d == Integer.MAX_VALUE)
		return -1;
	  max = Math.max(max, d);
	}
	
	return max;
  }

public static void main(String [] args){
	int [][] times = {{2,1,1},{2,3,1},{3,4,1}};
	int n = 4;
	int k = 2;
	System.out.println("networkDelayTime: "+ networkDelayTime(times,n,k));
}
}
