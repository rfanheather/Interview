// https://www.geeksforgeeks.org/dynamic-programming-set-27-max-sum-rectangle-in-a-2d-matrix/

class Solution {
    public int maxSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] temp = new int[n];
        int max = Integer.MIN_VALUE;
        int left = -1; 
        int right = -1;
        int top = -1;
        int bottom = -1;
        
        for (int l = 0; l < n; l++) {
            for (int r = l; r < n; r++) {
                for (int i = 0; i < n; i++) {
                    temp[i] += matrix[i][r];
                }
                
                int[] rst = Kadane(temp);
                if (rst[0] > max) {
                    max = rst[0];
                    left = l;
                    right = r;
                    top = rst[1];
                    bottom = rst[2];
                }
            }
        }
        
        return max;
    }
    
    private int[] Kadane(int[] nums) {
        int start = 0;
        int sum = 0;
        int len = nums.length;
        int[] rst = new int[3];
        rst[0] = Integer.MIN_VALUE;
        rst[1] = -1;
        
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            } else if (sum > rst[0]) {
                rst[0] = sum;
                rst[1] = start;
                rst[2] = i;
            }
        }
        
        if (rst[1] == -1) {
            for (int i = 0; i < len; i++) {
                if (nums[i] > rst[0]) {
                    rst[0] = nums[i];
                    rst[1] = i;
                    rst[2] = i;
                }
            }
        }
        
        return rst;
    }
}
