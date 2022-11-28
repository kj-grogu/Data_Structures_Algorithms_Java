public class MatrixChainMultiplicationLogic {
	//https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/
	//https://www.youtube.com/watch?v=kMK148J9qEE&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=34

	//Steps:
	//1. Find i and j values
	//2. Find right base condition or exit creteria
	//3. Move k --> i to j
	//4. Calculate answer from temporary solution

	//Matrix Multiplication recurrsive solution
	//Problem defination:
	//Given a sequence of matrices, find the most efficient way to multiply these matrices together. 
	//The problem is not actually to  perform the multiplications, 
	//but merely to decide in which order to perform the multiplications. 

	public static int matrixChainMultiplicationLogic(int [] arr, int i, int j){
		//base condition: --> think of the invalid input
		if(i>=j)
			return 0;
		
		int cost = Integer.MAX_VALUE;
		//topDown logic:
		for(int k=i; k<j; k++){
			//Calculate temporary solution:
			int tempcost =  matrixChainMultiplicationLogic(arr,i,k) + matrixChainMultiplicationLogic(arr,k+1,j) + 
					(arr[i-1] * arr[k] * arr[j]);
			if(tempcost < cost)
				cost = tempcost;
			//System.out.println("arr[i-1]: "+ arr[i-1]+" arr[k]: "+ arr[k]+ " arr[j]: "+ arr[j]+ " cost: "+ cost);
		}
		
		return cost;
	}
	public static void main(String[] args) {
		int [] arr = {40,20,30,10,30};
		//int [] arr = {1, 2, 3, 4, 3};
		//int [] arr = {10, 20, 30};

		//Printing the minimum no of operations to be done for matrix multiplication
		System.out.println("Minimum no of operation for matrix multiplication is: "+ 
		matrixChainMultiplicationLogic(arr, 1, arr.length - 1));

	}
}
