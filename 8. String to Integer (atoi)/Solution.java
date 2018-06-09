// 8.String to Integer (atoi)

class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        String s = str.trim();
        if (s.length() == 0) {
            return 0;
        }
        
        int sign = 1;
        int index = 0;
        if (s.charAt(0) == '+') {
            index++;
        }
        if (s.charAt(0) == '-') {
            index++;
            sign = -1;
        }
        
        long result = 0;
        for (; index < s.length(); index++) {
            char c = s.charAt(index);
            if (c < '0' || c > '9') {
                break;
            }
            
            result = result * 10 + c - '0';
            
            if (sign > 0 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign < 0 && sign * result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        
        return (int) result * sign;
    }
}
