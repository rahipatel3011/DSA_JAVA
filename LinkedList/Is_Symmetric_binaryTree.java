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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // initially check if root is null or root is the only element in tree then return true
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        return check(root.left, root.right);

    }
    public boolean check(TreeNode left, TreeNode right){

        /**
        - if both node exist then compare both's value and
        - left node's right tree and right node's left tree should be equal
         */
        if(left != null && right != null){
            return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
        }

        //if both nodes are not equal then check if both are null then it will return true
        // if both node are other then null then return false.
        return left == right;
    }
}