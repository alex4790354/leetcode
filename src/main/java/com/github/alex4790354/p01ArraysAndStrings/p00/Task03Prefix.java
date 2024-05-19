package com.github.alex4790354.p01ArraysAndStrings.p00;


/**
     Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
     Return the running sum of nums.
 */
public class Task03Prefix {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        for (int num : solution(nums))
            System.out.println(num);
    }

    private static int[] solution(int[] nums) {
        int[] prefix = new int[nums.length];

        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }

        return prefix;
    }
}
