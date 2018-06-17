// 42. Trapping Rain Water


class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int ans = 0;
        int lMax = height[0], rMax = height[height.length - 1];
        int l = 0, r = height.length - 1;
        while (l < r) {
            if (lMax < rMax) {
                l++;
                if (height[l] > lMax) {
                    lMax = height[l];
                } else {
                    ans += lMax - height[l];
                }
            } else {
                r--;
                if (height[r] > rMax) {
                    rMax = height[r];
                } else {
                    ans += rMax - height[r];
                }
            }
        }
        return ans;
    }
}

