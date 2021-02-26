/*
A left rotation operation on an array of size n
shifts each of the array's elements 1
unit to the left. Given an integer, d , rotate the array that many steps left and return the result.
*/

//code 

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
    // Write your code here
        LinkedList<Integer> list = new LinkedList<>(arr);
        
        for(int i=0 ; i<d ; i++)
            list.add( list.removeFirst() );
        
        return list;
    }
