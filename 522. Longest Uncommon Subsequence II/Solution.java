// 522.Longest Uncommon Subsequence II



class Solution {

    public int findLUSlength(String[] strs) {

        int lenLUS = -1;

        for (int i = 0; i < strs.length; i++) {

            int j = 0;

            for (; j < strs.length; j++) {

                if (i == j) {

                    continue;

                }

                if (isSubsequence(strs[j], strs[i])) {

                    break;

                }

            }

            if (j == strs.length) {

                lenLUS = Math.max(lenLUS, strs[i].length());

            }

        }

        return lenLUS;

    }



    /**

     * 

     * @param s1

     * @param s2

     * @return true if s2 is subsequence s1 

     */

    private boolean isSubsequence(String s1, String s2) {

        int i2 = 0;

        for (int i1 = 0; i1 < s1.length() && i2 < s2.length(); i1++) {

            if (s1.charAt(i1) == s2.charAt(i2)) {

                i2++;

            }

        }

        return i2 == s2.length();

    }

}

