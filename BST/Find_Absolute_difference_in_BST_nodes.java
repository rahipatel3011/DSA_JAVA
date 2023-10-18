/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


/**
    to solve this problem,
    1 Property of BST is if we search thorugh tree in INORDER way then we get root in sorted way.
    - first go to left-side node 
    - store that node in Prev variable and if prev is not null then find min between prevMin and difference between current node and prev node
    - then go to right node
 */



class BST {
    TreeNode prev = null;
    int ans = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        
        solve(root, ans);
        return ans;
    }

    public void solve(TreeNode root, int answ){
        if(root.left != null){
            solve(root.left, ans);
        }
        
        if(prev != null){
            ans = Math.min(ans, Math.abs(prev.val - root.val));
        }
        prev = root;
        if(root.right != null){
            solve(root.right, ans);
        }
        
    }
}