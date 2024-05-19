package com.github.alex4790354.p01ArraysAndStrings.p00;


/** Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 *  Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 *  Output: 6
 *  Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 */
public class Task02MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(solution(nums, k));
    }

    private static int solution(int[] nums, int k) {
        int result = 0, leftBorder = 0, rightBorder = 0, flippedCount = 0;

        while (rightBorder < nums.length) {
            if (nums[rightBorder] == 0) {
                flippedCount++;
            }

            while (flippedCount > k) {
                if (nums[leftBorder] == 0) {
                    flippedCount--;
                }
                leftBorder++;
            }


            if (rightBorder + 1 - leftBorder > result) {
                result = rightBorder + 1 - leftBorder;
            }
            rightBorder++;
        }

        return result;
    }

}
