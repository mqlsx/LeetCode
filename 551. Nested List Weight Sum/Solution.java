// 551. Nested List Weight Sum

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        // Write your code here
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        
        return computeSum(nestedList, 1);
    }
    
    int computeSum(List<NestedInteger> nestedList, int depth) {
        if (nestedList.size() == 0) {
            return 0;
        }
        
        int sum = 0;
        for (int i = 0; i < nestedList.size(); i++) {
            if (nestedList.get(i).isInteger()) {
                sum += depth * nestedList.get(i).getInteger();
            } else {
                sum += computeSum(nestedList.get(i).getList(), depth + 1);
            }
        }
        return sum;
    }
}
