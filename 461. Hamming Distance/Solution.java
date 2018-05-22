// 461. Hamming Distance

class Solution {    
    public int hammingDistance(int x, int y) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += ((x ^ y) >> i) & 1;
        }    
        return count;
    }
}
