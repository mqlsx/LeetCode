// 750.Number Of Corner Rectangles



class Solution {
    public int countCornerRectangles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int cnt = 0;
                for (int k = 0; k < n; k++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1) {
                        cnt++;
                    }
                }
                res += cnt * (cnt - 1) / 2;
            }
        }
        return res;
    }
}
