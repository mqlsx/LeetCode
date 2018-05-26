// 791. Custom Sort String

class Solution {
    public String customSortString(String S, String T) {
        if (S == null || S.length() == 0 || T == null || T.length() == 0) {
            return T;
        }
        
        Map<Character, Integer> map = new HashMap<Character, Integer> ();
        for (char c : T.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            int freq = map.getOrDefault(c, 0);
            map.remove(c);
            for (int i = 0; i < freq; i++) {
                sb.append(c);
            }
        }
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            for (int i = 0; i < freq; i++) {
                sb.append(entry.getKey());
            }
        }
        
        return sb.toString();
    }
}
