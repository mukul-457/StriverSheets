import java.util.Arrays;

public class MergeInPlace {
    public static void main(String[] args) {
        int[] num1 = new int[]{0,0,0};
        int[] num2 = new int[]{2,6,7};
        MIP mip = new MIP();
        mip.merge(num1, 0, num2,3);
        System.out.println(Arrays.toString(num1));
    }
}
class MIP {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while (j >= 0 ){
            if (i >= 0 && nums1[i] >= nums2[j]){
                nums1[k] = nums1[i];
                i--;
                k--;
            }else{
                nums1[k] = nums2[j];
                j--;
                k--;
            }
        }
    }
}