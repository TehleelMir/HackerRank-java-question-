/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
*/

// link : https://leetcode.com/problems/validate-binary-search-tree/

// code

class Solution {
    Integer hold=null;
    boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        
        isValidBST(root.left);
        if(hold == null) hold = root.val;
        else if(hold >= root.val){
            flag = false;
        }
        else
            hold = root.val;
        isValidBST(root.right);
        // System.out.print(flag);
        return flag;
        }
    
}
