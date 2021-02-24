/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Follow up: Could you write an algorithm with O(log n) runtime complexity?

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]

link : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
*/

//code 

class Solution {
    public int[] searchRange(int[] nums, int target) {
     if(nums.length < 0) return new int[] {-1,-1};
     int[] arr = {-1 , -1};
     boolean flag = false , flag2 = false;
        
     for(int i=0 , j=(nums.length)-1 ; i<nums.length ; i++ , j--){
         if(nums[i] == target && !flag){
             arr[0] = i;
             flag = true;
             if(flag && flag2) break;
         }
         if(nums[j] == target && !flag2){ 
             arr[1] = j;
             flag2 = true;
             if(flag && flag2) break;
         } 
     }
        return arr;
    }
} 
