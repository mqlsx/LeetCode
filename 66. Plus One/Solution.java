//66. Plus One

public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
    	//一般情况
        for (int i = n - 1; i >= 0; i--){
            if (digits[i] < 9){
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
	    //下面部分用于处理数组中的元素全是9的情况，如9999--》10000
	    //初始化数组时，数组中元素均初始化为0，故只需要将数组中第一个元素置位1即可。
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }
}
