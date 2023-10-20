/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode pointer = head;
        int length = 0;

        //Calculating length
        while(pointer != null){
            length++;
            pointer = pointer.next;
        }
        if(length != 0){
            k = k%length; // evalute it while length is not 0 otherwise it will give infinity. 
        }
        
        
        //head will become same if  parameter's value are 0 and 1.
        if( length==0 || length==1 || k==0 || k == length){
            return head;
        }

        int diff = length - k;
        ListNode prevNode = head;
        while(diff > 1){
            diff--;
            prevNode = prevNode.next;
        }

        ListNode newHead = prevNode.next; // get new LinkedList with new Head after skiping k elements
    ListNode newPointer = prevNode.next; // need this pointer to travel at the end of new Linked list so we can join it.
        prevNode.next = null; // seprating LinkedList

        
        while(newPointer.next != null){
            newPointer = newPointer.next;
        }

        //now newPointer is on last element and actual head is seprated on Line 38. so we can join it after newHead
        newPointer.next = head;

        return newHead;

    }
}