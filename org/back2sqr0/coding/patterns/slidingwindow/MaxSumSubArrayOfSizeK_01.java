package org.back2sqr0.coding.patterns.slidingwindow;

/*
  Problem Statement: Given an array of positive numbers and a positive number ‘k,’
  find the maximum sum of any contiguous subarray of size ‘k’.

Example 1:
Input: [2, 1, 5, 1, 3, 2], k=3
Output: 9
Explanation: Subarray with maximum sum is [5, 1, 3].

Example 2:
Input: [2, 3, 4, 1, 5], k=2
Output: 7
Explanation: Subarray with maximum sum is [3, 4].

Time Complexity: The time complexity of the above algorithm will be O(N).
Space Complexity: The algorithm runs in constant space O(1).

 */

public class MaxSumSubArrayOfSizeK_01 {

    public static int findMaxSumSubArray(int k, int[] arr){
    int maxSum = 0, windowSum =0;
    int windowStart = 0;
    for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
        windowSum += arr[windowEnd]; // add the next element

        // slide the window, we don't need to slide if we've not hit the required window size of 'k'
        if(windowEnd >= k-1){

            if(windowSum > maxSum){
                maxSum = windowSum;
            }

            windowSum -= arr[windowStart]; // subtract the element going out
            windowStart++; // slide the window ahead

        }
    }

    return  maxSum;

    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK_01.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK_01.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }
}
