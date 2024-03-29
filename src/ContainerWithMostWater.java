public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        
        //11. Container With Most Water
        //https://leetcode.com/problems/container-with-most-water/
        // You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
        
        // Find two lines that together with the x-axis form a container, such that the container contains the most water.
        
        // Return the maximum amount of water a container can store.
        
        // Notice that you may not slant the container.
        // Input: height = [1,8,6,2,5,4,8,3,7]
        // Output: 49
        // Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
        // Example 2:

        // Input: height = [1,1]
        // Output: 1
        
                int left = 0;
                int right = height.length - 1;
                int max = 0;
                
                // for(int i=0; i<height.length - 1; i++){
                //     for(int j=height.length-1; j>i; j--){
                //        if(max < (j-i) * Math.min(height[j],height[i])){
                //             max = (j-i) * Math.min(height[j],height[i]);
                //         } 
                //     }    
                // }
                while(right > left)
                {
                    if(max < (right - left) * Math.min(height[left],height[right])){
                        max =(right - left) * Math.min(height[left],height[right]);
                    }
                    if(height[right] < height[left])
                        right--;
                    else
                        left++;
                }
                return max;
            }
//Another way:
//Logic:
//1. create two variable left and right, here len = right - left and ht = minimum of the heights as index left and right
//2. water volume = len * ht
//3. if both heights at both left and right index are equal then increment both left and right
//4. if left height is smaller than right height then increment left height.
//5. if rigth height is smaller than left height then increment right height.
/*
 public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while(left < right)
        {
            int len = right - left;
            int ht = Math.min(height[left], height[right]);
            max = Math.max(max, len * ht);
            if(height[left] == height[right]){
                left++;
                right--;
            }
            else if(height[left] < height[right])
                left++;
            else
                right--;
            
        }
    return max;
    }
 */
            public static void main(String[] args) {
                int height [] = {2,7,11,15};
                maxArea(height);
            
            }
}
