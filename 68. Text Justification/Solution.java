//68. Text Justification

public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> lines = new ArrayList<String>();
        // index of first word for every line
        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
 
            //get the last word which can fit into one line,
            while (last < words.length) {
                if (words[last].length() + count + 1 > L) break;
                count += words[last].length() + 1;
                last++;
            }
             
            StringBuilder builder = new StringBuilder();
            // how manny numbers in the one line
 
            int diff = last - index - 1;
            // if last line or number of words in the line is 1, left-justified
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    builder.append(words[i] + " ");
                }
                builder.deleteCharAt(builder.length() - 1);
 
                // use space to suplement the length in the line
                for (int i = builder.length(); i < L; i++) {
                    builder.append(" ");
                }
            } else {
                // middle justified compute average number of space between two words.
                //If space number cannot be divided, the number of space between
                //two words in the front of the line is one more than the back.
 
                int spaces = (L - count) / diff;
                int r = (L - count) % diff;
                for (int i = index; i < last; i++) {
                    builder.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
                            builder.append(" ");
                        }
                    }
                }
            }
            lines.add(builder.toString());
            //update the index of fist word in the next line
            index = last;
        }
         
         
        return lines;
    }
}
