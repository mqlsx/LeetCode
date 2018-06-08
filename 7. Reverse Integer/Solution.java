// 7. Reverse Integer

class Solution {
    public int reverse(int x) {
        long num = Math.abs(x);
        long result = 0;
        
        while (num > 0) {
            result = 10 * result + num % 10;
            num /= 10;
        }
        if (x < 0) {
            result *= -1;
        }
        
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        
        return (int) result;
    }
}
