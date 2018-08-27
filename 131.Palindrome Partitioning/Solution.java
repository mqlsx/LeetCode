//131.Palindrome Partitioning
public class Solution {
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<> ();
        }
        
        List<List<String>> res = new ArrayList<> ();
        List<String> list = new ArrayList<> ();
        partition(res, list, s);
        return res;
    }
    
    private void partition(List<List<String>> res, List<String> list, String s) {
        if (s == null || s.length() == 0) {
            res.add(new ArrayList<String> (list));
            return;
        }
        
        for (int i = 0; i < s.length(); i++) {
            String subStr = s.substring(0, i + 1);
            if (isPalindrome(subStr)) {
                list.add(subStr);
                partition(res, list, s.substring(i + 1));
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}