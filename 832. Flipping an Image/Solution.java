class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int row = 0; row < A.length; row++) {
            int l = 0, r = A.length - 1;
            for (; l < r; l++, r--) {
                // reverse
                int tmp = A[row][l];
                A[row][l] = A[row][r];
                A[row][r] = tmp;
                
                // inverse
                A[row][l] = 1 - A[row][l];
                A[row][r] = 1 - A[row][r];
            }
            if (l == r) {
                A[row][l] = 1 - A[row][l];
            }
        }
        
        return A;
    }
}
