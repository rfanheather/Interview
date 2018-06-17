// 给一个double的数组，其中每个数字代表一个硬币是正面的概率，求给定K 个正面的概率是多少。

// solution1: recursion find all combinations of k, compute each probability then add
public class KHeadCoin {
    public double findKHead(double[] P, int k) {
        if (P == null || P.length < k) {
            return 0;
        }
        
        double p = 1;
        // probability of chosen none
        for (double d : P) {
            p *= 1 - d;
        }
        
        double rst = 0;
        dfs(P, 0, k, p, rst);
        return rst;
    }
    
    private void dfs(double[] P, int start, int k, double p, double rst) {
        if (k == 0) {
            rst += p;
            return;
        }
        
        int end = P.length;
        while (start < end) {
            p *= P[start] / 1 - P[start]; // pick start
            dfs(P, start + 1, k - 1, p, rst);
            p *= (1 - P[start]) / P[start];
            start++;
        }
    }
}

// solution 2
// dynamic programming
// dp[n][k] represents the probability of K heads after approching n
// dp[n][k] = dp[n-1][k-1] * P[n] + dp[n-1][k] * (1 - P[n])
class Solution2 {
    public double findKHead(double[] P, int k) {
        if (P == null || P.length < k) {
            return 0;
        }
        
        int N = P.length;
        double[][] dp = new double[N][k + 1];
        
        dp[0][0] = 1 - P[0];
        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i - 1][0] * (1 - P[i]);
        }
        
        dp[0][1] = P[0];
        for (int i = 2; i <= k; i++) {
            dp[0][i] = 0;
        }
        
        for (int j = 1; j <= k; j++) {
            for (int i = 1; i < N; i++) {
                dp[i][j] = dp[i - 1][j] * (1 - P[i]) + dp[i - 1][j - 1] * P[i];
            }
        }
        
        return dp[N - 1][k];
    }
}
