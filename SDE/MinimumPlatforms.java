import java.util.Arrays;
public class MinimumPlatforms {

    public static void main(String[] args) {
        int[] arr = new int[]{1026, 445, 145, 555, 710, 1712,
             1105, 506, 531, 1930, 220, 611, 
             553, 53, 401, 2000, 225, 1359, 1159, 120 };
        int[] dep = new int[]{1713, 2242, 1144, 848 ,1941, 1734, 
            2347, 1726, 2247, 2018 ,355, 2249,
             2134 ,758, 2044 ,2354 ,237, 2152, 1221, 532};  
        System.out.println(MinP.findPlatform(arr, dep, 20));
    }
}

class MinP
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        int[][] rails = new int[n][2];
        
        for (int i = 0; i < n ; i++){
            rails[i][0] = arr[i];
            rails[i][1] = dep[i];
        }
        
        Arrays.sort(rails, (a,b)->{
            return Integer.compare(a[1], b[1]);
        });
        
        int platforms=0;
        int j  = 0; 
        for(int i = 0; i < n; i++){
            if(rails[i][0] <= rails[j][1]){
                platforms++;
            }else{
                j++;
            }
        }
        return platforms;        
    }

}