// 484.Find Permutation



public class Solution {



    public int[] findPermutation(String s) {

        // write your code here

        int[] result = new int[s.length() + 1];

        

        int index = 0;

        for (int i = 0; i <= s.length(); i++) {

            if (i == s.length() || s.charAt(i) == 'I') {

                for (int j = i + 1; index <= i; index++) {

                    result[index] = j;

                    j--;

                }

            }

        }

        return result;

    }

}