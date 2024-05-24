package com.github.alex4790354.p02Hashing.p00Theory;

import java.util.HashMap;
import java.util.Map;

public class Task06LargestUniqueNumber {

    public static void main(String[] args) {
        int[] nums = {5, 7, 3, 9, 4, 9, 8, 3, 1};
        System.out.println(solution(nums));
    }

    private static int solution(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        int result = -1;

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        for (int key : counts.keySet()) {
            if (counts.get(key) == 1 && key > result) {
                result = key;
            }
        }
        return result;
    }
}
