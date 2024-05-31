package com.github.alex4790354.p06Heaps.p00Theory;

import java.util.PriorityQueue;

/** You have some number of sticks with positive integer lengths. These lengths are given as an array sticks, where sticks[i] is the length of the ith stick.
  * You can connect any two sticks of lengths x and y into one stick by paying a cost of x + y. You must connect all the sticks until there is only one stick remaining.
 *  Return the minimum cost of connecting all the given sticks into one stick in this way.

 *  Example: Input: sticks = [2,4,3]        Output: 14
 *  Explanation: You start with sticks = [2,4,3].
 *  1. Combine sticks 2 and 3 for a cost of 2 + 3 = 5. Now you have sticks = [5,4].
 *  2. Combine sticks 5 and 4 for a cost of 5 + 4 = 9. Now you have sticks = [9].
 *  There is only one stick left, so you are done. The total cost is 5 + 9 = 14. *
 */
public class T02MinimumCostToConnectSticks {

    public static void main(String[] args) {
        int[] sticks = {2,4,3};
        System.out.println(new T02MinimumCostToConnectSticks().solutin(sticks));
    }

    private int solutin(int[] sticks) {
        int stick1, stick2, result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int stick : sticks) {
            pq.add(stick);
        }

        while(pq.size() > 1) {
            stick1 = pq.poll();
            stick2 = pq.poll();
            result = result + stick1 + stick2;
            System.out.println(result);
            pq.add(stick1 + stick2);
        }
        return result;
    }
}
