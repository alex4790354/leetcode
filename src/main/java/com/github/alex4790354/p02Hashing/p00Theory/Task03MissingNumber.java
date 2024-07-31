package com.github.alex4790354.p02Hashing.p00Theory;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 * Example1:
 * Input: nums = [3,0,1]             Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
 * 2 is the missing number in the range since it does not appear in nums.
 **/

public class Task03MissingNumber {

    public static void main(String[] args) {
        int[] nums = {0,1};
        System.out.println(solution(nums));
    }

    private static int solution(int[] nums) {
        int min = IntStream.of(nums).min().getAsInt();
        int max = IntStream.of(nums).max().getAsInt();
        Set<Integer> set = new HashSet<>();

        for (int i = min; i <= max; i++) {
            set.add(i);
        }
        for (int num : nums) {
            set.remove(num);
        }

        if (set.isEmpty()) {
            return max + 1;
        } else if (set.size() != 1) {
            return -1;
        }
        return set.iterator().next();
    }

}
