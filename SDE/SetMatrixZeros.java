import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeros{

    public static void main(String[] args) {
        int[][] mat = {{1,0,3}};
        Solution s = new Solution();
        s.setZeroes(mat);
        // for (int i =0 ; i < 3 ; i++){
        //     System.out.printf("%d , %d , %d" , mat[i][0] ,mat[i][1], mat[i][2]);
        //     System.out.println();
        // }
        // System.out.println(mat);
    }    
}


class Solution{
    public void setZeroes(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int firstRow = matrix[0][0];
        int firstCol = matrix[0][0];
        for (int row =0 ; row < m ; row ++ ){
            for (int col = 0 ; col < n ; col++){
                if (matrix[row][col] == 0){
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                    if (col == 0){
                        firstCol = 0 ;
                    }
                    if (row  == 0){
                        firstRow = 0;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        update(matrix, m,n,firstRow, firstCol);
        System.out.println(Arrays.deepToString(matrix));
    }

    public void update(int[][]matrix, int m,int n, int firstRow,int firstCol){


        for(int i =m-1 ; i >0  ; i--){
            if(matrix[i][0] == 0){
                for(int j =1; j < n;j ++ ){
                    matrix[i][j] = 0  ;
                }
            }
        }

        for(int j = n-1; j > 0 ; j -- ){
            if (matrix[0][j] == 0 ){
                for(int i = 1 ; i < m ; i++  ){
                    matrix[i][j] = 0;
                }
            }

        }

        if(firstCol == 0 ){
            for (int i = 1; i < m ; i ++){
                matrix[i][0] = 0;
            }
        }
        if(firstRow == 0){
            for (int j =1; j < n ; j ++ ){
                matrix[0][j] = 0;
            }
        }
                
    }
}