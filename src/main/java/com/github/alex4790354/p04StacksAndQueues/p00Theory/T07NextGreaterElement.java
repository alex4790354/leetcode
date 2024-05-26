package com.github.alex4790354.p04StacksAndQueues.p00Theory;

import java.util.*;

/** The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
 *  You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 *  For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2.
 *  If there is no next greater element, then the answer for this query is -1.
 *  Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

 *  Example: int[] nums1 = {4, 1, 2}; + int[] nums2 = {1, 3, 4, 2};  => Output: [-1,3,-1]
 *           int[] nums1 = [2,4], nums2 = [1,2,3,4]                  => Output: [3,-1]

 *           TODO: repeat it.
 */

public class T07NextGreaterElement {

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        T07NextGreaterElement nextGreaterElement = new T07NextGreaterElement();
        int[] result = nextGreaterElement.solution(nums1, nums2);

        for (int val : result) {
            System.out.print(val + " ");
        }
        // Output: [-1, 3, -1]
    }

    public int[] solution(int[] nums1, int[] nums2) {
        // Создаем хеш-таблицу для хранения следующего большего элемента для каждого числа из nums2
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                nextGreaterMap.put(stack.pop(), num);
            }
            stack.push(num);
        }


        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
        }

        return result;
    }

}
