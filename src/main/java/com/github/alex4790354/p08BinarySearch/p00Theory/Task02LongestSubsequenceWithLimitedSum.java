package com.github.alex4790354.p08BinarySearch.p00Theory;

import java.util.Arrays;
import java.util.Collections;

/** You are given an integer array nums of length n, and an integer array queries of length m.
 *  Return an array answer of length m where answer[i] is the maximum size of a subsequence that you can take from nums such that the sum of its elements is less than or equal to queries[i].
 *  A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 *  nput: nums = [4,5,2,1], queries = [3,10,21]
 *  Output: [2,3,4]
 *  Explanation: We answer the queries as follows:
 *  - The subsequence [2,1] has a sum less than or equal to 3. It can be proven that 2 is the maximum size of such a subsequence, so answer[0] = 2.
 *  - The subsequence [4,5,1] has a sum less than or equal to 10. It can be proven that 3 is the maximum size of such a subsequence, so answer[1] = 3.
 *  - The subsequence [4,5,2,1] has a sum less than or equal to 21. It can be proven that 4 is the maximum size of such a subsequence, so answer[2] = 4.
 */
public class Task02LongestSubsequenceWithLimitedSum {

    public static void main(String[] args) {
        int[] nums = {4,5,2,1}, queries = {3, 10,21};
        Task02LongestSubsequenceWithLimitedSum test = new Task02LongestSubsequenceWithLimitedSum();
        System.out.println(Arrays.toString(test.answerQueries(nums, queries)));
    }

    public int[] answerQueries(int[] nums, int[] queries) {

        Arrays.sort(nums);
        int[] numsSumm = new int[nums.length];
        numsSumm[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            numsSumm[i] = numsSumm[i - 1] + nums[i];
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = binareySearch(numsSumm, queries[i]);
        }


        return result;
    }

    private int binareySearch(int[] numsSumm, int target) {
        if (numsSumm[0] > target)
            return 0;

        int left = 0, right = numsSumm.length - 1, mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (numsSumm[mid] == target)
                return mid + 1;
            else if (mid + 1 < numsSumm.length &&
                     numsSumm[mid] < target && numsSumm[mid + 1] > target)
                return mid + 1;
            else if (numsSumm[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left + 1;
    }

}
