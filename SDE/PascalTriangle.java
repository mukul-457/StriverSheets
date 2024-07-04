import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PascalTriangle {
    public static void main(String[] args) {
       Solution_ s = new Solution_();
       System.out.println(s.generate(5));
    }
}

class Solution_{

    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> triangle  = new ArrayList<>();
        triangle.add(Arrays.asList(1));
        if (numRows == 1){
            return triangle;
        }
        List<Integer> prvRow  = triangle.get(0);
        for (int row =2 ; row <= numRows ; row ++ ){
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            for (int index = 1 ; index < prvRow.size() ; index ++ ){
                currRow.add(prvRow.get(index) + prvRow.get(index-1));
            }
            currRow.add(1);
            triangle.add(new ArrayList<>(currRow));
            prvRow = currRow;
        }

        return triangle;
    }

}