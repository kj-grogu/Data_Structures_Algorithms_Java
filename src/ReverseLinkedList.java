
//206. Reverse Linked List
// https://leetcode.com/problems/reverse-linked-list/
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
// Given the head of a singly linked list, reverse the list, and return the reversed list.
// Example 1:


// Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]
// Example 2:


// Input: head = [1,2]
// 

public class ReverseLinkedList {
    static ListNode  newHead;
     public static ListNode reverseList(ListNode head) {
         //using Iterations
//         if(head == null)
//             return head;
//         ListNode retNode = null;
//         ListNode trav = null;
//         Stack<ListNode> revstck = new Stack();
        
//         while(head != null){
//             revstck.push(head);
//             head = head.next;
//         }
        
//         while(!revstck.isEmpty())
//         {
//             if(retNode == null)
//             {
//                 retNode = revstck.pop();
//                 trav = retNode;
//             }
//             else
//             {
//                 trav.next = revstck.pop();// insert at end
//                 trav = trav.next; // move end ahead
//             }
//         }
        
//         trav.next = null;
//         return retNode;
//Now using recurssion to solve same problem;
         if(head == null)
             return head;
         ListNode trav = head;
         //ListNode retNode = recTravBackwards(trav);
        return newHead;
     }
    public static ListNode recTravBackwards(ListNode curr){
        if(curr.next == null) {
            newHead = curr;
            return curr;   
        }
        ListNode retNode = recTravBackwards(curr.next);
        retNode.next = curr;
        curr.next = null;
        return curr;
    }
    public static void main(String[] args) {
        ListNode l1ob3 = new ListNode(10,null);
        ListNode l1ob2 = new ListNode(5,l1ob3);
        ListNode l1ob1 = new ListNode(1,l1ob2);

        ListNode list1 = l1ob1;
        ListNode result = reverseList(list1);
        while(result != null){
            System.out.println(result.val + "=>" + result.next);
            result = result.next;
        }
    }
/***************************************************BEST SOLUTIONS***************************************************************

// The idea here is to keep 3 pointers:
//prev ==> to mark the previous node initially null;
//curr ==> to mark the current node which will start pointing to the prev node
//after ==> to preserve the reference to the next node of the current node before it starts pointing to the previous node
//Then keep moving this set one node further every iteration till whole list is traversed 
//Then return the prev node that marks the head of reversed list

/*
    public ListNode reverseList(ListNode head) {
    if(head == null)
        return head;
    ListNode curr = new ListNode();
    ListNode prev = new ListNode();
    curr = head;
    prev = null;
    while(curr != null){
        ListNode after = curr.next;
        curr.next = prev;
        prev = curr;
        curr = after;
    }
    return prev;
    }
*/
//Recurrsively:

/*  
    public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    return revListRec(head, prev);
    }
    public ListNode revListRec(ListNode head, ListNode prev) {
    if(head == null)
    return prev;
    ListNode after = head.next;
    head.next = prev;
    return revListRec(after, head);
    }
*/

}

