public class BinarySearchMatrix {
    public static void main(String[] args) {
        BSM sol  = new BSM();
        int[][] mat = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(sol.searchMatrix(mat,7));
    }
}

class BSM {
    public boolean searchMatrix(int[][] matrix, int target) {
        int endRow  = matrix.length-1;
        return searchRow(matrix, target, 0, endRow);
    }

    public boolean searchRow(int[][] matrix , int target, int startRow  ,int endRow){
        if(startRow == endRow){
            if (matrix[startRow][0] > target || matrix[startRow][matrix[0].length-1] < target){
                return false;
            }
        }
        int midRow = startRow + (endRow-startRow) / 2;
        if (matrix[midRow][0] > target){
            return searchRow(matrix, target, startRow, midRow);
        }else if (matrix[midRow][matrix[0].length-1] < target){
            return searchRow(matrix, target, midRow+1, endRow);
        }else{
            return searchCol(matrix, target, 0, matrix[0].length-1, midRow);
        }
    }

    public boolean searchCol(int[][]matrix,int target,  int startCol , int endCol, int row ){

        if (startCol == endCol){
            if (matrix[row][startCol] != target){
                return false;
            }
        }

        int midCol = startCol + (endCol-startCol)/2;
        if (matrix[row][midCol] > target){
            return searchCol(matrix, target, startCol, midCol, row);
        }else if(matrix[row][midCol] < target){
            return searchCol(matrix, target, midCol+1, endCol, row);
        }else{
            return true;
        }
    }

}