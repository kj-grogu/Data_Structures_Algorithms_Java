public class SubTree {
	
// 	572. Subtree of Another Tree
//https://leetcode.com/problems/subtree-of-another-tree/

// Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

// A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself. 

// Example 1:
// Input: root = [3,4,5,1,2], subRoot = [4,1,2]
// Output: true
// Example 2:

// Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
// Output: false
 

// Constraints:

// The number of nodes in the root tree is in the range [1, 2000].
// The number of nodes in the subRoot tree is in the range [1, 1000].
// -104 <= root.val <= 104
// -104 <= subRoot.val <= 104

	/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

	//     public boolean isSubtree(TreeNode root, TreeNode subRoot) {
	//      if(root == null && subRoot == null)
	//          return true;
	//     else if(root == null || subRoot == null)
	//         return false;
			
	//         if(root.val != subRoot.val)
	//             return false;
			
	//         if(isSubtree(root.left, subRoot.left) && isSubtree(root.right, subRoot.right))
	//                 return true;
	
	//         return(isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
			
	//     }
		
		public boolean isSubtree(TreeNode root, TreeNode subRoot) {
			if(root == null && subRoot == null)
				return true;
			if(root == null || subRoot == null)
				return false;
			
			if(deeepDive(root, subRoot))
				return true;
			
			return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
		}
		
		private boolean deeepDive(TreeNode root1, TreeNode root2){
			if(root1 == null && root2 == null)
				return true;
			if(root1 == null || root2 == null)
				return false;
			if(root1.val != root2.val)
				return false;
			
			return deeepDive(root1.left, root2.left) && deeepDive(root1.right, root2.right);
		}
}
