
// 1836. Remove Duplicates From an Unsorted Linked List
//https://leetcode.com/problems/remove-duplicates-from-an-unsorted-linked-list/

// Given the head of a linked list, 
//find all the values that appear more than once in the list and delete the nodes that have any of those values.
// Return the linked list after the deletions.

// Example 1:
// Input: head = [1,2,3,2]
// Output: [1,3]
// Explanation: 2 appears twice in the linked list, so all 2's should be deleted. After deleting all 2's, we are left with [1,3].

// Example 2:
// Input: head = [2,1,1,2]
// Output: []
// Explanation: 2 and 1 both appear twice. All the elements should be deleted.

// Example 3:
// Input: head = [3,2,2,1,3,2,4]
// Output: [1,4]
// Explanation: 3 appears twice and 2 appears three times. After deleting all 3's and 2's, we are left with [1,4].
 
// Constraints:
// The number of nodes in the list is in the range [1, 105]
// 1 <= Node.val <= 105

import java.util.*;
public class RmvDupsFrmUnsortedLinkedList {
	public static ListNode deleteDuplicatesUnsorted(ListNode head) {
        //Solution to a different problem i-e keeping all distinct values in linkedlist:
        // Set<Integer> distinct = new HashSet<>();
        // ListNode curr = head;
        // ListNode prev = null;

        // while(curr != null){
        //     if(distinct.contains(curr.val)){
        //         prev.next = curr.next;
        //         curr = curr.next;
        //     }
        //     else{
        //         distinct.add(curr.val);
        //         prev = curr;
        //         curr = curr.next;
        //     }
        // }
        // return head;

        Map<Integer,Integer> valCount = new HashMap<>();
        ListNode curr = head;
        while(curr != null){
            if(valCount.containsKey(curr.val)){
                valCount.put(curr.val, valCount.get(curr.val) + 1);
                curr = curr.next;
            }
            else{
                valCount.put(curr.val, 1);
                curr = curr.next;
            }
        }
        curr = head;
        ListNode prev = new ListNode(0);;
        while(curr != null){
            if(valCount.get(curr.val) > 1){
                if(curr == head){
                    curr = curr.next;
                    head = curr;
                }
                else{
                    prev.next = curr.next;
                    curr = curr.next;
                }    
            }
            else
            {
                prev = curr;
                curr = curr.next;
            }
        }
    return head;
    }
public static void main(String [] args){
	
	ListNode lN4 = new ListNode(2, null);
	ListNode lN3 = new ListNode(1, lN4);
	ListNode lN2 = new ListNode(1, lN3);
	ListNode lN1 = new ListNode(2, lN2);
	System.out.println("list after dups deletion: "+ deleteDuplicatesUnsorted(lN1));
}
}
