//57. Insert Interval

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals == null || newInterval == null) {
            return intervals;
        }
        
        List<Interval> res = new ArrayList<> ();
        for(Interval cur : intervals) {
            if(cur.end < newInterval.start) {
                res.add(cur);
            }
            else if(cur.start > newInterval.end){
                res.add(newInterval);
                newInterval = cur;
            }
            else{
                newInterval.start = Math.min(cur.start, newInterval.start);
                newInterval.end = Math.max(cur.end, newInterval.end);
            }
        }
        res.add(newInterval);
        
        return res;
    }
}
