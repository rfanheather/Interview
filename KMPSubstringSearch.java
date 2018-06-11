/**
 * Date 06/11/2018
 * @author Heather Fan
 * 
 * Do pattern matching using KMP algorithm
 * 
 * Runtime complexity - O(m + n) where m is length of text and n is length of pattern
 * Space complexity - O(n)
 *
 * https://www.youtube.com/watch?v=GTJr8OvyEVQ
 */

public class Solution {
    public int[] hasSubstring(char[] text, char[] pattern) {
        int[] rst = new int[2];
        if (text == null || text.length == 0 || pattern == null || pattern.length == 0) {
            return rst;
        }
        
        int[] temp = buildTempArray(pattern);
        rst = KMPsearch(text, pattern, temp);
        return rst;
    }
    
    private int[] buildTempArray(char[] pattern) {
        int j = 0;
        int i = 0;
        int len = pattern.length;
        int[] temp = new int[len];
        temp[0] = 0;
        
        for(i = 1; i < len; i++) {
            char c = pattern[i];
            if (c == pattern[j]) {
                temp[i] = j + 1;
                j++;
                continue;
            } 
            
            while (j != 0) {
                j = temp[j - 1];
                if (c == pattern[j]) {
                    temp[i] = j + 1;
                    j++;
                    break;
                }
            }
            
            if (j == 0) {
                temp[i] = 0;
            }
        } // end of for
        
        return temp;
    }
    
    private int[] KMPsearch(char[] text, char[] pattern, int[] temp) {
        int[] rst = new int[2];
        int i = 0;
        int j = 0; // index in pattern
        int pLen = pattern.length;
        int tLen = text.length;
        for (i = 0; i < tLen; i++) {
            if (j == pLen) {
                rst[0] = i - pLen;
                rst[1] = i - 1;
                return rst;
            }
            
            if (text[i] != pattern[j]) {
            	    if (j != 0) {
            	    	    j = temp[j - 1];
            	    	    	i--;
            	    }
            } else {
            	    j++;
            }
        }
        
        if (j == pLen) {
          	rst[0] = tLen - pLen;
            rst[1] = tLen - 1;
        }
        
        return rst;
    }
    
    public static void main(String[] args) {
        Solution kmp = new Solution();
        String text = "abcxabcdabcdabcy";
        String pattern = "abcdabcy";
        int[] rst = kmp.hasSubstring(text.toCharArray(), pattern.toCharArray());
        for (int i : rst) {
        	    System.out.println(i);
        }
    }
}
