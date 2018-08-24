//130.Surrounded Regions
class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length <= 1 || board[0].length <= 1) {
            return;
        }

        int m = board.length, n = board[0].length;
        Set<String> notFlip = new HashSet<> ();
        Set<String> startPoints = new HashSet<> ();

        for (int i = 0; i < m; i += m - 1) {
            for (int j = 0; j < n; j++) {
                String point = i + "," + j;
                if (board[i][j] == 'O' && !startPoints.contains(point)) {
                    startPoints.add(point);
                }
            }
        }

        for (int j = 0; j < n; j += n - 1) {
            for (int i = 0; i < m; i++) {
                String point = i + "," + j;
                if (board[i][j] == 'O' && !startPoints.contains(point)) {
                    startPoints.add(point);
                }
            }
        }

        Set<String> startPoints1 = new HashSet<> ();
        while(!startPoints.isEmpty()) {
            for(Iterator it1 = startPoints.iterator(); it1.hasNext();){
//                // System.out.println(it2.next());
//            for (String point: startPoints) {
                String point = (String)(it1.next());
                String[] index = point.split(",");
                int i = Integer.parseInt(index[0]), j = Integer.parseInt(index[1]);

                // add the adjacent 'O' into startPoints
                if (i - 1 >= 0 && board[i - 1][j] == 'O') {
                    int i1 = i - 1;
                    String p = i1 + "," + j;
                    if (!notFlip.contains(p) && !startPoints.contains(p)) {
                        startPoints1.add(p);
                    }
                }

                if (i + 1 < m && board[i + 1][j] == 'O') {
                    int i1 = i + 1;
                    String p = i1 + "," + j;
                    if (!notFlip.contains(p) && !startPoints.contains(p)) {
                        startPoints1.add(p);
                    }
                }

                if (j - 1 >= 0 && board[i][j - 1] == 'O') {
                    int j1 = j - 1;
                    String p = i + "," + j1;
                    if (!notFlip.contains(p) && !startPoints.contains(p)) {
                        startPoints1.add(p);
                    }
                }

                if (j + 1 < n && board[i][j + 1] == 'O') {
                    int j1 = j + 1;
                    String p = i + "," + j1;
                    if (!notFlip.contains(p) && !startPoints.contains(p)) {
                        startPoints1.add(p);
                    }
                }
//                startPoints.remove(point);
                notFlip.add(point);
            }
            startPoints = startPoints1;
            startPoints1 = new HashSet<>();
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String point = i + "," + j;
                if (notFlip.contains(point)) {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }

        return;
    }
}
