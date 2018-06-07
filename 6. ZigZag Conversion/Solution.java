// 6.ZigZag Conversion



class Solution {

    String convert(String s, int nRows) {

        if (s == null || s.length() == 0) {

            return s;

        }

        

        StringBuilder[] sb = new StringBuilder[nRows];

        for (int i = 0; i < nRows; i++) {

            sb[i] = new StringBuilder();

        }

        

        int i = 0;

        while (i < s.length()) {     

            int r = 0;

            for (; r < nRows; r++) {

                if (i >= s.length()) {

                    break;

                }

                sb[r].append(s.charAt(i++));

            }

            

            for (r -= 2; r > 0; r--) {

                if (i >= s.length()) {

                    break;

                }

                sb[r].append(s.charAt(i++));

            }

        }

        

        for (i = nRows - 1; i >= 1; i--) {

            sb[i - 1].append(sb[i]);

        }

        

        return sb[0].toString();

    }

}



