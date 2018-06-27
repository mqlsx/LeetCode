//64. Minimum Path Sum

public class Solution {
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid.length];
        dp[0] = grid[0][0];
        for(int i=1; i<grid.length; i++) dp[i] = grid[i][0]+dp[i-1];
        for(int j=1; j<grid[0].length; j++)
            for(int i=0; i<grid.length; i++)
                dp[i] = (i==0 ? dp[i] : Math.min(dp[i], dp[i-1])) + grid[i][j];
        return dp[grid.length-1];
    }
}
