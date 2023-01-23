import java.util.*;
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

// 23. Merge k Sorted Lists
//https://leetcode.com/problems/merge-k-sorted-lists/

// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
// Merge all the linked-lists into one sorted linked-list and return it.

// Example 1:
// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted list:
// 1->1->2->3->4->4->5->6

// Example 2:
// Input: lists = []
// Output: []

// Example 3:
// Input: lists = [[]]
// Output: []
 

// Constraints:
// k == lists.length
// 0 <= k <= 104
// 0 <= lists[i].length <= 500
// -104 <= lists[i][j] <= 104
// lists[i] is sorted in ascending order.
// The sum of lists[i].length will not exceed 104.

//Logic:
//1. First find the way to merge two list and write the function for the same
//2. Now implement merge sort like logic to merge 2 lists at a time
//3. Once 2-2 linked lists of the lists of linke lists are merged update the lists of list with merged list
//4. do stem 2 and 3 until there is only one linked list remaining in the lists of list.

public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
        //int k = 0;

		//Improve this logic next time
        List<ListNode> result = new ArrayList<>();
        for(int i=0; i<lists.length; i++){
                if(lists[i] != null){
                    result.add(lists[i]);
                    //System.out.println("i: "+ i + " result: "+ result.toString());
                }
        }
        while(result.size() > 1){
            List<ListNode> mergedLists = new ArrayList<>();
            for (int i=0; i<result.size(); i=i+2){
                //System.out.println("i: "+ i + " result: "+ result.toString());
                if(i + 1 < result.size())
                    mergedLists.add(merge2Lists(result.get(i), result.get(i + 1)));
                else
                    mergedLists.add(merge2Lists(result.get(i),  null));
            }
            //System.out.println("mergedLists: "+ mergedLists.toString());
            result = mergedLists;
            //mergedLists.toArray(lists);
            //System.out.println("lists after: "+ result.toString());
            //k++;
        }
        ListNode res = null;
        if(result.size() == 1)
            res = result.get(0);
        return res;
    }
    public ListNode merge2Lists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null)
            return list1;
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        ListNode dummyNode = new ListNode(-1, null);
        ListNode returnList = dummyNode;
        while(list1 != null && list2 != null)
        {
            if(list1.val  <= list2.val){
                dummyNode.next = list1;
                dummyNode = dummyNode.next;
                list1 = list1.next;
            }
            else{
                dummyNode.next = list2;
                dummyNode = dummyNode.next;
                list2 = list2.next;
            }      
        }
        while(list1 != null){
            dummyNode.next = list1;
            dummyNode = dummyNode.next;
            list1 = list1.next;
        }
        while(list2 != null){
            dummyNode.next = list2;
            dummyNode = dummyNode.next;
            list2 = list2.next;
        }
        return returnList = returnList.next;
    }
}
