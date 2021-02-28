/*
Given two arrays of integers, find which elements in the second array are missing from the first array.
link : https://www.hackerrank.com/challenges/missing-numbers/problem
*/

// code 

    static int[] missingNumbers(int[] arr, int[] brr) {
        Arrays.sort(arr); 
        Arrays.sort(brr);
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        
        for(int i=0 , j=0 ; i<brr.length ; ){
            if(j >= arr.length){
                set.add(brr[i]);
                i++;
                continue;
            }
            if(brr[i] != arr[j]){
                set.add(brr[i]);
                i++;
            }else{
                i++;
                j++;
            }
        }
        
        int[] result = new int[set.size()];
        int count = 0;
        for(Integer x : set)
            result[count++] = x;
        
        return result;

    }
