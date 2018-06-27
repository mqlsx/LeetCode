//70. Climbing Stairs

class Solution {
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        
        int oneStepBefore = 1;
        int twoStepBefore = 0;
        
        for (int i = 0; i < n; i++) {
            int tmp = oneStepBefore + twoStepBefore;
            twoStepBefore = oneStepBefore;
            oneStepBefore = tmp;
        }
        
        return oneStepBefore;
    }
}

