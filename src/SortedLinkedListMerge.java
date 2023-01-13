
   public class SortedLinkedListMerge {
//     21. Merge Two Sorted Lists
//https://leetcode.com/problems/merge-two-sorted-lists/
// Easy

// 14987

// 1320

// Add to List

// Share
// You are given the heads of two sorted linked lists list1 and list2.

// Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

// Return the head of the merged linked list.

 

// Example 1:


// Input: list1 = [1,2,4], list2 = [1,3,4]
// Output: [1,1,2,3,4,4]
// Example 2:

// Input: list1 = [], list2 = []
// Output: []
// Example 3:

// Input: list1 = [], list2 = [0]
// Output: [0]
 

// Constraints:

// The number of nodes in both lists is in the range [0, 50].
// -100 <= Node.val <= 100
// Both list1 and list2 are sorted in non-decreasing order.
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
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        
        ListNode head = null; 
        ListNode trav = null;
        
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                if(head == null){
                  head = list1;
                  trav = list1;
                  list1 = list1.next;
                }else{
                    trav.next = list1;
                    trav = trav.next;
                    list1 = list1.next;
                }
            }else{
                    if(head == null){
                      head = list2;
                      trav = list2;
                      list2 = list2.next;
                    }else{
                        trav.next = list2;
                        trav = trav.next;
                        list2 = list2.next;
                    }
            }
                
        }
        if(list1 == null)
            trav.next = list2;
        if(list2 == null)
            trav.next = list1;
        
    return head;
    }
    //Another way:
    // public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    //     if(list1 == null && list2 == null)
    //         return list1;
    //     if(list1 == null) 
    //         return  list2;
    //     if(list2 == null)
    //         return list1;
        
    //     //ListNode curr1 = list1;
    //     //ListNode curr2 = list2;
    //     ListNode temp = new ListNode(-1, null);
    //     ListNode output = temp;
    //     while(list1 != null &&  list2 != null){
    //         if(list1.val <= list2.val){
    //             temp.next = list1;
    //             temp = temp.next;
    //             list1 = list1.next;
    //         }
    //         else{
    //             temp.next = list2;
    //             temp = temp.next;
    //             list2 = list2.next;
    //         }
    //     }
    //     while(list1 != null){
    //         temp.next = list1;
    //         temp = temp.next;
    //         list1 = list1.next;
    //     }
    //     while(list2 != null){
    //         temp.next = list2;
    //         temp = temp.next;
    //         list2 = list2.next;
    //     }
    // return output = output.next;
    // }
    public static void main(String[] args) {
        

        ListNode l1ob3 = new ListNode(10,null);
        ListNode l1ob2 = new ListNode(5,l1ob3);
        ListNode l1ob1 = new ListNode(1,l1ob2);

        ListNode l2ob3 = new ListNode(100,null);
        ListNode l2ob2 = new ListNode(8,l2ob3);
        ListNode l2ob1 = new ListNode(2,l2ob2);

        ListNode list1 = l1ob1;
        ListNode list2 = l2ob1;
        ListNode result = mergeTwoLists(list1, list2);
        while(result != null){
            System.out.println(result.val + "=>" + result.next);
            result = result.next;
        }
        
    }
}
