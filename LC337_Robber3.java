class Solution {
    
    // 1. Naive Solution
    // recursion
    public int robNaive(TreeNode root) {
        // termination
        if (root == null) {
            return 0;
        }
        
        int sum = 0;
        if (root.left != null) {
            sum += robNaive(root.left.left) + robNaive(root.left.right);
        }
        if (root.right != null) {
            sum += robNaive(root.right.left) + robNaive(root.right.right);
        }
        
        return Math.max(root.val + sum, robNaive(root.left) + robNaive(root.right));
    }
    
    
    // 2. recursion + memo
    public int robRecursionMemo(TreeNode root) {
        Map<TreeNode, Integer> memo = new HashMap<>();
        return dfs(root, memo);
    }
    
    private int dfs(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null) {
            return 0;
        }
        
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        
        int sum = 0;
        if (root.left != null) {
            sum += dfs(root.left.left) + dfs(root.left.right);
        }
        if (root.right != null) {
            sum += dfs(root.right.left) + dfs(root.right.right);
        }
        
        int rst = Math.max(root.val + sum, dfs(root.left) + dfs(root.right));
        memo.put(root, rst);
        
        return rst;
    }
    
    // 3.greedy
    // use int[] val to record sum as each node, val[0] means node not chosen, val[1] means chosen
    public int robGreedy(TreeNode root) {
        int[] rst = greedy(root);
        return Math.max(rst[0], rst[1]);
    }
    
    private int[] greedy(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        
        int[] rst = new int[2];
        int[] left = greedy(root.left);
        int[] right = greedy(root.right);
        
        rst[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // not chosen root
        rst[1] = root.val + left[0] + right[0]; // chosen root
        
        return rst;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
