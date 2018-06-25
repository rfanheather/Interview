public class PruferCodetoTreeCreation {
    public TreeNode createTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        List<Integer> numbers = Arrays.asList(nums);
        int len = nums.length;
        PriorityQueue<TreeNode> minHeap = new PriorityQueue(len + 2, (a, b) -> a.val - b.val);
        for (int i = 1; i < len + 3; i++) {
            if (!numbers.contains(i)) {
                minHeap.offer(new TreeNode(i));
            }
        }
        
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(numbers.get(i), new TreeNode(numbers.get(i)));
        }
        
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            TreeNode cur = minHeap.poll();
            TreeNode root = map.get(num);
            if (root.left == null) {
                root.left = cur;
            } else {
                root.right = cur;
            }
            
            nums[i] = num * -1;
            if (nums.indexOf(num) == -1) {
                minHeap.offer(root);
            }
        }
        
        TreeNode a = minHeap.poll();
        TreeNode b = minHeap.poll();
        if (a.val == nums[len - 1] {
            if (a.left == null) {
                a.left = b;
            } else {
                a.right = b;
            }
            return a;
        } 
        
        if (b.left == null) {
            b.left = a;
        } else {
            b.right = a;
        }
        return b;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(int v) {
        val = v;
    }
}
