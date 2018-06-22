//58. Length of Last Word

class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        s = s.trim();
        int len = 0;
        int index = s.length() - 1;
        while (index >= 0 && s.charAt(index) != ' ') {
            len++;
            index--;
        }
        return len;
    }
}
