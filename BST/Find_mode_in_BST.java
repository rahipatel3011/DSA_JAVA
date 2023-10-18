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
 * to solve this problem,
 * BST inOrder travel gives us root node in sorted way. so we can store prev node and compare current node with prev node.
 * if prev node match with current node then increse counter of currMax
 * if prev node doesn't match then just reset currMax with 1;
 * 
 * after that check if currMax is greater than maxOcc(overall max) then set maxOcc with currMax and erase list as we have higher occurance.
 * store element incase of their is 2 max occurance or while reset List.
 * 
 * 
 * store current node as PrevNode and go to right node
 */

class Solution {
    ArrayList<Integer> arr = new ArrayList<>();
    int maxOcc = 0;
    int currMax =1;
    TreeNode prev = null;
    public int[] findMode(TreeNode root) {
        solve(root);
        return arr.stream().mapToInt(i -> i).toArray();
    }

    public void solve(TreeNode root){
        solve(root.left);
        if(prev != null){
            if(root.val == prev.val){currMax++;}
            else{currMax=1;}
            
        }
        if(currMax > maxOcc){maxOcc = currMax; arr.clear();}
        if(currMax == maxOcc){arr.add(root.val);}
        prev = root;
        solve(root.right);
        
    }
}