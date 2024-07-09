public class MaxSubArray {
    public static void main(String[] args) {
    
    }
    
}
class Solution {
    public int maxSubArray(int[] nums) {
        int LargestSum = nums[0];
        int curr_sum = 0;
        for (int index = 0 ; index < nums.length ; index ++){
            curr_sum = Math.max(nums[index] + curr_sum , nums[index]);
            LargestSum = Math.max(curr_sum , LargestSum);
        }
        return LargestSum ;
    }
}