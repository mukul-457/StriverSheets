

public class BinaryMatrixMedian {
    public static void main(String[] args) {
        int[][] inp = {{1,3,5},{2,6,9},{3,6,9}};
        BMM sol = new BMM();
        System.out.println(sol.median(inp, 3, 3));

    }
}


class BMM {
    int median(int matrix[][], int R, int C) {
        // code here  
        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;
        for (int  r = 0; r < R ; r++){
            if (matrix[r][0] < low){
                low = matrix[r][0];
            }
            if(matrix[r][C-1] > high){
                high = matrix[r][C-1];
            }
        }
        int magic_value = (R*C )/2;
        while(low <= high){
            int mid = (low + high) / 2 ; 
            int ge = valuesGET(matrix, mid,C);
            if(ge > magic_value){
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }

        return low;


    }

    int valuesGET(int[][] matrix, int mid, int C){
        int total = 0;
        for(int[] row : matrix){
            total += upperBound(row, C-1, mid);
        }
        return total;
    }

    int upperBound(int[] row , int last_index, int value){
        int start = 0;
        int end = last_index;
        while (start < end){
            int mid = (start + end) / 2;
            if(row[mid] <= value ){
                start = mid+1;
            }else{
                end = mid;
            } 
        }
        if (row[start] > value){
            return start;
        }
        return start+1;
    }


}