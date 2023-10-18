/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


/**
 * Notes:
 * first we find length of both linked list
 * iterate either of one linkedlist till both linkedList's head on the same length
 * then iterate both LinkedList at the same time and compare node
 * return common Node for both 
 * or return headA which will become null if doesn't have common node.
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA=0;
        int lengthB=0;
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        while(pointerA != null){
            lengthA++;
            pointerA = pointerA.next;
        }
        while(pointerB != null){
            lengthB++;
            pointerB = pointerB.next;
        }

        while(lengthA > lengthB){
            lengthA--;
            headA = headA.next;
        }

        while(lengthB > lengthA){
            lengthB--;
            headB = headB.next;
        }

        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}