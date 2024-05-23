package com.github.alex4790354.p01ArraysAndStrings.p01;


/**
     Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
     Example 1:     Input: nums = [10,5,2,6], k = 100     Output: 8
     Explanation: The 8 subarrays that have product less than 100 are:
     [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
     Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 */
public class T713SubarrayProductLessThanK {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 7};
        int result = solution(nums, 8);
        System.out.println(result);
    }

    public static int solution(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int ans = 0;
        int left = 0;
        int curr = 1;

        for (int right = 0; right < nums.length; right++) {
            curr *= nums[right];
            while (curr >= k) {
                curr /= nums[left];
                left++; // A
            }

            ans += right - left + 1;
        }

        return ans;
    }
}
