package com.github.alex4790354.p06Heaps.p00Theory;


import java.util.PriorityQueue;

/** Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *  Implement T05KthLargest class:
 *  T05KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
 *  int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.

 * Example: Input:
 *  ["T05KthLargest", "add", "add", "add", "add", "add"]
 *  [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * Output
 *  [null, 4, 5, 5, 8, 8]
 * Explanation
 * T05KthLargest kthLargest = new T05KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 */
public class T05KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int pqSize;

    public T05KthLargest(int k, int[] nums) {
        this.pqSize = k;
        for (int i : nums) {
            pq.add(i);
            if (pq.size() > this.pqSize)
                pq.poll();
        }
    }

    public int add(int val) {
        this.pq.add(val);
        while (pq.size() > this.pqSize)
            pq.remove();
        return pq.peek();
    }

}
