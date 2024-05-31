package com.github.alex4790354.p06Heaps.p00Theory;

import java.util.Comparator;
import java.util.PriorityQueue;


/** Given an integer array nums and an integer k, return the kth largest element in the array.
 *  Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *  Can you solve it without sorting?

 *  Example:  Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 *  Output: 4
 */
public class T03KthLargestElement {

    public static void main(String[] args) {
        int[] nums = {2, 1};
        int k = 2;
        System.out.println(new T03KthLargestElement().solution(nums, k));
    }

    private int solution(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : nums)
            pq.add(i);
        int result = - 1;
        if (pq.size() > 0)
            result = pq.peek();

        if (pq.size() >= k) {
            for (int i = 0; i < k; i++)
                result = pq.poll();
        }
        return result;
    }

}
