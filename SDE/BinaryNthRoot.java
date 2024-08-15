public class BinaryNthRoot {
    
}

class BNR {
    public static int NthRoot(int n, int m) {
        // Write your code here.
        int left = 1 ;
        int right = m;
        while(left < right){
            int mid = left + (int) (right-left) / 2;
            int power_n = (int) Math.pow(mid, n);
            if (power_n == m ){
                return mid;
            }else if (power_n > m){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }


}