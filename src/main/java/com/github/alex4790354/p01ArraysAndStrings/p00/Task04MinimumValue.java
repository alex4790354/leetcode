package com.github.alex4790354.p01ArraysAndStrings.p00;

public class Task04MinimumValue {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(minStartValue(nums));
    }

    private static int minStartValue(int[] nums) {
        int minSum = 0;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;
            minSum = Math.min(minSum, currentSum);
        }

        return 1 - minSum;
    }

}
