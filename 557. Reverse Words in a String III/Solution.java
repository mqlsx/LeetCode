// 557. Reverse Words in a String III

class Solution {
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            int j = i, l = Math.min(j + k - 1, s.length() - 1);
            while (j < l) {
                char tmp = a[j];
                a[j] = a[l];
                a[l] = tmp;
                j++;
                l--;
            }
        }
        
        return String.valueOf(a);
    }
}
