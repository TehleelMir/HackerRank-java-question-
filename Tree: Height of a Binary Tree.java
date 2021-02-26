/*
The height of a binary tree is the number of edges between the tree's root and its furthest leaf. For example, the following binary tree is of height 
*/

//code 

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
    
	public static int height(Node root) {
      	// Write your code here.
          return helpMe(root) - 1;
    }
    static int helpMe(Node root){
          if(root == null) return 0;
          return Math.max(helpMe(root.left) , helpMe(root.right)) + 1;
    }
