class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        
        String[] alphabet = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<String> ();
        
        for (String word : words) {
            sb.setLength(0);
            
            for (char c : word.toCharArray()) {
                sb.append(alphabet[c - 'a']);
            }
            if (!set.contains(sb.toString())) {
                set.add(sb.toString());
            }
        }
        
        return set.size();
    }
}
