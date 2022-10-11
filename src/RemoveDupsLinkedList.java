public class RemoveDupsLinkedList {
// 	83. Remove Duplicates from Sorted List
//https://leetcode.com/problems/remove-duplicates-from-sorted-list/
// Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

// Example 1:
// Input: head = [1,1,2]
// Output: [1,2]
// Example 2:


// Input: head = [1,1,2,3,3]
// Output: [1,2,3]
 
// Constraints:

// The number of nodes in the list is in the range [0, 300].
// -100 <= Node.val <= 100
// The list is guaranteed to be sorted in ascending order.
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
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        ListNode newNode = head;
        ListNode curr = head;
       while(head != null){
           if(head.next != null && head.val == head.next.val)
           {
               head = head.next;
           }else{
               curr.next = head.next; // here the next of previous distinct element from before is modified
               head = head.next; 
               curr = curr.next; // here the current is modified to point to new distinct element
           }
            
       } 
        return newNode;
    }
public static void main(String [] args){
	ListNode node5 = new ListNode(3);
	ListNode node4 = new ListNode(3, node5);
	ListNode node3 = new ListNode(2, node4);
	ListNode node2 = new ListNode(1, node3);
	ListNode node1 = new ListNode(1, node2);
	ListNode noDupList = deleteDuplicates(node1);
	while(noDupList != null){
		System.out.println("Node val: "+ noDupList.val+ " Node nextAdd: "+ noDupList.next);
		noDupList = noDupList.next;
	}
	
}
}
