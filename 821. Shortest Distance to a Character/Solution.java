821. Shortest Distance to a Character

class Solution {
    public int[] shortestToChar(String S, char C) {
        int N = S.length();
        int[] result = new int[N];
        int prev = -1;
        
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == C) {
                prev = i;
            }
            
            if (prev == -1) {
                result[i] = Integer.MAX_VALUE;
            } else {
                result[i] = i - prev;
            }
        }
        
        prev = -1;
        for (int i = N - 1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                prev = i;
            }
            
            if (prev != -1) {
                result[i] = Math.min(result[i], prev - i);
            }
        }
        
        return result;
    }
}
