/* Given a pointer to the root of a binary tree, you need to print the level order traversal of this tree. 
In level-order traversal, nodes are visited level by level from left to right. Complete the function level order
and print the values in a single line separated by a space.

For example:

     1
      \
       2
        \
         5
        /  \
       3    6
        \
         4  
         
For the above tree, the level order traversal is  1 2 5 3 6 4 */

//link : https://www.hackerrank.com/challenges/tree-level-order-traversal/problem

//code 

	public static void levelOrder(Node root) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            Node top = q.poll();
            System.out.print(top.data+" ");
            if(top.left != null) q.add(top.left);
            if(top.right != null) q.add(top.right);
        }
    }
