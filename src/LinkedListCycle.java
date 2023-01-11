// 141. Linked List Cycle
//https://leetcode.com/problems/linked-list-cycle/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// Given head, the head of a linked list, determine if the linked list has a cycle in it.
// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously 
//following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
// Return true if there is a cycle in the linked list. Otherwise, return false.

// Example 1:
// Input: head = [3,2,0,-4], pos = 1
// Output: true
// Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

// Example 2:
// Input: head = [1,2], pos = 0
// Output: true
// Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

// Example 3:
// Input: head = [1], pos = -1
// Output: false
// Explanation: There is no cycle in the linked list.
 
// Constraints:
// The number of the nodes in the list is in the range [0, 104].
// -105 <= Node.val <= 105
// pos is -1 or a valid index in the linked-list.

public class LinkedListCycle {
//Logic: 
//make a set of all the nodes traversed, if a node is already present in the set then return true else return false.
//iterative solution:
	/*
		public static boolean hasCycle(ListNode head) {
			Set<ListNode> visited = new HashSet<>();
			while(head != null){
				if(visited.contains(head))
					return true;
				else
				visited.add(head);
				head = head.next;
			}
		return false;
		}
	*/

//O(1) - space solution:
//Logic:
//1. create two pointers fast and slow
//2. Move fast by 2 jumps and slow by 1 jump
//3. if slow and fast pointer meet at some point then there exists a cycle.
//4. for the exit creteria of the loop check both if fast and fast.next are null or not
	public static boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow)
				return true;
		}
		return false;
	}
public static void main(String [] args){

	ListNode lN5 = new ListNode(5,null);
	ListNode lN4 = new ListNode(4, lN5);
	ListNode lN3 = new ListNode(3, lN4);
	ListNode lN2 = new ListNode(2, lN3);
	ListNode lN1 = new ListNode(1, lN2);
	lN5.next = lN3;
	System.out.println("list contains cycle: "+ hasCycle(lN1));
}
}
