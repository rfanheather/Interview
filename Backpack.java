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
        
    }
}
