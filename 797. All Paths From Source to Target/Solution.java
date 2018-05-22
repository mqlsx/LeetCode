// 797. All Paths From Source to Target

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        List<Integer> path = new ArrayList<Integer> ();
        
        path.add(0);
        findPath(result, path, graph);
        
        return result;
    }
    
    void findPath(List<List<Integer>> result, List<Integer> path, int[][] graph) {
        int index = path.get(path.size() - 1);
        
        if (index == graph.length - 1) {
            // add path into result
            List<Integer> legalPath = new ArrayList<Integer> (path);
            result.add(legalPath);
            return;
        }
        
        for (int nextNode : graph[index]) {
            path.add(nextNode);
            findPath(result, path, graph);
            path.remove(path.size() - 1);
        }
    }
}
