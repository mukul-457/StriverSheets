public class BinaryMedianOfTwoSortedArray {
    public static void main(String[] args) {
        int[] inp1 = {1,2};
        int[] inp2 = {1,2,3};
        BMOTSA sol = new BMOTSA();
        System.out.println(sol.findMedianSortedArrays(inp1, inp2));
    }
}

class BMOTSA {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int l1 = 0, l2 =0 , h1 = nums1.length-1 , h2 = nums2.length-1;

        int leftCount  = (nums1.length + nums2.length -1) / 2;
        while (leftCount > 0){
            if(l1>h1 || l2>h2){
                break;
            }
            int mid1 = (l1+h1)/2;
            int mid2 = (l2+h2)/2;
            int count1 = mid1-l1+1;
            int count2 = mid2-l2+1;
            if (count1+count2 <= leftCount){
                if(nums1[mid1] <= nums2[mid2]){
                    leftCount -= count1;
                    l1= mid1+1;
                }else{
                    leftCount -= count2;
                    l2=mid2+1;
                }
            }else{
                if(nums1[mid1] >= nums2[mid2] ){
                    h1 = mid1-1;
                }else{
                    h2 = mid2-1;
                }
            }
        }
        while(leftCount > 0){
            if (l2>h2){
                int mid1= (l1+h1)/2;
                int count1 = mid1-l1 +1;
                if (count1 <= leftCount){
                    leftCount -=count1;
                    l1 = mid1+1;
                }else{
                    h1 = mid1;
                }
            }else{
                int mid2= (l2+h2)/2;
                int count2 = mid2-l2 +1;
                if (count2 <= leftCount){
                    leftCount -=count2;
                    l2 = mid2+1;
                }else{
                    h2 = mid2;
                }                
            }
        }

        if ((nums1.length + nums2.length)%2 == 1){
            if(l1 < nums1.length && l2 < nums2.length){
            return (double) Math.min(nums1[l1], nums2[l2]);
            }else if(l1 >= nums1.length){
                return (double) nums2[l2];
            }
            return (double) nums1[l1];
        }
        int medain_sum =0 ;
        for(int i= 0; i< 2; i++){
            if(l1 < nums1.length && l2 < nums2.length){
                if (nums1[l1] <= nums2[l2]){
                    medain_sum += nums1[l1];
                    l1++;
                }else{
                    medain_sum += nums2[l2];
                    l2++;
                }
            }else{
                if(l1 >= nums1.length){
                    medain_sum += nums2[l2];
                    l2++;
                }else{
                    medain_sum += nums1[l1];
                    l1++;
                }
            }
        }
        return (double) medain_sum/2;

    }
}