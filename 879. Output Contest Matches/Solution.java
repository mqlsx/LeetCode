public class Solution {
    /**
     * @param n: a integer, denote the number of teams
     * @return: a string
     */
    public String findContestMatch(int n) {
        Deque<String> prev = new ArrayDeque<String>(n);
        Deque<String> cur = new ArrayDeque<String>(n / 2);
        
        for (int i = 1; i <= n; i++) {
            prev.add(String.valueOf(i));
        }
        
        StringBuilder sb = new StringBuilder();
        while (prev.size() > 1) {
            int size = prev.size();
            for (int i = 0; i < size / 2; i++) {
                sb.setLength(0);
                sb.append("(");
                sb.append(prev.pollFirst());
                sb.append(",");
                sb.append(prev.pollLast());
                sb.append(")");
                cur.add(sb.toString());
            }
            
            Deque<String> tmp = cur;
            cur = prev;
            prev = tmp;
        }
        
        return prev.poll();
    }
    
}
