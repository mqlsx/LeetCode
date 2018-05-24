// 344. Reverse String

class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}

class Solution {
    public String reverseString(String s) {
        char[] tmp = s.toCharArray(); 
        for(int i = 0; i < tmp.length / 2; i++){
            char t = tmp[i];
            tmp[i] = tmp[tmp.length - 1 - i];
            tmp[tmp.length - 1 - i] = t;
        }        
        return String.valueOf(tmp);
    }
}
