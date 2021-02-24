/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
Example 4:

Input: nums = [1,3,5,6], target = 0
Output: 0
Example 5:

Input: nums = [1], target = 0
Output: 0
*/
//link : https://leetcode.com/problems/search-insert-position/
//code 

class Solution {
    public int searchInsert(int[] nums, int target) {
        int low=0 , high=nums.length-1 , index = -1;
        
        while(low <= high){
            int mid = (low+high) / 2;
            if(nums[mid] == target){ 
                return mid; 
            }
            
            if(nums[mid] < target) low = mid+1;
            if(nums[mid] > target) high = mid-1;
            index = mid;
        }
        if(nums[index] > target) return index;
        if(nums[index] < target) return index+1;
        return index;
    }
}
