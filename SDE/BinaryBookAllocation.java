import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class BinaryBookAllocation {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(5, 17, 100, 11));
        BA sol = new BA();
        System.out.println(sol.books(a, 4)); 
    }
}


class BA {
    public int books(ArrayList<Integer> A, int B) {
        if (A.size() < B){
            return -1;
        }
        int low = Collections.min(A);
        int high = 0;
        for(Integer i: A){
            high += i;
        }
        while (low <=high){
            int mid = (low) +( high-low)/2;
            boolean midb = isAPos(mid, A, B);
            boolean midb1 = isAPos(mid-1, A, B);
            if (midb && ! midb1){
                return mid;
            }else if (midb){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
    
    public boolean isAPos(int max_page, ArrayList<Integer> bookarr, int students){
        int s  = bookarr.size();
        if (Collections.max(bookarr) > max_page){
            return false;
        }

        int cur_pg = 0;
        int i =0;
        while( i < s && students > 0){
            cur_pg = 0;
            while(i< s && s-i > students-1 && cur_pg + bookarr.get(i) <= max_page){
                cur_pg += bookarr.get(i);
                i++;
            }
            students--;
        }

        return i >=s && students <= 0;
    }
}