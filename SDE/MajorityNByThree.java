import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityNByThree {

    public static void main(String[] args) {
        MJ mj = new MJ();
        System.out.println((mj.majorityElement(new int[]{4,1,2,3,4,4,3,2,1,4})).toString());
    }
}

class MJ {
    public List<Integer> majorityElement(int[] nums) {
        int major1 = Integer.MIN_VALUE;
        int freq1 = 0;
        int major2 = Integer.MIN_VALUE;
        int freq2 = 0;
        for(int i= 0; i< nums.length ; i ++){
            if (freq1 == 0 && nums[i] != major2){
                major1 = nums[i];
                freq1 ++;
            }else if(freq2 == 0 && nums[i] != major1){
                major2 = nums[i];
                freq2 ++;

            }else{
                if(nums[i] == major1){
                    freq1++;
                }else if(nums[i] == major2){
                    freq2++;
                }else{
                    freq1--;
                    freq2--;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        freq1 = 0;
        freq2 = 0;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] == major1){
                freq1 ++;
            }else if (nums[i] == major2){
                freq2 ++;
            }
        } 
        if (freq1 > nums.length / 3 ) {
            ans.add(major1);
        }
        if ( freq2 > nums.length / 3){
            ans.add(major2);
        }
        return ans;
    }
}