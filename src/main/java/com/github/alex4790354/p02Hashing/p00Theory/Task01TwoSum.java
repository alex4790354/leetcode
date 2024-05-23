package com.github.alex4790354.p02Hashing.p00Theory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** Given an array of integers nums and an integer target, return indices of two numbers such that they add up to target.
 *  You cannot use the same index twice.
 */
public class Task01TwoSum {

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);

        }

        return new int[] {-1, -1};
    }
}
