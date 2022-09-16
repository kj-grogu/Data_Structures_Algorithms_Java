public class EvenNoDigits {

    public int retEvenNoDigits(int [] nums){
        int evenNos = 0;
        if(nums.length < 1 || nums.length > 500){}
        else{
            for(int i=0; i<nums.length; i++)
            {
                if(nums[i] < 1 || nums[i] > 100000){}
                else{
                    int digits = 1;
                    int temp = nums[i];
                    while(temp >= 10){
                        digits++;
                        temp = temp / 10;
                    }
                    if(digits % 2 == 0){
                        evenNos++;
                    }

                }
            }
        }

        return evenNos;
    }
    public static void main(String[] args) {
        
    }
}
