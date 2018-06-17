// 43


class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "";
        }
        
        int m = num1.length(), n = num2.length();
        int[] ans = new int[m + n];
        for (int j = n - 1; j >= 0; j--) {
            int digit = num2.charAt(j) - '0';
            if (digit == 0) {
                continue;
            }
            
            for (int i = m - 1; i >= 0; i--) {
                int val = digit * (num1.charAt(i) - '0') + ans[m + n - 2 - i - j];
                ans[m + n - 2 - i - j] = val % 10;
                ans[m + n - 1 - i - j] += val / 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int start = ans.length - 1;
        while (start >= 0 && ans[start] == 0) {
            start--;
        }
        if (start < 0) {
            return "0";
        }
        
        for (int i = start; i >= 0; i--) {
            sb.append(ans[i]);
        }
        return sb.toString();
    }
}
