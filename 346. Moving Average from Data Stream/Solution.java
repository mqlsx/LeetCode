346. Moving Average from Data Stream

public class MovingAverage {
    private int size;
    private long sum;
    private Queue<Integer> queue;
    
    public MovingAverage(int size) {
        // do intialization if necessary
        sum = 0;
        this.size = size;
        queue = new LinkedList<Integer> ();
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        // write your code here
        if (size == 0) {
            return 0;
        }
        
        if (queue.size() == this.size) {
            int tmp = queue.poll();
            sum -= tmp;
        }
        
        queue.add(val);
        sum += val;
        
        return (double) sum / queue.size();
        
    }
}
