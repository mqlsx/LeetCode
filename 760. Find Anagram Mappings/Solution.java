public class Solution {
    /**
     * @param A: lists A
     * @param B: lists B
     * @return: the index mapping
     */
    public int[] anagramMappings(int[] A, int[] B) {
        // Write your code here
        if (A == null || B == null) {
            return null;
        }
        if (A.length == 0 || A.length != B.length) {
            return null;
        }
        
        int[] p = new int[A.length];
        
        Map<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();
        for (int i = 0; i < B.length; i++) {
            if (!map.containsKey(B[i])) {
                // create a new entry
                map.put(B[i], new LinkedList<Integer>(Arrays.asList(i)));
            } else {
                // add the index i into the corresponding entry
                map.get(B[i]).add(i);
            }
        }
        
        for (int i = 0; i < A.length; i++) {
            LinkedList<Integer> list = map.get(A[i]);
            p[i] = list.get(list.size() - 1);
            list.remove(list.size() - 1);
        }
        
        return p;
    }
}




public class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        // Write your code here
        
        Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        
        for(int i =0;i<B.length;i++){
            if(!map.containsKey(B[i])){
                map.put(B[i],new LinkedList<Integer>());
            }
            
            map.get(B[i]).add(i);
        }
        
        int[] res = new int[A.length];
        
        for(int i =0;i<A.length;i++){
            List<Integer> list=map.get(A[i]);
            int index =list.get(list.size()-1);
            res[i]=index;
            list.remove(list.size()-1);
        }
        
        return res;
    }
}
