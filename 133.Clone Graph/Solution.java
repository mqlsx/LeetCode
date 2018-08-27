//133.Clone Graph
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    HashMap<Integer, UndirectedGraphNode> visited = new HashMap<> ();
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return node;
        }

        if(visited.containsKey(node.label)) {
            return visited.get(node.label);
        }
        
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        visited.put(clone.label, clone);
        
        for(UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        
        return clone;
    }
}