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

// 143. Reorder List
//https://leetcode.com/problems/reorder-list/

// You are given the head of a singly linked-list. The list can be represented as:
// L0 → L1 → … → Ln - 1 → Ln
// Reorder the list to be on the following form:
// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// You may not modify the values in the list's nodes. Only nodes themselves may be changed.

// Example 1:
// Input: head = [1,2,3,4]
// Output: [1,4,2,3]

// Example 2:
// Input: head = [1,2,3,4,5]
// Output: [1,5,2,4,3]

// Constraints:
// The number of nodes in the list is in the range [1, 5 * 104].
// 1 <= Node.val <= 1000

//Logic:
//1. divide the given list in 2 halfs
//2. reverse the 2nd half of the list
//3. merge the 2 list in one (each node of 1 list at a time)

public class ReorderList {
    public static ListNode reorderList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        //head of l1:
        ListNode l1 = head;
        //head of l2:
        ListNode slow = head;
        //tail of l2:
        ListNode fast = head;
        //tail of l1:
        ListNode prev = null;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode l2 = reverseList(slow);
        mergeLists(l1,l2);
	
	return head;
    }
    public static ListNode reverseList(ListNode curr){
        ListNode prev = null;
        while(curr != null){
            ListNode after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }
        return prev;
    }
	//Logic: This is the tricky one:
	//1. store the next node of both lists in temp node for future
	//2. point the next of l1 to l2
	//3. check if temp node for l1 is null or not, if null then break the loop 
	//4. move ahead and point the next of l2 to temp of l1
	//5. replace l1 and l2 with there temps
	//6. put all the the above logic in while(l1 != null)

    public static void mergeLists(ListNode l1, ListNode l2){
        while(l1 != null){
            ListNode temp1 = l1.next;
            ListNode temp2 = l2.next;
           
            l1.next = l2;
            if(temp1 == null)
                break;
            
            l2.next = temp1;
            l1 = temp1;
            l2 = temp2;
        }
    }
	public static void main(String [] args){
		
		ListNode l1ob5 = new ListNode(5,null);
		ListNode l1ob4 = new ListNode(4,l1ob5);
		ListNode l1ob3 = new ListNode(3,l1ob4);
        ListNode l1ob2 = new ListNode(2,l1ob3);
        ListNode l1ob1 = new ListNode(1,l1ob2);

        ListNode list1 = l1ob1;
        ListNode result = reorderList(list1);
        while(result != null){
            System.out.println(result.val + "=>" + result.next);
            result = result.next;
        }
	}
}
