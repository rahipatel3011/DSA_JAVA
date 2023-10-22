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
    approach to solve problem
    - find complement of current node.
    - check root val is in hashmap or not. if it's there it means root's complement already seen before in tree.
    - if not in hashmap then store it in HashMap to check in future.
    - check in left or right sub tree.

 */


class Solution {
    HashMap<Integer, Boolean> map = new HashMap<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }
        int complement = k - root.val;
        if(map.containsKey(root.val)){
            return true;
        }
        map.put(complement, true);
        
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}