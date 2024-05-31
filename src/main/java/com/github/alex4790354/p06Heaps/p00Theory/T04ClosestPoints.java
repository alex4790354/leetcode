package com.github.alex4790354.p06Heaps.p00Theory;


import java.util.Comparator;
import java.util.PriorityQueue;

/** Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 *  The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 *  You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

 * Example:
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
 * Output: [[3,3],[-2,4]]
 * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 */
public class T04ClosestPoints {

    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);

        for (int i = 0; i < points.length; i++) {
            pq.offer(points[i]);
        }
        int[] temp = new int[2];
        for (int i = 0; i < k; i++) {
            temp = pq.poll();
            result[i][0] = temp[0];
            result[i][1] = temp[1];
        }

        return result;
    }
}
