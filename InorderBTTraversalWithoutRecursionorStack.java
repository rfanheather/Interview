// 给一个二叉树，每个node有一个指向其父节点的指针，不可以修改树，求该树所有叶子节点的和，要求o1空间
public class InorderBTTraversalWithoutRecursionorStack {
    public int getLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int sum = 0;
        TreeNode cur = root;
        boolean leftMost = false;
        while (cur != null) {
            if (!leftMost) {
                // get leftmost leaf
                cur = getLeftMost(cur);
                leftMost = true;
            }
            
            // if right exist, go to right 
            if (cur.right != null) {
                leftMost = false;
                cur = cur.right;
            } else { // go to parent
                sum += cur.val;
                if (cur.parent != null) {
                    while (cur.parent != null && cur == cur.parent.right) { // if cur is right child, keep going up
                        cur = cur.parent;
                    }
                    if (cur.parent == null) {
                        break;
                    }
                    // cur is the left child of its parent now
                    cur = cur.parent;
                } else {
                    break;
                }
            } // end of if
        } // end of while
        
        return sum;
    }
    
    private TreeNode getLeftMost(TreeNode cur) {
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }
}

class TreeNode {
    int val;
    TreeNode left, right, parent;
}
