/*
You have three stacks of cylinders where each cylinder has the same diameter, 
but they may vary in height. You can change the height of a stack by removing and discarding its topmost cylinder any number of times.

Find the maximum possible height of the stacks such that all of the stacks are exactly the same height. 
This means you must remove zero or more cylinders from the top of zero or more of the three stacks until they are all the same height, then return the height.
*/

//code

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        int size = Math.max(h1.size() , h2.size());
        size = Math.max(size , h3.size());
        
        int sum[] = sum(h1 , h2 , h3);
        
        for(int i=0 ; i<size ; i++){
            
            if(sum[0] == sum[1] && sum[0] == sum[2]) return sum[0];
            
            int min = Math.min(sum[0] , sum[1]);
            min = Math.min(min , sum[2]);
            
            if(!h1.isEmpty() && sum[0] != min)  
                    sum[0] -= h1.remove(0);
            
            if(!h2.isEmpty() && sum[1] != min)
                    sum[1] -= h2.remove(0);
            
            if(!h3.isEmpty() && sum[2] != min)
                    sum[2] -= h3.remove(0);

            if(h1.isEmpty() || h2.isEmpty() || h3.isEmpty()) return 0;
        }//brace of for loop
        return sum[0];
    }
    static int[] sum(List<Integer> list1 , List<Integer> list2 , List<Integer> list3){
        int size = Math.max(list1.size() , list2.size());
        size = Math.max(size , list3.size());

        int sum[] = new int[3];
        for(int i=0 ; i<size ; i++){
            if(i < list1.size()){
             sum[0] += list1.get(i);   
            }
            if(i < list2.size()){
                sum[1] += list2.get(i);
            }
            if(i < list3.size()){
                sum[2] += list3.get(i);
            }
        }
        
        return sum;
    }
