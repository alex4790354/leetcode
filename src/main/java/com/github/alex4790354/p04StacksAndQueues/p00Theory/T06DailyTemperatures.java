package com.github.alex4790354.p04StacksAndQueues.p00Theory;

import java.util.Stack;


/** Given an array of integers temperatures that represents the daily temperatures,
 *  return an array answer such that answer[i] is the number of days you have to wait after the i-th day to get a warmer temperature.
 *  If there is no future day that is warmer, have answer[i] = 0 instead.
 *  Example: temperatures = [34, 33, 32, 31, 30, 50]  => result: [5, 4, 3, 2, 1, 0]

 *  TODO: решить еще раз.
 *
  */
public class T06DailyTemperatures {

    public static void main(String[] args) {
        T06DailyTemperatures test = new T06DailyTemperatures();
        int[] temperatures = {34, 33, 32, 31, 30, 50, 10};
        int[] result = test.dailyTemperatures(temperatures);
        for (int t : result) {
            System.out.print(t + " ");
        }
    }

    private int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                int j = stack.pop();
                answer[j] = i - j;
            }

            stack.push(i);
        }

        return answer;
    }
}
