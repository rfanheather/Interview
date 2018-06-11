/**
 * Date 06/11/2018
 * @author Rong
 * 
 * Do pattern matching using KMP algorithm
 * 
 * Runtime complexity - O(m + n) where m is length of text and n is length of pattern
 * Space complexity - O(n)
 *
 * https://www.youtube.com/watch?v=GTJr8OvyEVQ
 */

public class KMPSubstringSearch {
    public int[] hasSubstring(char[] text, char[] pattern) {
        Lint[] rst = new int[2];
        if (text == null || text.length == 0 || pattern == null || pattern.length == 0) {
            return rst;
        }
        
        int[] temp = buildTempArray(pattern);
        rst = KMPsearch(text, pattern, temp);
        return rst;
    }
    
    private int[] buildTempArray(char[] pattern) {
        
    }
}
