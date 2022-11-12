import java.util.*;
public class KnapSack {
	// code to solve 0-1 knapsack problem
	// maximize the value of the knapsack
	// base conditions :
	// when n == 0 || capacity == 0
	//recurrsive condition:
	// 1. item wieght is less than capacity of knapsack so take the item
	// 2. don't take item
	// 3. item weight greater than capacity of knapsack so can't take item

	//1st Solution: recurrsive
	// Choice diagram:
	//						item 1 = W1
	//						/		\
	//					W1 > C		W1 <= C
	//					/			/		\
	//				Can't take	take	don't take
	//					N		Y			N

	public static int knapSackRecurr(int [] itemWeights, int [] itemValues, int capacity, int n)
	{
		//Base Condition:
		if(n == 0 || capacity == 0)
			return 0;

		//Choice diagram code:
		// with choices made on every item we keep reducing the list of item 
		// with every taken item we keep reducing the overall capacity of the knapsack

		//output: 
		//Choose the maximum of value from if item is taken and if item is not taken

		if(itemWeights[n-1] <= capacity){
			int remainingCapacity = capacity - itemWeights[n-1];
			return Math.max(itemValues[n-1] + knapSackRecurr(itemWeights,itemValues, remainingCapacity, n-1), 
							knapSackRecurr(itemWeights, itemValues, capacity, n-1));
		}
		return knapSackRecurr(itemWeights, itemValues, capacity, n-1);
	}

	//2nd Solution: now memoizing the recurrsive solution:
	// in memoization we store the value of already computed arrangement in a datastructure, 
	// then using this already computed value when its required again.
	// tabulating the output for every valid arrangement

	public static int knapSackRecurrMemo(int [] itemWeights, int [] itemValues, int capacity, int n, int [][] memo)
	{
		if(n == 0 || capacity == 0)
			return 0;
		if(memo[n][capacity] != -1)
			return memo[n][capacity];
		
		if(itemWeights[n-1] <= capacity){
			int remainingCapacity = capacity - itemWeights[n-1];
			return memo[n][capacity] = Math.max(itemValues[n-1]+ knapSackRecurrMemo(itemWeights, itemValues, remainingCapacity, n-1, memo),
							knapSackRecurrMemo(itemWeights, itemValues, capacity, n-1, memo));
		}
		return memo[n][capacity] = knapSackRecurrMemo(itemWeights, itemValues, capacity, n-1, memo);
			
	}
	//0-1 knanSack topDown approach:
	//Ommiting the recurrsive call and replacing it with only the tabular approach:
	//to avoid stackOverflow error of recurrsive call
	// Solution:
	// Create a resultant topDown matrix of n+1 * Capacity+1
	// Step 1: Initialize the topDown table (this is the base condition of recurrsive solution)
	// Step 2: convert the recurrsive calls into iterative format to fill the topDown table
	// 			that is convert choice diagram into iterative format

	public static int knapSackTopDown(int [] itemWeights, int [] itemValues, int capacity, int n){
		// Creating the topDown resultant matrix
		int [][] topDownResult = new int [n+1][capacity + 1];

		// Initializing the resultant matrix
		for(int i=0; i<n+1; i++){
			for(int j=0; j<capacity+1; j++){
				if(i==0 || j==0)
				topDownResult[i][j] = 0;
			}
		}
		// Converting the recurrsive solution of choice diagram to iterative
		// iterative code conversion of recurrsive choice diagram
			// 	if(itemWeights[n-1] <= capacity)
			// 	{
			// 		int remainingCapacity = capacity - itemWeights[n-1];
			// 		topDownResult[n][capacity] = Math.max(itemValues[n-1] + topDownResult[n-1][remainingCapacity],
			// 								topDownResult[n-1][capacity]);
			// 	}
			// else
			// topDownResult[n][capacity] = topDownResult[n-1][capacity];
		for(int i=1;i<n+1;i++){
			for(int j=1; j< capacity+1; j++){
			//Converting the above code to i,j format
			if(itemWeights[i-1] <= j)
                {
                    int remainingCapacity = j - itemWeights[i-1];
                    topDownResult[i][j] = Math.max(itemValues[i-1] + topDownResult[i-1][remainingCapacity],
                                            topDownResult[i-1][j]);
                }
            else
            topDownResult[i][j] = topDownResult[i-1][j];
            }
		}
		return topDownResult[n][capacity];
	}
	public static void main(String [] args)
	{
		int n = 4;
		int [] itemWeights = {2,3,4,7};
		int [] itemValues = {10,15,20,30};
		int capacity = 9;
		//Calling the recurrsive solution:
		System.out.println("knapSackRecurr output is: " + knapSackRecurr(itemWeights, itemValues, capacity, n));

		int [][] memo = new int [n+1][capacity+1];
		for(int i=0; i<n+1; i++)
			Arrays.fill(memo[i], -1);
		//Calling the recurssive solution with memoization:
		System.out.println("knapSackRecurrMemo output is: " + knapSackRecurrMemo(itemWeights, itemValues, capacity, n, memo));

		//Calling the topDown Approach solution:
		System.out.println("knapSackTopDown output is: " + knapSackTopDown(itemWeights, itemValues, capacity, n));

	}
}
