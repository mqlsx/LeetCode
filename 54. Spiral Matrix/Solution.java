//54. Spiral Matrix

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList();
        }
        
        List<Integer> result = new ArrayList<Integer> ();
        int matrixSize =  matrix.length * matrix[0].length;
        int minRow = 0, maxRow = matrix.length - 1;
        int minCol = 0, maxCol = matrix[0].length - 1;
        
        while (result.size() < matrixSize) {
            for (int i = minCol; i <= maxCol; i++) {
                result.add(matrix[minRow][i]);
            }
            minRow++;
            
            if (result.size() < matrixSize) {
                for (int i = minRow; i <= maxRow; i++) {
                    result.add(matrix[i][maxCol]);
                }
                maxCol--;
            }
            
            if (result.size() < matrixSize) {
                for (int i = maxCol; i >= minCol; i--) {
                    result.add(matrix[maxRow][i]);
                }
                maxRow--;
            }
            
            if (result.size() < matrixSize) {
                for (int i = maxRow; i >= minRow; i--) {
                    result.add(matrix[i][minCol]);
                }
                minCol++;
            }
        }
        return result;
    }
}


