//56.Merge Intervals

/** 
 * Definition for an interval. 
 * public class Interval { 
 *     int start; 
 *     int end; 
 *     Interval() { start = 0; end = 0; } 
 *     Interval(int s, int e) { start = s; end = e; } 
 * } 
 */  
public class Solution {  
    public List<Interval> merge(List<Interval> intervals) {  
        if (intervals == null || intervals.size() == 0) {
            return new ArrayList();
        }
        
        List<Interval> list = new ArrayList<Interval> ();  
        //排序，实现了Comparator接口  
        Collections.sort(intervals, new Comparator<Interval> () {  
  
            @Override  
            public int compare(Interval o1, Interval o2) {  
                // TODO Auto-generated method stub  
                return o1.start - o2.start;
            }  
        });  
          
        // problems
        // 1 not add the last interval into the result list
        // 2 [[1,4],[2,3]] -> output [1, 3]
        
        Interval cur = intervals.get(0);   
        for(int i = 1; i < intervals.size(); i++){  
            Interval intv = intervals.get(i);
            if (cur.end < intv.start) {
                list.add(cur);
                cur = intv;
                continue;
            }
            
            cur = new Interval(cur.start, Math.max(cur.end, intv.end));
        } 
        list.add(cur);
        
        return list;  
    }  
} 

