import java.util.Arrays;

public class nextGreaterPermutation {

    public static void main(String[] args) {
       ngp  s =  new ngp();
       int[] input  = new int[]{4,2,0,2,3,2,0};
       s.nextPermutation(input);
       System.out.println(Arrays.toString(input));

    }
    
}

class ngp {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int possible = -1;
        for (int targetIndex = n-1 ; targetIndex > 0 ; targetIndex-- ){
            if (nums[targetIndex] > nums[targetIndex-1]){
                possible = targetIndex-1;
                for (int sourceIndex = n-1; sourceIndex > possible ; sourceIndex--){
                    if (nums[sourceIndex] > nums[possible]){
                        int temp = nums[sourceIndex];
                        nums[sourceIndex] = nums[possible];
                        nums[possible] = temp;
                        break;
                    }
                }
                break;
            }
        }
        int start = 0; 
        if (possible != -1){
            start = possible+1 ;
        }
        int end = n-1;
        while(start < end){
            nums[start] = (nums[start] + nums[end]) - (nums[end] = nums[start]);
            end--;
            start++;
        }
        
    }
}