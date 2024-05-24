package com.github.alex4790354.p02Hashing.p00Theory;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;


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
