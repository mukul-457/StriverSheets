public class BinaryFirstMatchIndex {
    public static void main(String[] args) {
          int[] inp = {9,9,9,10,11,11,11,11};
          int match = 9;
          int low = 0;
          int high = inp.length -1;
          while(low <= high){
            if (low == high){
                break;
            }
            int mid = ( low+high ) / 2 ;
            if(inp[mid] >= match){
                high = mid-1;
            }else{
                low = mid+1;
            }
          }
          if(inp[low] == match){
            System.out.println(low);
          }else{
            System.out.println(low+1);
          } 
    }
}
