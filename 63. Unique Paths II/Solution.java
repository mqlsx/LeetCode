//63. Unique Paths II

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1)
            return 0;
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        int[] res = new int[columns];
        res[0] = 1;
        for(int i = 0; i < rows; i ++) {
            if(obstacleGrid[i][0] == 1)
                res[0] = 0;
            for(int j = 1; j < columns; j ++) {
                if(obstacleGrid[i][j] == 0)
                    res[j] = res[j - 1] + res[j];
                else
                    res[j] = 0;
            }
        }
        return res[columns - 1];
    }
}
