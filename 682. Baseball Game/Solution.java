// 682. Baseball Game

class Solution {
    public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) {
            return 0;
        }
        
        List<Integer> scores = new ArrayList<Integer> ();
        for (String s : ops) {
            switch (s) {
                case "C":
                    scores.remove(scores.size() - 1);
                    break;
                case "D":
                    scores.add(2 * scores.get(scores.size() - 1));
                    break;
                case "+":
                    scores.add(scores.get(scores.size() - 1) + scores.get(scores.size() - 2));
                    break;
                default:
                    scores.add(Integer.valueOf(s));
                    break;
            }
        }
        
        int sum = 0;
        for (int i = 0; i < scores.size(); i++) {
            sum += scores.get(i);
        }
        
        return sum;
    }
}