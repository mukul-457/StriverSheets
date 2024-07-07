import java.util.Arrays;

public class RotateImage2 {
    public static void main(String[] args) {
        Rotat2 sol = new Rotat2();
        int[][] inp = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        sol.rotate(inp);
        System.out.println(Arrays.deepToString(inp));

    }
}

class Rotat2{

    public void rotate(int[][] matrix){
        transpose(matrix);
        reverseRows(matrix);
    }

    public void transpose(int[][] matrix){
        for (int i = 0; i < matrix.length ; i ++ ){
            for (int j = i+1 ; j < matrix.length; j ++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void reverseRows(int[][] matrix){
        for( int row = 0; row < matrix.length ; row++){
            int startCol = 0;
            int endCol = matrix.length-1;
            while (startCol<  endCol){
                int temp = matrix[row][startCol];
                matrix[row][startCol] = matrix[row][endCol];
                matrix[row][endCol] = temp;
                startCol++;
                endCol--;
            }
        }
    }
}