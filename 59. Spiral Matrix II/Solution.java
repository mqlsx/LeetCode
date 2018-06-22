//59. Spiral Matrix II

class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return null;
        }
        
        int[][] result = new int[n][n];
        int minRow = 0, maxRow = n - 1;
        int minCol = 0, maxCol = n - 1;
        int num = 1;
        while (num <= n * n) {
            for (int i = minCol; i <= maxCol; i++) {
                result[minRow][i] = num++;
            }
            minRow++;
            
            if (num <= n * n) {
                for (int i = minRow; i <= maxRow; i++) {
                    result[i][maxCol] = num++;
                }
                maxCol--;
            }
            
            if (num <= n * n) {
                for (int i = maxCol; i >= minCol; i--) {
                    result[maxRow][i] = num++;
                }
                maxRow--;
            }
            
            if (num <= n * n) {
                for (int i = maxRow; i >= minRow; i--) {
                    result[i][minCol] = num++;
                }
                minCol++;
            }
        }
        
        return result;
    }
}
