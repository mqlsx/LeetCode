//115.Distinct Subsequences
public class Solution {
    public int numDistinct(String s, String t) {
    	// t is the string we want to match
        if(s == null || t == null || s.length() < t.length()) {
        	return 0;
        }

        int[][] dp = new int[t.length() + 1][s.length() + 1];
        
        for(int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 1;
        }
        
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(s.charAt(j - 1) == t.charAt(i - 1)) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        
        return dp[t.length()][s.length()];
    }
}