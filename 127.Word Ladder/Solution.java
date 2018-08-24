//127.Word Ladder
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    	if (wordList == null || wordList.size() == 0 || beginWord.equals(endWord)) {
    		return 0;
    	}

    	Set<String> wordSet = new HashSet<> (wordList);
    	if (!wordSet.contains(endWord)) {
    		return 0;
    	}

    	Set<String> visited = new HashSet<> ();
    	visited.add(beginWord);
    	int dist = 1;

    	while (!visited.contains(endWord)) {
    		Set<String> temp = new HashSet<> ();
    		for (String word: visited) {
    			// get all possible one step change to word
    			for (int i = 0; i < word.length(); i++) {
    				char[] chars = word.toCharArray();
    				for (int j = (int)'a'; j <= (int)'z'; j++) {
    					chars[i] = (char)j;
    					String newWord = new String(chars);
    					if (wordSet.contains(newWord)) {
    						temp.add(newWord);
    						wordSet.remove(newWord);
    					}
    				}
    			}    			
    		}
    		if (temp.size() == 0) {
				return 0;
			}
			dist++;
			visited = temp;
    	}

    	return dist;
    }
}