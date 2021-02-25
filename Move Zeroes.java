/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

class Solution {
    int count = 0;
    public void moveZeroes(int[] nums) {
        if(nums.length <= 1) return;
        for(int i=0 ; i<nums.length ; i++)
            if(nums[i] == 0){
                delete(nums , i--);
            }
        
        for(int i=nums.length-1 ; count!=0 ; count-- , i--)
            nums[i]=0;
        
    }
    //method to delete an element in an array with index ,, also adding -1 to the last on each delete
    void delete(int[] nums , int index){
        for(int i=index ; i<nums.length-1 ; i++)
            nums[i] = nums[i+1];
        nums[nums.length-1]=-1;
        count++;
    }
}
