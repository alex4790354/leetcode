package com.github.alex4790354.p01ArraysAndStrings.p00Theory;


/**  You are given an integer array nums consisting of n elements, and an integer k.
 Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
 Any answer with a calculation error less than 10-5 will be accepted.

 Input: nums = [1,12,-5,-6,50,3], k = 4
 Output: 12.75000
 Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 **/
public class Task01MaximumAverageSubarray {

    public static void main(String[] args) {
        int[] nums = {-1};
        int k = 1;
        System.out.println(solution(nums, k));
    }

    private static double solution(int[] nums, int k) {
        int summ = 0;

        for (int i = 0; i < k; i++) {
            summ += nums[i];
        }

        int check = summ;
        for (int i = k; i < nums.length; i++) {
            check = check - nums[i - k] + nums[i];
            if (check > summ) {
                summ = check;
            }
        }

        return (double) summ / k;
    }
}
