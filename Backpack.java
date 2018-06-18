// 本题来自九章算法
public class Backpack {
    
    // 在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        if (m <= 0 || A == null || A.length == 0) {
            return m;
        }
        
        int[] bp = new int[m + 1];
        int len = A.length;
        for (int i = 0; i < len; i++) {
            for (int j = m; j >= A[i]; j--) {
                bp[j] = Math.max(bp[j], bp[j - A[i]] + A[i]);
            }
        }
        
        return bp[m];
    }
    
    // 给出n个物品的体积A[i]和其价值V[i]，将他们装入一个大小为m的背包，最多能装入的总价值有多大？
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        if (m <= 0 || A == null || A.length == 0 || V == null || V.length == 0) {
            return 0;
        }
        
        int[] f = new int[m + 1];
        int len = A.length;
        for (int i = 0; i < len; i++) {
            for (int j = m; j >= A[i]; j--) {
                f[j] = Math.max(f[j], f[j - A[i]] + V[i]);
            }
        }
        
        return f[m];
    }
    
    // 给定n种具有大小 Ai 和价值 Vi 的物品(每个物品可以取用无限次)和一个大小为 m 的一个背包, 你可以放入背包里的最大价值是多少?
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackIII(int m, int[] A, int V[]) {
        if (m <= 0 || A == null || A.length == 0 || V == null || V.length == 0) {
            return 0;
        }
        
        int[] f = new int[m];
        int len = A.length;
        
        for (int i = 1; i <= m; i++) { // i is weight
            for (int j = 0; j < n; j++) {
                if (A[j] > i) {
                    break;
                }
                f[i] = Math.max(f[i], f[i - A[j]] + V[j]);
            }
        } 
        
        return f[m];
    }
}
