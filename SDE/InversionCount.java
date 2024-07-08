import java.util.Arrays;

public class InversionCount {
    public static void main(String[] args) {
        long[] inp = new long[]{2L, 5L, 1L, 3L, 4L};
        INV sol = new INV();
        System.out.println(sol.getInversions(inp, 5));
    }
}
class INV {
    public static long getInversions(long arr[], int n) {
        long[] inv = new long[]{0L};
        sort(arr,0,arr.length-1, inv);
        return inv[0];

    }

    public static  long[] sort(long[]  arr , int start ,int end ,long[] inv){
        if (start >= end){
            return Arrays.copyOfRange(arr, start, start+1);
        }
        int mid = start+(end-start)/2;
        long[] left = sort(arr, start , mid, inv);
        long[] right = sort(arr, mid+1, end ,inv);

        long[] sorted  = new long[end-start+1];
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < mid-start+1 && j < end-mid){
            if(left[i] < right[j]){
                sorted[k] = left[i];
                i++;
                k++;
            }else{
                sorted[k] = right[j];
                inv[0] += mid-start+1 - i ;
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
