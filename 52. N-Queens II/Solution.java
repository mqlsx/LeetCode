//52. N-Queens II

public class Solution {
    public int totalNQueens(int n) {
        return solve1(new int[n], n, 0);
        // return solve2(0, new boolean[n], new boolean[2*n], new boolean[2*n], n);
    }
    public int solve1(int[] c, int n, int index) {
        if(index == n) {
            return 1;
        }
        int num = 0;
        // 从第一列开始遍历
        for(int j=0;j<n;j++) {
            c[index] = j; // 将第index行的皇后放在第j列
            boolean has = false; // 是否有冲突标志位
            // 遍历当前已放置好的皇后，看是否有冲突
            for(int i=0;i<index;i++) {
                if(c[i] == c[index] || Math.abs(i-index)==Math.abs(c[i]-c[index])) {
                    has = true;
                }
            }
            if(!has) {
                // 如果没有冲突，当前解法可行，增加一位皇后
                num += solve1(c, n, index+1);
            }
        }
        return num;
    }
}