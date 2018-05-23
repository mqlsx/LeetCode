806. Number of Lines To Write String

class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int line = 1, width = 0;
        for (char c : S.toCharArray()) {
            width += widths[c - 'a'];
            if (width > 100) {
                width = widths[c - 'a'];
                line++;
            }
        }
        
        return new int[] {line, width};
    }
}
