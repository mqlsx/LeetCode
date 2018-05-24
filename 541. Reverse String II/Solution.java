// 541. Reverse String II

class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for (String word : words) {
            sb.append(new StringBuilder(word).reverse().toString());
            sb.append(" ");
        }
        
        return sb.toString().trim();
    }
}
