public class SingleInSortedArrayOfDoubles {
    public static void main(String[] args) {
        int[] inp = {3,3,7,7,10,11,11};
        SISOD  sol = new SISOD();
        System.out.println(sol.singleNonDuplicate(inp));
    }
}

class SISOD {
    public int singleNonDuplicate(int[] nums) {
        int low = 0 ;
        int high = nums.length;

        while (low  < high){
            int mid = (low + high) /2;
            if ((mid == nums.length-1 || nums[mid] != nums[mid+1]) && ((mid == 0 ) || nums[mid] != nums[mid-1]))
            {
                return nums[mid];
            }
            
            if(mid%2 == 1){
                if(nums[mid] == nums[mid-1]){
                    low =  mid+1;
                }
                else{
                    high = mid;
                }
            }else{
                if(nums[mid] == nums[mid+1]){
                    low = mid+1;
                }else{
                    high = mid;
                }
            }

        }

        return -1;
    }
}