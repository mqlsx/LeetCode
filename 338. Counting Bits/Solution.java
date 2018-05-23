338. Counting Bits

public class Solution {
    public int[] countBits(int num) {
        if (num == 0) {
            return new int[] {0};
        }
        
        int[] ans = new int[num + 1];
        int pow = 1;
        int startIndex = 1;
        for (int i = 1; i <= num; i++) {
            if (i == pow) {
                ans[i] = 1;
                startIndex = 1;
                pow *= 2;
            } else {
                ans[i] = ans[startIndex] + 1;
                startIndex++;
            }
        }
        
        return ans;
    }
}
