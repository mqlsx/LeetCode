419. Battleships in a Board

public class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        
        int result = 0;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'X' && (r == 0 || board[r - 1][c] == '.') && (c == 0 || board[r][c - 1] == '.')) {
                    result++;
                }
            }
        }
        
        return result;
    }
}
