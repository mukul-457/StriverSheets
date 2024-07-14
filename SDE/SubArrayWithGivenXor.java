import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArrayWithGivenXor {
    public static void main(String[] args) {
        SGX sgx = new SGX();
        ArrayList<Integer> inp = new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9));
        System.out.println(sgx.solve(inp, 5));
        
    }
}


class SGX {

    public int solve(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> all_xors = new HashMap<>();
        int currXor  = 0;
        int total_num = 0;
        for(int i =0 ; i < A.size(); i ++){
            currXor = currXor ^ A.get(i);
            if (currXor == B){
                total_num += 1;
            } 
            if (all_xors.containsKey(B^currXor)){
                int prv = all_xors.get(B^currXor);
                total_num += prv;
            }
            if(all_xors.containsKey(currXor)){
                all_xors.put(currXor, all_xors.get(currXor) + 1);
            }
            else{
                all_xors.put(currXor, 1);
            }

        }
        return total_num;
    }
}
