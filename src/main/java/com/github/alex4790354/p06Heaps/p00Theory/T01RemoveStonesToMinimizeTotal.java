package com.github.alex4790354.p06Heaps.p00Theory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/** You are given a 0-indexed integer array piles, where piles[i] represents the number of stones in the ith pile,
 *  and an integer k. You should apply the following operation exactly k times:
 *  Choose any piles[i] and remove floor(piles[i] / 2) stones from it. *
 *
 *  Example:
 *  Input: piles = [5,4,9], k = 2.     Output: 12
 *  Explanation: Steps of a possible scenario are:
 * - Apply the operation on pile 2. The resulting piles are [5,4,5].
 * - Apply the operation on pile 0. The resulting piles are [3,4,5].
 * The total number of stones in [3,4,5] is 12.
 */
public class T01RemoveStonesToMinimizeTotal {

    public static void main(String[] args) {
        int[] piles = {5,4,9};
        int k = 2;
        System.out.println(new T01RemoveStonesToMinimizeTotal().minStoneSum(piles, k));
    }

    public int minStoneSum(int[] piles, int k) {
        int result = Arrays.stream(piles).sum();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : piles) {
            pq.add(i);
        }

        int stonesNum, removeNum;

        for (int i = 0; i < k; i++) {
            stonesNum = pq.remove();
            removeNum = (int) Math.floor((double) stonesNum / 2) ;
            pq.add(stonesNum - removeNum);
            System.out.println("stonesNum: " + stonesNum + ", removeNum: " + removeNum);
            result -= removeNum;
        }
        return result;
    }
}
