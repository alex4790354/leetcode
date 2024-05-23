package com.github.alex4790354.p01ArraysAndStrings.p00Theory;

import java.util.Arrays;

/**
     You are given a 0-indexed array nums of n integers, and an integer k.
     The k-radius average for a subarray of nums centered at some index i with the radius k is the average of all elements in nums between the indices i - k and i + k (inclusive). If there are less than k elements before or after the index i, then the k-radius average is -1.
     Build and return an array avgs of length n where avgs[i] is the k-radius average for the subarray centered at index i.
     The average of x elements is the sum of the x elements divided by x, using integer division. The integer division truncates toward zero, which means losing its fractional part.
     For example, the average of four elements 2, 3, 1, and 5 is (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75, which truncates to 2.
 */
public class Task05KRadiusSubarray {

    public static void main(String[] args) {
        int[] nums = {7,4,3,9,1,8,5,2,6};
        int k = 3;

        for (int num : solution(nums, k))
            System.out.println(num);
    }

    private static int[] solution(int[] nums, int k) {
        int n = nums.length;
        int[] avgs = new int[n];
        Arrays.fill(avgs, -1); // Initialize the result array with -1

        if (n < 2 * k + 1) {
            return avgs; // Not enough elements to form any k-radius subarray
        }

        long windowSum = 0;
        int windowSize = 2 * k + 1;

        // Calculate the sum of the first window
        for (int i = 0; i < windowSize; i++) {
            windowSum += nums[i];
        }

        // Set the k-radius average for the first valid index
        avgs[k] = (int) (windowSum / windowSize);

        // Slide the window through the array
        for (int i = k + 1; i < n - k; i++) {
            windowSum = windowSum - nums[i - k - 1] + nums[i + k];
            avgs[i] = (int) (windowSum / windowSize);
        }

        return avgs;
    }

}
