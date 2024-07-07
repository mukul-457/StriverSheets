import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        Rotate sol = new Rotate();
        int[][] inp = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        sol.rotate(inp);
        System.out.println(Arrays.deepToString(inp));        
    }

}

class Rotate{
    public void rotate(int[][] matrix) {
        int row = 0;
        for (int dim = matrix.length; dim > 0 ; dim=dim-2){
            rotateOuterLayer(matrix, dim, row);
            row += 1;
        }
    }

    public void rotateOuterLayer(int[][] mat , int dim, int row){
        int col = row ;
        for (int itr= 0; itr < dim-1; itr++){
            doNSwaps(row, col, dim , mat);
            col++;
        }
    }


    public void doNSwaps(int row , int col , int dim, int[][] mat){
        int temp = mat[row][col];
        int currRow = row;
        int currCol = col;
        int size = mat.length;
        for(int i = 0; i < 3; i++){
            int nextRow = size-1-currCol;
            int nextCol = currRow;
            mat[currRow][currCol] = mat[nextRow][nextCol];
            currRow = nextRow;
            currCol = nextCol;
    }
        mat[currRow][currCol] = temp;
    }
}