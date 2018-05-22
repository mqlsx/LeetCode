// 763. Partition Labels

class Solution {
    public List<Integer> partitionLabels(String S) {
        int[][] ranges = new int[26][2];
        for (int i = 1; i <= S.length(); i++) {
            char c = S.charAt(i - 1);
            if (ranges[c - 'a'][0] == 0) {
                ranges[c - 'a'][0] = i;
            }
            ranges[c - 'a'][1] = i;
        }
        
        Arrays.sort(ranges, Comparator.comparing((int[] a) -> a[0]));
        
        List<Integer> splitPoints = new ArrayList<Integer> ();
        for (int i = 0; i < 26; i++) {
            if (ranges[i][0] == 0) {
                continue;
            }
            boolean isSplitPoint = true;
            for (int j = 0; j < i; j++) {
                if (ranges[i][0] < ranges[j][1]) {
                    isSplitPoint = false;
                    break;
                }
            }
            if (isSplitPoint) {
                splitPoints.add(ranges[i][0]);
            }           
        }
        splitPoints.add(S.length() + 1);
        
        List<Integer> result = new ArrayList<Integer> ();
        while (splitPoints.size() > 1) {
            int len = splitPoints.get(1) - splitPoints.get(0);
            result.add(len);
            splitPoints.remove(0);
        }
        
        return result;
    }
}


class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;
        
        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }
}
