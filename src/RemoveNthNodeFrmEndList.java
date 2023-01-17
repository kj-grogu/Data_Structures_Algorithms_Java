public class RemoveNthNodeFrmEndList {
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// 19. Remove Nth Node From End of List
// Given the head of a linked list, remove the nth node from the end of the list and return its head.

// Example 1:
// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]

// Example 2:
// Input: head = [1], n = 1
// Output: []

// Example 3:
// Input: head = [1,2], n = 1
// Output: [1]

// Constraints:
// The number of nodes in the list is sz.
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
 
// Follow up: Could you do this in one pass?

/*
 * Logic:
 * 1. get the length of the list first
 * 2. move through the list node by node from start if the index of the node becomes same as length - n
 * 3. keep a previous node and update the next of this node with the current node's next and break
 * 4. Else keep moving ahead by updating the previous node with the current node and current node with the next of current.
 */
public static ListNode removeNthFromEnd(ListNode head, int n) {
	if(head == null)
		return head;
	ListNode curr = head;
	int i=0;
	while(curr != null){
		curr = curr.next;
		i++;
	}
	//System.out.println("i: " + i);
	curr = head;
	ListNode prev = new ListNode();
	prev.next = curr;
	head = prev;
	int j = 0;
	while(curr != null){
		//System.out.println("curr: " + curr.val + " prev: "+ prev.val);
		if(j == i - n){
			prev.next = curr.next;
			break;
		}else{
			prev = curr;
			curr = curr.next;
		}
		j++;
	//System.out.println("currAfter: " + curr.val + " prevAfter: "+ prev.val);
	}
	return head = head.next;
}
public static void main(String [] args){

		ListNode l1ob5 = new ListNode(5,null);
		ListNode l1ob4 = new ListNode(4,l1ob5);
		ListNode l1ob3 = new ListNode(3,l1ob4);
        ListNode l1ob2 = new ListNode(2,l1ob3);
        ListNode l1ob1 = new ListNode(1,l1ob2);
		int n = 2;
		ListNode resultList = removeNthFromEnd(l1ob1, n);
        while(resultList != null){
            System.out.print(resultList.val + "=>");
            resultList = resultList.next;
        }          
	}
}
