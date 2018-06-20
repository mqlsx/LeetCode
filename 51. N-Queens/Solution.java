// N-Queens
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        if (n <= 0) {
            return new ArrayList();
        }

        List<List<String>> result = new ArrayList();
        Map<Integer, Integer> path = new HashMap<Integer, Integer>();
        helper(path, result, n);
        return result;
    }

    private void helper(Map<Integer, Integer> path, List<List<String>> result, int n) {
        if (path.size() == n) {
            result.add(createChessBoard(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValidPosition(i, path)) {
                // put a queen at place i
                path.put(path.size(), i);
                helper(path, result, n);
                path.remove(path.size() - 1);
            }
        }
    }

    // to do
    private List<String> createChessBoard(Map<Integer, Integer> path) {
        List<String> board = new ArrayList<String>(path.size());
        for (Map.Entry<Integer, Integer> entry: path.entrySet()) {
            int index = entry.getKey();
            int val = entry.getValue();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                if (i == val) {
                    sb.append('Q');
                    //sb.append(' ');
                } else {
                    sb.append('.');
                    //sb.append(' ');
                }
            }
            board.add(sb.toString());
        }
        return board;
    }

    // to do
    private boolean isValidPosition(int i, Map<Integer, Integer> path) {
        if (path.containsValue(i)) {
            return false;
        }

        for (Map.Entry<Integer, Integer> entry: path.entrySet()) {
            int x1 = entry.getKey();
            int y1 = entry.getValue();
            int x2 = path.size();
            int y2 = i;
            if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
                return false;
            }
        }
        return true;
    }
}

