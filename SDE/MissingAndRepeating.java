import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingAndRepeating {
    public static void main(String[] args) {
        
    }
}

class MAR {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        long array_sum = 0;
        long sum_n = 0;
        long square_sum = 0;
        long square_sum_n = 0;
        for (int i =0; i < A.size(); i++){
            array_sum += A.get(i);
            sum_n += i+1;
            square_sum += (long) A.get(i) * A.get(i);
            square_sum_n += (long) (i+1)*(i+1);
        }
        int repeating_num = (int) ( (array_sum-sum_n) + ((square_sum-square_sum_n)/(array_sum-sum_n))) / 2;
        int missing_num = repeating_num - (int) (array_sum-sum_n);
        return new ArrayList<>(Arrays.asList(repeating_num, missing_num));
        
    }
}