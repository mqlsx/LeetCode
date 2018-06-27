//60. Permutation Sequence

class Solution {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        List<Integer> nums = new ArrayList<Integer>();
        
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        
        for (int i = 0; i < n; i++) {
            nums.add(i + 1);
        }
        
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            int j = k / factorial[i - 1];
            k %= factorial[i - 1];
            sb.append(nums.get(j));
            nums.remove(j);
        }
        
        return sb.toString();
    }
}
