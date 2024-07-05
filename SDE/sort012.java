import java.util.Arrays;

public class sort012 {
    public static void main(String[] args) {
        int[] inp = new int[]{2,1,2,0,1,0};
        Solution5 s = new Solution5();
        s.sortColors(inp);
        System.out.println(Arrays.toString(inp));

    }
}

class Solution5 {
    public void sortColors(int[] nums) {
        int[] counts = new int[3];
        for (int index=0; index < nums.length; index++){
            counts[nums[index]]++;
        }
        int start = 0;
        fill(nums, counts, 0, start);
        start += counts[0];
        fill(nums, counts , 1, start);
        start += counts[1];
        fill(nums, counts, 2, start);

    }

    public void fill(int[]nums ,int[]counts, int ele , int start){
        for (int i = 0; i < counts[ele]; i ++){
            nums[start] = ele;
            start ++;
        }
    }
}