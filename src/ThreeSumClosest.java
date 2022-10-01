import java.util.Arrays;

public class ThreeSumClosest {

        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int left;
            int right;
            int total;
            int closest = nums[0] + nums[1] + nums[nums.length - 1];
            total = closest;
            for(int i=0; i<nums.length - 1; i++){
                left = i+1;
                right = nums.length - 1;
                if(i > 0 && (left < right))
                {
                    total = nums[i] + nums[left] + nums[right];
                    if(Math.abs(Math.abs(target) - Math.abs(closest)) > Math.abs(Math.abs(target) - Math.abs(total)))
                        closest = total; 
                }
                while(left < right){ 
                    if(closest < target){
                        left++;
                        if(left < right){
                            total = nums[i] + nums[left] + nums[right];
                        }
                        
                    }
                    else if(closest > target){
                        right--;
                        if(left < right){
                            total = nums[i] + nums[left] + nums[right];
                        }
                    }
                    else
                        return closest;
                    if(Math.abs(Math.abs(target) - Math.abs(closest)) > Math.abs(Math.abs(target) - Math.abs(total)))
                        closest = total; 
                    while(left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                }
            }
            return closest;
        }
}
