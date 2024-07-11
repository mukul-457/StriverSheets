import java.util.Arrays;

public class ReversePairs {
    public static void main(String[] args) {
        REV rev = new REV();
        int as = rev.reversePairs(new int[]{1,3,2,3,1});
        System.out.println(as);            
    }

}

class REV {
    public  int reversePairs(int arr[]) {
        int[] inv = new int[]{0};
        sort(arr,0,arr.length-1, inv);
        return inv[0];

    }

    public   int[] sort(int[]  arr , int start ,int end ,int[] inv){
        if (start >= end){
            return Arrays.copyOfRange(arr, start, start+1);
        }
        int mid = start+(end-start)/2;
        int[] left = sort(arr, start , mid, inv);
        int[] right = sort(arr, mid+1, end ,inv);

        int[] sorted  = new int[end-start+1];
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < mid-start+1 && j < end-mid){
            if((long) left[i] <= ((long)right[j])*2  ){
                i++;
            }else{
                inv[0] += mid-start+1 - i ;
                j++;
            }
        }
        i = 0;
        j = 0;
        
        while (i < mid-start+1 && j < end-mid){
            if(left[i] < right[j]){
                sorted[k] = left[i];
                i++;
                k++;
            }else{
                sorted[k] = right[j];
                //if (left[i] > right[j]*2 ){
                    //inv[0] += mid-start+1 - i ;
                //}
                j++;
                k++;
            }
        }

        while(k < end-start+1){
            if (i < mid-start+1){
                sorted[k] = left[i];
                i++;
                k++;
            }else{
                sorted[k] = right[j];
                j++;
                k++;
            }
        }

        return sorted;
    }
    
}
