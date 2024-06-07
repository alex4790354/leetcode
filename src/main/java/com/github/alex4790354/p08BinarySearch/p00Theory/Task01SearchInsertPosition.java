package com.github.alex4790354.p08BinarySearch.p00Theory;


/** Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *  You must write an algorithm with O(log n) runtime complexity.

 *  Example 1:  Input: nums = [1,3,5,6], target = 5     Output: 2
 *  Example 2:  Input: nums = [1,3,5,6], target = 2     Output: 1
 * Example 3:   Input: nums = [1,3,5,6], target = 7     Output: 4
 */
public class Task01SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,10};
        Task01SearchInsertPosition test = new Task01SearchInsertPosition();
        System.out.println(test.solutioon(nums, 2));
    }

    private int solutioon(int[] nums, int target) {
        int result = 0, left = 0, right = nums.length - 1, mid = 0;

        if (nums[left] >= target)
            return left;
        if (nums[right] == target)
            return right;
        if (nums[right] < target)
            return right + 1;

        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        if (left == nums.length)
            return left + 1;
        if (nums[left] >= target)
            return left;
        else
            return left + 1;
    }
}
