package com.github.alex4790354.p04StacksAndQueues.p00Theory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


/** Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *  Implement the MovingAverage class:
 *  MovingAverage(int size) Initializes the object with the size of the window size.
 *  double next(int val) Returns the moving average of the last size values of the stream.
 *  Input:
 *      ["MovingAverage", "next", "next", "next", "next"]
 *      [[3], [1], [10], [3], [5]]
 * Output:
 *      [null, 1.0, 5.5, 4.66667, 6.0]
 */
public class T05MovingAverage {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(1, 2, 3, 5, 6, 7, 8, 9, 10));
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        //System.out.println(queue.);
    }


    private int size;
    private Queue<Integer> queue;
    private double sum;

    public T05MovingAverage(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
        this.sum = 0.0;
    }

    public double next(int val) {
        if (queue.size() == size) {
            sum -= queue.poll();
        }
        queue.offer(val);
        sum += val;
        return sum / queue.size();
    }
}
