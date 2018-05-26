// 500. Keyboard Row

class Solution {
    public String[] findWords(String[] words) {
        if (words == null || words.length == 0) {
            return new String[0];
        }
        List<String> result = new ArrayList<String> ();
        
        List<Set<Character>> setList = new ArrayList ();  
        String[] s = {"qwertyuiopQWERTYUIOP", "asdfghjklASDFGHJKL", "zxcvbnmZXCVBNM"};
        for (int i = 0; i < 3; i++) {
            Set<Character> set = new HashSet<Character> ();
            for (char c : s[i].toCharArray()) {
                set.add(c);
            }
            setList.add(set);
        }
        
        for (String word : words) {
            
            for (int i = 0; i < 3; i++) {
                Set<Character> set = setList.get(i);
                boolean isKBRow = true;
                for (char c : word.toCharArray()) {
                    if (!set.contains(c)) {
                        isKBRow = false;
                        break;
                    }
                }
                if (isKBRow) {
                    result.add(word);
                    break;
                }
            }
        }
        
        return result.toArray(new String[result.size()]);
    }
}
