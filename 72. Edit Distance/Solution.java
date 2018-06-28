//72. Edit Distance

public class Solution {
    public int minDistance(String word1, String word2) {
        //边界条件
        if(word1.length() == 0)
    		return word2.length();
    	if(word2.length() == 0)
    		return word1.length();
        /*
         * 本题用动态规划的解法
         * f[i][j]表示word1的前i个单词到word2前j个单词的最短距离
         * 状态转移方程：f[i][j] = 
         */
        
        int[][] f = new int[word1.length()][word2.length()];
        boolean isEquals = false;//是否已经有相等
        for(int i = 0 ; i < word2.length(); i++){
            //如果相等，则距离不增加
            if(word1.charAt(0) == word2.charAt(i) && !isEquals){
                f[0][i] = i > 0 ? f[0][i-1]:0;//不能从0开始
                isEquals = true;
            }else{
                f[0][i] = i > 0 ? f[0][i-1]+1:1;
            }
        }
        isEquals = false;//是否已经有相等
        for(int i = 1 ; i < word1.length(); i++){
            //如果相等，则距离不增加
            if(word1.charAt(i) == word2.charAt(0) && !isEquals){
                f[i][0] =  f[i-1][0];//不能从0开始
                isEquals = true;
            }else{
                f[i][0] = f[i-1][0]+1;
            }
        }
        
        for(int i = 1; i < word1.length();i++){
            for(int j = 1; j < word2.length(); j++){
                if(word1.charAt(i) == word2.charAt(j)){
                    f[i][j] = f[i-1][j-1];//相等的话直接相等
                }else{
                    f[i][j] = f[i-1][j-1]+1;
                }
                //然后与从f[i-1][j]+1，f[i][j-1]+1比较，取最小值
                f[i][j] = Math.min(f[i][j],Math.min(f[i-1][j]+1,f[i][j-1]+1));
            }
        }
        return f[word1.length()-1][word2.length()-1];
    }
}

