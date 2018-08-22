//118.Pascal's Triangle
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<> ();
        }
        
        List<List<Integer>> res = new ArrayList<> ();
        List<Integer> level = new ArrayList<> ();
        
        level.add(1);
        res.add(level);
        
        for(int i = 1; i < numRows; i++) {
            level = new ArrayList<> ();
            level.add(1);
            
            List<Integer> lastLevel = res.get(res.size() - 1);
            for(int j = 1; j < res.size(); j++) {
                int a = lastLevel.get(j - 1);
                int b = lastLevel.get(j);
                level.add(a + b);
            }
            level.add(1);
            res.add(level);
        }
        
        return res;
    }
}