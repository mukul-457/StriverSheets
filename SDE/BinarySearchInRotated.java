public class BinarySearchInRotated {
    public static void main(String[] args) {
        int[]  inp = {3,4,5,1};
        SIR sol = new SIR();
        System.out.println(sol.search(inp, 5));
    }
}

class SIR {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = (low+ high) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] > target){
                if(nums[0] > target && nums[mid] >= nums[0]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }else{
                if(nums[nums.length-1] < target && nums[mid] <= nums[nums.length-1]){
                    high= mid-1;
                }else{
                    low = mid+1;
                }
            }

        }
        return -1;
    }
}