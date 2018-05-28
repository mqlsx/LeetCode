// 266. Palindrome Permutation

public class Solution {
    /**
     * @param s: the given string
     * @return: if a permutation of the string could form a palindrome
     */
    public boolean canPermutePalindrome(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return true;
        }
        
        Map<Character, Integer> map = new HashMap<Character, Integer> ();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int oddTimes = 0;
        for (int times : map.values()) {
            if (times % 2 == 1) {
                oddTimes++;
            }
            
            if (oddTimes > 1) {
                return false;
            }
        }
        return true;
    }

}