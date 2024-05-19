package com.github.alex4790354.p01ArraysAndStrings.p00;

import java.util.Arrays;

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
