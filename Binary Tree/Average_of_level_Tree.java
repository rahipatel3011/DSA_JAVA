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
 * Initialize an empty list called 'average' to store the average values.
Check if the 'root' of the binary tree is null. If it is, return an empty list since there are no levels to compute averages for.
Initialize a queue for level-order traversal using a LinkedList. Start by adding the 'root' node to the queue.
Enter a loop that continues until the queue is empty, indicating that all levels have been processed.
Inside the loop:
Calculate the size of the current level ('size') by checking the size of the queue. This represents the number of nodes at the current level.

Initialize a 'total' variable to 0.0 to store the sum of node values at the current level.

Iterate through all nodes at the current level:

Dequeue each node from the queue one by one.

Add the value of the current node to the 'sum', accumulating the values of all nodes at the current level.

Enqueue the left and right children of the current node if they exist, effectively moving to the next level.

After processing all nodes at the current level, calculate the average value for that level by dividing the 'sum' by 'levelSize'. This average represents the average value of all nodes at that level.

Add the calculated average to the 'average' list.

Finally, return the 'average' list, which contains the average values of each level in the binary tree.
 */


class Solution {
   
    
    public List<Double> averageOfLevels(TreeNode root) {
        // initialized empty list to store average values of same level
        List<Double> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        // initialized a queue with root to achieve BFS traversal.
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            double total = 0;

            //calculate size of queue for each level to average-out total
            int size = q.size();
            
            // iterate through all element of queue on the same level of the tree.
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                total += curr.val;
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }

            // add average of sum to result list
            result.add(total / size);

        }
        return result;
    }

}