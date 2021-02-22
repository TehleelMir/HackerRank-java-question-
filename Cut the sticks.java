/*You are given a number of sticks of varying lengths. You will iteratively cut the sticks into smaller sticks, 
discarding the shortest pieces until there are none left. At each iteration you will determine the length of the shortest stick remaining,
cut that length from each of the longer sticks and then discard all the pieces of that shortest length. When all the remaining sticks are the same length, 
they cannot be shortened so discard them.

Given the lengths of n sticks, print the number of sticks that are left before each iteration until there are none left.*/

//code 

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        
        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();
        for(int x : arr) list.add(x);
        
        result.add(list.size());
        while(list.size() > 1 ){
            int temp = list.get(0);
            
            for(int i=0 ; i<list.size() ; i++){
                list.set(i , (list.get(i)-temp) ); 
                if(list.get(i) == 0) list.remove(i--);
            }
            if(list.size() != 0) result.add(list.size());
        }
        int result2[] = new int[result.size()];
        for(int i=0 ; i<result.size() ; i++) result2[i]=result.get(i);
        return result2;
    }
