// 728. Self Dividing Numbers

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<Integer> ();
        for (int i = left; i <= right; i++) {
            if (isSelfDevide(i)) {
                result.add(i);
            }
        }
        return result;
    }
    
    boolean isSelfDevide(int num) {
        for (int i = num; i > 0; i /= 10) {
            int devisor = i % 10;
            if (devisor == 0 || num % devisor != 0) {
                return false;
            }
        }
        
        return true;
    }
}



class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList();
        for (int n = left; n <= right; ++n) {
            if (selfDividing(n)) ans.add(n);
        }
        return ans;
    }
    public boolean selfDividing(int n) {
        for (char c: String.valueOf(n).toCharArray()) {
            if (c == '0' || (n % (c - '0') > 0))
                return false;
        }
        return true;
    }
    /*
    Alternate implementation of selfDividing:
    public boolean selfDividing(int n) {
        int x = n;
        while (x > 0) {
            int d = x % 10;
            x /= 10;
            if (d == 0 || (n % d) > 0) return false;
        }
        return true;
    */
}
