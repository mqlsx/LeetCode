class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[] topView = new int[col];
        int[] leftView = new int[row];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                topView[j] = Math.max(topView[j], grid[i][j]);
                leftView[i] = Math.max(leftView[i], grid[i][j]);
            }
        }
        
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result += Math.min(leftView[i], topView[j]) - grid[i][j];
            }
        }
        
        return result;
    }
}



class Solution1 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int N = grid.length;
        int[] rowMaxes = new int[N];
        int[] colMaxes = new int[N];

        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c) {
                rowMaxes[r] = Math.max(rowMaxes[r], grid[r][c]);
                colMaxes[c] = Math.max(colMaxes[c], grid[r][c]);
        }

        int ans = 0;
        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c)
                ans += Math.min(rowMaxes[r], colMaxes[c]) - grid[r][c];

        return ans;
    }
}
