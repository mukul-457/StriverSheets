public class MajorityElements {
    
}

class Solution {
    public int majorityElement(int[] nums) {
        int ele= nums[0];
        int freq = 0; 
        for (int index = 0; index < nums.length; index ++){
            if (freq == 0){
                ele = nums[index];
                freq++;
            }else if(ele == nums[index]){
                freq++;
            }else{
                freq--;
            }
        }
        return ele;
    }
}