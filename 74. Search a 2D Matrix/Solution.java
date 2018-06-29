//74. Search a 2D Matrix

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length <= 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length <= 0) {
            return false;
        }
        
        
        int row = matrix.length, col = matrix[0].length;
        int start = 0, end = row - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (matrix[start][0] <= target && matrix[start][col - 1] >= target) {
            row = start;
        } else {
            row = end;
        }
        
        start = 0;
        end = col - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (matrix[row][start] == target || matrix[row][end] == target) {
            return true;
        } else {
            return false;
        }
    }
}
