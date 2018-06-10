// 9. Palindrome Number

class Solution {
    public boolean isPalindrome(int x) {
        int num = x;
        
        int result = 0;
        while (num > 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }
        
        return x == result;
    }
}
