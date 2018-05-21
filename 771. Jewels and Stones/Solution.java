class Solution {
    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null) {
            return 0;
        }
        int ans = 0;
        
        HashSet<Character> set = new HashSet<Character>();
        
        for (char c: J.toCharArray()) {
            set.add(c);
        }
        
        for (char s: S.toCharArray()) {
            if (set.contains(s)) {
                ans++;
            }
        }
        
        return ans;
    }
}
